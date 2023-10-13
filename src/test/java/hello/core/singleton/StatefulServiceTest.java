package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    @DisplayName("싱글톤의 문제점")
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA : A사용자 10000원 주문
        statefulService1.order("userA",10000);

        //ThreadB : B사용자 20000원 주문
        statefulService2.order("userB",20000);

        //ThreadA: 사용자 A 주문금액 조회
        int price = statefulService1.getPrice();
        System.out.println("price = " + price);

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }

    @Test
    void statefulServiceSingleton2() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService2 statefulService1 = ac.getBean(StatefulService2.class);
        StatefulService2 statefulService2 = ac.getBean(StatefulService2.class);

        //ThreadA : A사용자 10000원 주문
        int userA_price = statefulService1.order("userA", 10000);

        //ThreadB : B사용자 20000원 주문
        int userB_price =statefulService2.order("userB",20000);

        //ThreadA: 사용자 A 주문금액 조회
        System.out.println("userA_price = " + userA_price);
        System.out.println("userB_price = " + userB_price);

        Assertions.assertThat(userA_price).isEqualTo(10000);

    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }

        @Bean
        public StatefulService2 statefulService2() {
            return new StatefulService2();
        }
    }
}