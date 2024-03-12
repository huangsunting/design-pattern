package com.bravo.other.ioc.container;

import com.bravo.other.ioc.container.annotation.Autowired;
import com.bravo.other.ioc.container.beandefinition.BeanDefinition;
import com.bravo.other.ioc.container.beandefinition.PropertyValues;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 在Spring中BeanFactory是一个接口，这边简化为具体类。
 * 集成了原本属于BeanDefinitionRegistry、BeanFactory、SingletonBeanRegistry的功能。
 */
public class BeanFactory {

    /**
     * BeanDefinitionMap，根据BeanDefinition创建Bean
     */
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);
    /**
     * 单例池，缓存单例bean，避免重复创建
     */
    private final Map<String, Object> singletonObjects = new HashMap<>();


    /******** BeanDefinition相关操作 *******/

    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        this.beanDefinitionMap.put(beanName, beanDefinition);
    }

    private BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new RuntimeException("No bean named '" + beanName + "' is defined");
        }
        return beanDefinition;
    }

    /******** Bean相关操作 *******/

    public Object getBean(String beanName) {
        Object sharedInstance = getSingleton(beanName);
        if (sharedInstance != null) {
            return sharedInstance;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition);
    }

    private Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    private Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object bean;
        try {
            // 实例化bean
            bean = createBeanInstance(beanDefinition);

            // 属性填充
            populateBean(beanName, beanDefinition, bean);

            // 初始化bean
            initializeBean(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new RuntimeException("Instantiation of bean '" + beanName + "' failed", e);
        }

        // 单例bean放入缓存中，下次不再重复创建
        if (beanDefinition.isSingleton()) {
            addSingleton(beanName, bean);
        }

        return bean;
    }

    private Object createBeanInstance(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        try {
            // 直接反射创建实例
            Constructor<?> constructor = beanClass.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }
    }

    private void populateBean(String beanName, BeanDefinition beanDefinition, Object bean) {
        Class<?> clazz = bean.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try {
            injectByAutowired(bean, fields, beanDefinition.getPropertyValues());
        } catch (Exception ex) {
            throw new RuntimeException("Error setting property values for bean: " + beanName, ex);
        }
    }

    private void initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
        // 省略初始化的实现，比如InitializingBean、init-method等
    }

    private void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

    public <T> T getBean(Class<T> requiredType) {
        List<String> beanNames = new ArrayList<>();
        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
            Class<?> beanClass = entry.getValue().getBeanClass();
            if (requiredType.isAssignableFrom(beanClass)) {
                beanNames.add(entry.getKey());
            }
        }
        if (beanNames.size() == 1) {
            return getBean(beanNames.get(0), requiredType);
        }
        throw new RuntimeException(requiredType + "expected single bean but found " + beanNames.size() + ": " + beanNames);
    }

    @SuppressWarnings("unchecked")
    public <T> T getBean(String name, Class<T> requiredType) {
        return ((T) getBean(name));
    }

    private void injectByAutowired(Object bean, Field[] fields, PropertyValues pvs) throws InvocationTargetException, IllegalAccessException {
        for (Field field : fields) {
            Autowired autowiredAnnotation = field.getAnnotation(Autowired.class);
            if (autowiredAnnotation != null) {
                Class<?> fieldType = field.getType();
                Object dependentBean = this.getBean(fieldType);
                BeanUtils.setProperty(bean, field.getName(), dependentBean);
                pvs.addPropertyValue(field.getName(), dependentBean);
            }
        }
    }

    public void preInstantiateSingletons() {
        beanDefinitionMap.forEach((beanName, beanDefinition) -> {
            // 单例 && 非延迟加载的bean，提前实例化
            if (beanDefinition.isSingleton() && !beanDefinition.isLazyInit()) {
                getBean(beanName);
            }
        });
    }
}
