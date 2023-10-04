package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberSerive;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberSerive memberSerive = new MemberServiceImpl();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberSerive.join(member);

        Member findMember = memberSerive.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());


    }
}
