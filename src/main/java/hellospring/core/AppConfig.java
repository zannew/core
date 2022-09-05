package hellospring.core;

import hellospring.core.discount.DiscountPolicy;
import hellospring.core.discount.RateDiscountPolicy;
import hellospring.core.member.MemberRepository;
import hellospring.core.member.MemberService;
import hellospring.core.member.MemberServiceImpl;
import hellospring.core.member.MemoryMemberRepository;
import hellospring.core.order.OrderService;
import hellospring.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    private DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
