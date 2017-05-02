package com.example;

import com.example.models.Account;
import com.example.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class AuthServiceApplication {

	@Bean
	CommandLineRunner demo(AccountRepository accountRepository){
		return args -> Stream.of("atef,password1", "admin,password2")
						.map(tpl -> tpl.split(","))
						.forEach(tpl -> accountRepository.save(new Account(tpl[0], tpl[1], true)));
	}

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}
}
