package hellospring.core.order;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hellospring.core.discount.FixDiscountPolicy;
import hellospring.core.member.Grade;
import hellospring.core.member.Member;
import hellospring.core.member.MemoryMemberRepository;

class OrderServiceImplTest {

	@Test
	void createOrder() {
		MemoryMemberRepository memberRepository = new MemoryMemberRepository();
		memberRepository.save(new Member(1L, "userA", Grade.VIP));

		OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
		Order order = orderService.createOrder(1L, "itemA", 10000);
		assertThat(order.getDiscountPrice()).isEqualTo(1000);

	}

}