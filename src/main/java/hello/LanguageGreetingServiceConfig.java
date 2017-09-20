package hello;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LanguageGreetingServiceConfig {
	
	@Bean
	@ConditionalOnProperty(name = "language.name", havingValue="english", matchIfMissing = true)
	public LanguageGreetingService englishGreetingService() {
	    return new EnglishLanguageGreetingService();
	}
	
	@Bean
	@ConditionalOnProperty(name = "language.name", havingValue="hebrew")
	public LanguageGreetingService frenchGreetingService() {
	    return new HebrewLanguageGreetingService();
	}

}
