package in.patil.mummy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MummyApplication {

	public static void main(String[] args) {

		MyController.myMethod();
		MyController.requestMethodName();

		ConfigurableApplicationContext context = SpringApplication.run(MummyApplication.class, args);

		MyController obj = context.getBean(MyController.class);
	}

}
