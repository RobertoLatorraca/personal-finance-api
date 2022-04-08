package ar.latorraca.finance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class PersonalFinanceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalFinanceApiApplication.class, args);
	}

}
