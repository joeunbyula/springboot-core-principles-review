package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberSerive;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    //역할과 구현을 명확하게 분리
    //프로그램의 제어의흐름을 외부에서 관리한다 == 제어의 역전(IoC)
    
    //구현
    public MemberSerive memberSerive() {
        return new MemberServiceImpl(memberRepository());
    }

    //역할
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
