package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    GKGreetingService gkGreetingService;
    
    @Autowired
    LanguageGreetingService languageGreetingService;

    
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
 
    @RequestMapping("/gkgreeting")
    public String gkGreeting() {
        return gkGreetingService.gkGreet();
    }
    
    @RequestMapping("/gklanguagegreeting")
    public String gkLanguageGreeting() {
        return languageGreetingService.languageGreeting();
    }

    

}
