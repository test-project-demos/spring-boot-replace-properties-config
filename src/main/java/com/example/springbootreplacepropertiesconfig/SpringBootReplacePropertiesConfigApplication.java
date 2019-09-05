package com.example.springbootreplacepropertiesconfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.logging.LoggingApplicationListener;
import org.springframework.core.env.Environment;

@Slf4j
@SpringBootApplication
public class SpringBootReplacePropertiesConfigApplication implements CommandLineRunner {
	@Autowired
	private Environment environment;

	@Autowired
	private TestEmbeddedValue testEmbeddedValue;

	@Autowired
	private TestPrefixValue testPrefixValue;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringBootReplacePropertiesConfigApplication.class);
		app.addListeners(new EnvironmentPreparedEventListener4LogConfig());
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.warn("after BeanFactoryPostProcessor4Config, xxx-key = {}", testEmbeddedValue.getConfigValue());
		log.warn("after EnvironmentPreparedEventListener4LogConfig, {} = {}", LoggingApplicationListener.CONFIG_PROPERTY,
			environment.getProperty(LoggingApplicationListener.CONFIG_PROPERTY));
		log.warn(testPrefixValue.getKey());
	}
}
