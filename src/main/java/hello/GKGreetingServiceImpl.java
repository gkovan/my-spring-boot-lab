package hello;

import org.springframework.stereotype.Service;

@Service
public class GKGreetingServiceImpl implements GKGreetingService {

	@Override
	public String gkGreet() {
		// TODO Auto-generated method stub
		return "Hello from Gerry";
	}

}
