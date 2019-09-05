package com.example.springbootreplacepropertiesconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.logging.LoggingApplicationListener;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringBootReplacePropertiesConfigApplication implements CommandLineRunner {
	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication();
		app.addListeners(new EnvironmentPreparedEventListener4LogConfig());
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(environment.getProperty(LoggingApplicationListener.CONFIG_PROPERTY));

	}
}
