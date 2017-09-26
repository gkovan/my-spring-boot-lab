package hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/hello/app.properties")
public class LanguageGreetingServiceConfig {
	
	@Value("string value")
	private String stringValue;
	
	@Value("${value.from.file}")
	private String valueFromFile;
	
	@Value("${listOfValues}")
	private String[] valuesArray;
	
	@Bean
	@ConditionalOnProperty(name = "language.name", havingValue="english", matchIfMissing = true)
	public LanguageGreetingService englishGreetingService() {
		printOutLocalVarValues();
	    return new EnglishLanguageGreetingService();
	}
	
	@Bean
	@ConditionalOnProperty(name = "language.name", havingValue="hebrew")
	public LanguageGreetingService frenchGreetingService() {
		printOutLocalVarValues();
	    return new HebrewLanguageGreetingService();
	}
	
	private void printOutLocalVarValues() {
		System.out.println("stringValue: " + stringValue);
		System.out.println("valueFromFile: " + valueFromFile);
		System.out.println("valuesArray: " + valuesArray[0]);
	}

}
