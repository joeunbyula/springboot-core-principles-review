package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberSerive;
import hello.core.order.Order;
import hello.core.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberSerive memberSerive = appConfig.memberSerive();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberSerive.join(member);

        Order order = orderService.createOrder(memberId, "item", 10000);
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());

    }
}
