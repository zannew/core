package hellospring.core.scan;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hellospring.core.AutoAppConfig;
import hellospring.core.member.MemberRepository;
import hellospring.core.member.MemberService;
import hellospring.core.order.OrderService;
import hellospring.core.order.OrderServiceImpl;

public class AutoAppConfigTest {

	@Test
	void basicScan() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
		MemberService memberService = ac.getBean(MemberService.class);
		OrderServiceImpl orderService = ac.getBean(OrderServiceImpl.class);

		assertThat(memberService).isInstanceOf(MemberService.class);
		assertThat(orderService).isInstanceOf(OrderService.class);

		MemberRepository memberRepository = orderService.getMemberRepository();
		System.out.println("memberRepository = " + memberRepository);
	}
}
