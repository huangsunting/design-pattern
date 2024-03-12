package com.bravo.other.ioc;


import com.bravo.other.ioc.bean.User;
import com.bravo.other.ioc.container.ApplicationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ApplicationContextTest {

    /**
     * 如果说BeanFactory+扫描是手动挡，什么都需要自己去组合，那么ApplicationContext就是自动挡
     */
    @Test
    public void testApplicationContext() {
        ApplicationContext applicationContext = new ApplicationContext("com.bravo.other.ioc.bean");
        User user1 = applicationContext.getBean("user", User.class);
        User user2 = applicationContext.getBean("user", User.class);
        Assertions.assertEquals(user1, user2);
    }
}
