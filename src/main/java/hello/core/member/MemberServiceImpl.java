package hello.core.member;

public class MemberServiceImpl implements MemberSerive{

    //인터페이스에도 의존하고 구현체에도 의존하여 DIP위반
    //    private final MemberRepository memberRepository = new MemoryMemberRepository();

    //AppConfig(외부)에서 생성자를 생성하여 주입해주고있음.
    private final MemberRepository memberRepository;
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
}
