package james.xie.resume.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
//@EnableTransactionManagement
@EnableCaching
//@EnableScheduling
@EnableAuthorizationServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class JXResumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JXResumeApplication.class, args);
    }

}
