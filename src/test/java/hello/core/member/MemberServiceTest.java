package hello.core.member;


import hello.core.AppConfig;
import hello.core.order.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberServiceTest {
    MemberSerive memberSerive;
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberSerive = appConfig.memberSerive();
    }

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
