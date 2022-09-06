package hellospring.core;

import hellospring.core.discount.DiscountPolicy;
import hellospring.core.discount.RateDiscountPolicy;
import hellospring.core.member.MemberRepository;
import hellospring.core.member.MemberService;
import hellospring.core.member.MemberServiceImpl;
import hellospring.core.member.MemoryMemberRepository;
import hellospring.core.order.OrderService;
import hellospring.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
