package james.xie.resume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JamesxieresumeApplication {

	public static void main(String[] args) {
		SpringApplication.run(JamesxieresumeApplication.class, args);
	}
}
