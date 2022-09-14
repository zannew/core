package hellospring.core.singleton;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hellospring.core.AppConfig;
import hellospring.core.member.MemberService;

public class SingletonTest {

	@DisplayName("스프링 없는 순수한 DI 컨테이너")
	@Test
	void pureContainer() {
		AppConfig appConfig = new AppConfig();
		MemberService memberService1 = appConfig.memberService();
		MemberService memberService2 = appConfig.memberService();

		System.out.println("memberService1 = " + memberService1);
		System.out.println("memberService2 = " + memberService2);

		assertThat(memberService1).isNotSameAs(memberService2);

	}
}
