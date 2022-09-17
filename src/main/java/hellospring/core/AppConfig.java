package hellospring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hellospring.core.discount.DiscountPolicy;
import hellospring.core.discount.RateDiscountPolicy;
import hellospring.core.member.MemberRepository;
import hellospring.core.member.MemberService;
import hellospring.core.member.MemberServiceImpl;
import hellospring.core.member.MemoryMemberRepository;
import hellospring.core.order.OrderService;
import hellospring.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    // @Bean memberSerivce -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
