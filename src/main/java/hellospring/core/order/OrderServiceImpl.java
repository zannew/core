package hellospring.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hellospring.core.discount.DiscountPolicy;
import hellospring.core.member.Member;
import hellospring.core.member.MemberRepository;

@Component
public class OrderServiceImpl implements OrderService {

    // 1. 생성자 주입 방식
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // 2. setter 주입 방식
    // private MemberRepository memberRepository;
    // private DiscountPolicy discountPolicy;

    // 3. 필드 주입 방식 (not recommended)
    // @Autowired private MemberRepository memberRepository;
    // @Autowired private DiscountPolicy discountPolicy;

    // 1. 생성자 주입 방식
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("생성자 주입 방식");
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // 2. setter 주입 방식
    // @Autowired
    // public void setMemberRepository(MemberRepository memberRepository) {
    //     System.out.println("setter 방식 -> memberRepository = " + memberRepository);
    //     this.memberRepository = memberRepository;
    // }

    // @Autowired
    // public void setDiscountPolicy(DiscountPolicy discountPolicy) {
    //     System.out.println("setter 방식 -> discountPolicy = " + discountPolicy);
    //     this.discountPolicy = discountPolicy;
    // }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // for test
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
