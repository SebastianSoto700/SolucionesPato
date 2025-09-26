package com.example.Integrador2;

import com.example.Integrador2.config.RsaKeyCon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyCon.class)
public class aIntegrador2Application {

	public static void main(String[] args) {
		SpringApplication.run(aIntegrador2Application.class, args);
	}


}
