package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeTest {

    @Test
    void singletonBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

        PrototypeBean p1 = ac.getBean(PrototypeBean.class);
        PrototypeBean p2 = ac.getBean(PrototypeBean.class);

        System.out.println(p1);
        System.out.println(p2);

        Assertions.assertThat(p1).isNotSameAs(p2);

        ac.close();

    }

    @Scope("prototype")
    static class PrototypeBean {
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
