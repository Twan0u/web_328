package com.spring.henallux.buyMyBag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class BuyMyBagApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyMyBagApplication.class, args);
	}

}
