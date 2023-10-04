package hello.core.member;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberServiceTest {

    MemberSerive memberSerive = new MemberServiceImpl();
    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberSerive.join(member);
        Member findMember = memberSerive.findMember(1L);

        //then
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
}
