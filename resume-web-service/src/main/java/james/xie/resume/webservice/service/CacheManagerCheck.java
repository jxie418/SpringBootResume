package james.xie.resume.webservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

/**
 * Created by jamesxieaudaexplorecom on 5/7/16.
 */
@Slf4j
@Component
public class CacheManagerCheck implements CommandLineRunner {

    @Autowired
    private  CacheManager cacheManager;

    @Override
    public void run(String... strings) throws Exception {
        log.info("\n\n" + "=========================================================\n"
                + "Using cache manager: " + this.cacheManager.getClass().getName() + "\n"
                + "=========================================================\n\n");
    }
}
