package com.bravo.other.ioc;


import com.bravo.other.ioc.bean.Company;
import com.bravo.other.ioc.bean.Department;
import com.bravo.other.ioc.bean.Person;
import com.bravo.other.ioc.bean.Student;
import com.bravo.other.ioc.container.BeanFactory;
import com.bravo.other.ioc.container.scanner.ClassPathBeanDefinitionScanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BeanFactoryTest {

    private final BeanFactory beanFactory = new BeanFactory();

    @BeforeEach
    public void loadBeanDefinitions() {
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(beanFactory);
        scanner.doScan("com.bravo.other.ioc.bean");
    }

    @Test
    public void testBeanFactory() {
        Department department = beanFactory.getBean("department", Department.class);
        Assertions.assertNotNull(department);
    }

    @Test
    public void testSingleton() {
        Department department1 = beanFactory.getBean("department", Department.class);
        Department department2 = beanFactory.getBean("department", Department.class);
        Assertions.assertEquals(department1, department2);
    }

    @Test
    public void testPrototype() {
        Person person1 = beanFactory.getBean("person", Person.class);
        Person person2 = beanFactory.getBean("person", Person.class);
        Assertions.assertEquals(person1, person2);
    }

    @Test
    public void testComponentAlias() {
        Student student = beanFactory.getBean("studentAlias", Student.class);
        Assertions.assertNotNull(student);
    }

    @Test
    public void testAutowired() {
        Company company = beanFactory.getBean("company", Company.class);
        Department department = beanFactory.getBean("department", Department.class);
        Assertions.assertEquals(company.getDepartment(), department);
    }

    @Test
    public void testCircularDependency() {
        // TO~DO 如果在Department中依赖Company，将会产生循环依赖。
        // 要在当前实现中解决循环依赖其实很简单，只需要把BeanFactory#createBean中的addSingle()移到createBeanInstance()后
    }
}
