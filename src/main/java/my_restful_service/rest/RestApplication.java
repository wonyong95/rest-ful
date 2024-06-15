package my_restful_service.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RestApplication {

	public static void main(String[] args) {

		SpringApplication.run(RestApplication.class, args);

//		String[] allBeanNames =ac.getBeanDefinitionNames();
//		for (String beanName : allBeanNames) {
//			System.out.println(beanName);
//		}
	}

}
