package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //스프링 전환!
public class AppConfig {

    //역할과 구현을 명확하게 분리
    //프로그램의 제어의흐름을 외부에서 관리한다 == 제어의 역전(IoC)
    
    //구현
    @Bean //@Bean을 등록함으로써 스프링컨테이너에 등록 -> 스프링 빈
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    //역할
    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
