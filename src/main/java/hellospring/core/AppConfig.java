package hellospring.core;

import hellospring.core.discount.FixDiscountPolicy;
import hellospring.core.member.MemberService;
import hellospring.core.member.MemberServiceImpl;
import hellospring.core.member.MemoryMemberRepository;
import hellospring.core.order.OrderService;
import hellospring.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
