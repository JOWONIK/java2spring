package hello.core.singletonTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService s1 = ac.getBean(StatefulService.class);
        StatefulService s2 = ac.getBean(StatefulService.class);

        int userAprice = s1.order("userA", 10000);
        int userBprice = s2.order("userB", 20000);

        System.out.println("User A price = " + userAprice);

        Assertions.assertThat(userAprice).isNotEqualTo(userBprice);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}