package hellospring.core.beandefinition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import hellospring.core.AppConfig;

public class BeanDefinitionTest {

	// annotation 방식
	AnnotationConfigApplicationContext annotationAc = new AnnotationConfigApplicationContext(AppConfig.class);
	// xml 방식
	GenericXmlApplicationContext xmlAc = new GenericXmlApplicationContext("appConfig.xml");

	@DisplayName("빈 설정 메타정보 확인 - annotation")
	@Test
	void findApplicationBeanByAnnotation() {
		String[] beanDefinitionNames = annotationAc.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefinition = annotationAc.getBeanDefinition(beanDefinitionName);

			if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
				System.out.println("beanDefinitionName = " + beanDefinitionName + " /  beanDefinition = " + beanDefinition);
			}
		}
	}

	@DisplayName("빈 설정 메타정보 확인 - xml")
	@Test
	void findApplicationBeanByXml() {
		String[] beanDefinitionNames = xmlAc.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefinition = xmlAc.getBeanDefinition(beanDefinitionName);

			if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
				System.out.println("beanDefinitionName = " + beanDefinitionName + " /  beanDefinition = " + beanDefinition);
			}
		}
	}
}
