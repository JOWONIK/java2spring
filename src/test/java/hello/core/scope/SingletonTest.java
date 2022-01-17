package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonTest {

    @Test
    void singletonBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);

        SingletonBean s1 = ac.getBean(SingletonBean.class);
        SingletonBean s2 = ac.getBean(SingletonBean.class);

        ac.close();

    }

    @Scope("singleton")
    static class SingletonBean {
        @PostConstruct
        public void init() {
            System.out.println("post construct");
        }

        @PreDestroy
        public void close() {
            System.out.println("pre destroy");
        }
    }
}
