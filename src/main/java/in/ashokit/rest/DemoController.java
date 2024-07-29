package in.ashokit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class DemoController {

	@GetMapping("/redis")
	@CircuitBreaker(fallbackMethod= "m2" , name = "ashokit")
	public String m1() {
		System.out.println("Redis method called");
		//logic to fetch data from redis
		int i=10/0;
		return "Fetch Data From redis";
	}

	@GetMapping("/db")
	public String m2(Throwable t) {
		System.out.println("DB method called");
		//logic to fetch data from db
		return "Fecth Data From DB";
	}
}

