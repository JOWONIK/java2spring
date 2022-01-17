package hello.core.singletonTest;

import hello.core.AppConfig;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        MemberService memberService1 = appConfig.memberService();

        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberSErvic1 = " + memberService1);
        System.out.println("memberSErvic2 = " + memberService2);

        Assertions.assertThat(memberService1).isNotEqualTo(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonServcie s1 = SingletonServcie.getInstance();
        SingletonServcie s2 = SingletonServcie.getInstance();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);

        Assertions.assertThat(s1).isSameAs(s2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
//        AppConfig appConfig = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println("memberSErvic1 = " + memberService1);
        System.out.println("memberSErvic2 = " + memberService2);

        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
