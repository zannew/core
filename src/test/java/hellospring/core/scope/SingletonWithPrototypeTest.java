package hellospring.core.scope;

import static org.assertj.core.api.Assertions.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonWithPrototypeTest {

	@Test
	void prototypeFind() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
		PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
		prototypeBean1.addCount();
		assertThat(prototypeBean1.getCount()).isEqualTo(1);

		PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
		prototypeBean2.addCount();
		assertThat(prototypeBean2.getCount()).isEqualTo(1);

	}

	@Scope("prototype")
	static class   PrototypeBean {
		private int count = 0;
		public void addCount() {
			count++;
		}

		public int getCount() {
			return count;
		}

		@PostConstruct
		public void init() {
			System.out.println("PrototypeBean.init = " + this);
		}

		@PreDestroy
		public void destroy() {
			System.out.println("PrototypeBean.destroy = " + this);
		}
	}

	@Test
	void singletonClientUserPrototype() {

		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

		ClientBean clientBean1 = ac.getBean(ClientBean.class);
		int count1 = clientBean1.logic();
		assertThat(count1).isEqualTo(1);

		ClientBean clientBean2 = ac.getBean(ClientBean.class);
		int count2 = clientBean2.logic();
		assertThat(count2).isEqualTo(1);

	}

	@Scope("singleton")
	static class ClientBean {
		// ClientBean 생성 시점에 PrototypeBean 주압 x01

		@Autowired
		private Provider<PrototypeBean> prototypeBeanProvider;

		public int logic() {
			PrototypeBean prototypeBean = prototypeBeanProvider.get();
			prototypeBean.addCount();
			return prototypeBean.getCount();
		}
	}

	/*
	@Scope("singleton")
	static class ClientBean2 {
		// ClientBean 생성 시점에 PrototypeBean 주압 x02
		private final PrototypeBean prototypeBean;

		@Autowired
		public ClientBean2(PrototypeBean prototypeBean) {
			this.prototypeBean = prototypeBean;
		}

		public int logic() {
			prototypeBean.addCount();
			return prototypeBean.getCount();
		}
	}
	 */
}
