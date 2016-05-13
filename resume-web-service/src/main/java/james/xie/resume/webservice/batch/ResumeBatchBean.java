package james.xie.resume.webservice.batch;

import james.xie.resume.webservice.models.ResumeSummary;
import james.xie.resume.webservice.service.impl.ResumeSummaryServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by jamesxieaudaexplorecom on 5/7/16.
 */
@Slf4j
@Component
public class ResumeBatchBean {

    @Autowired
    private ResumeSummaryServiceImpl resumeSummaryService;

    //@Scheduled(cron = "3 * * * * *")
    public void cronJob() {
        log.info("> cronJob");
        Collection<ResumeSummary> summaries = resumeSummaryService.findAll();
        log.info("There are {} summaries n the MongoDB",summaries.size());
        log.info("< cronJob");
    }

   /* @Scheduled(
            initialDelay = 5000,
            fixedRate = 15000)*/
    public void cronJob2() {
        log.info("> cronJob2");
        Collection<ResumeSummary> summaries = resumeSummaryService.findAll();
        log.info("There are {} summaries n the MongoDB",summaries.size());
        log.info("< cronJob2");
    }

    /*@Scheduled(
            initialDelay = 5000,
            fixedDelay = 15000)*/
    public void cronJob3() {
        log.info("> cronJob3");
        Collection<ResumeSummary> summaries = resumeSummaryService.findAll();
        log.info("There are {} summaries n the MongoDB",summaries.size());
        log.info("< cronJob3");
    }
}
