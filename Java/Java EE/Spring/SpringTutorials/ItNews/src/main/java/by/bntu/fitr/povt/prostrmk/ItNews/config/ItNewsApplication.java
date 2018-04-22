package by.bntu.fitr.povt.prostrmk.ItNews.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Properties;

@SpringBootApplication
@ComponentScan(value = "by.bntu.fitr.povt.prostrmk.ItNews.controller")
public class ItNewsApplication {

	public static void main(String[] args) {
//		SpringApplication springApplication = new SpringApplication(ItNewsApplication.class);
//		Properties properties = new Properties();
//		properties.setProperty("spring.resources.static-locations", "class")
		SpringApplication.run(ItNewsApplication.class, args);
	}


}
