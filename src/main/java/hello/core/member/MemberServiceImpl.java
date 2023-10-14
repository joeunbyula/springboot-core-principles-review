package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    //인터페이스에도 의존하고 구현체에도 의존하여 DIP위반
    //    private final MemberRepository memberRepository = new MemoryMemberRepository();

    //AppConfig(외부)에서 생성자를 생성하여 주입해주고있음.
    private final MemberRepository memberRepository;

    @Autowired //@Component를 붙이면서 자동 의존관계 주입을 해준다.
    public MemberServiceImpl(MemoryMemberRepository memoryMemberRepository) {
        this.memberRepository = memoryMemberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
