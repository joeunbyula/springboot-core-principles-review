package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    //1) 인터페이스에도 의존, 구현체에도 의존하고있는 문제점이 발생!
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    //2) 생성자 의존성 주입(Best!!)
    private final DiscountPolicy discountPolicy;
    private final MemberRepository memberRepository;
//
//    //@Autowired //생성자가 하나인 경우엔 생략 가능!
    public OrderServiceImpl(MemberRepository memberRepository,DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //3)수정자 주입 (@AutoWired(required=false)를 사용하면 선택적으로 사용가능(빈에 등록이 되어있지 않아도 사용가능)
//    private DiscountPolicy discountPolicy;
//    private MemberRepository memberRepository;
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    //4) 필드 주입 ( 권장하지않는 방법이다.. 외부에서 변경이 불가능하다 setter를 만들어야해서 좋지않다.)
//    @Autowired private MemberRepository memberRepository;
//    @Autowired private DiscountPolicy discountPolicy;

    //5) 일반 메서드 주입(일반적으로 사용안함)
//    private DiscountPolicy discountPolicy;
//    private MemberRepository memberRepository;
//    @Autowired
//    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member findMember = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(findMember, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
