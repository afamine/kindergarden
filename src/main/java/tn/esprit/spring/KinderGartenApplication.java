package tn.esprit.spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"tn.esprit.spring"})
public class KinderGartenApplication {

	public static void main(String[] args) {
		SpringApplication.run(KinderGartenApplication.class, args);
	}
	

}
