package hellospring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import hellospring.core.member.MemberRepository;
import hellospring.core.member.MemoryMemberRepository;

@Configuration
@ComponentScan(
	// basePackages = "hellospring.core.member",
	excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

	@Bean(name = "memoryMemberRepository")
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
}
