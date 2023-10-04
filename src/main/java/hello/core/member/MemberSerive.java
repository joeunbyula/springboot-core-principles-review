package hello.core.member;

public interface MemberSerive {
    void join(Member member);

    Member findMember(Long memberId);
}
