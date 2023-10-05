package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberSerive;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberSerive memberSerive = appConfig.memberSerive();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberSerive.join(member);

        Member findMember = memberSerive.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());


    }
}
