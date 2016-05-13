package james.xie.resume.web.api;

import james.xie.resume.model.ResumeSummary;
import james.xie.resume.service.ResumeSummaryServiceBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Slf4j
@RestController
@RequestMapping(path = "/api/data", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ResumeDataController extends BaseController {


    @Autowired
    private ResumeSummaryServiceBean resumeSummaryService;

    @RequestMapping(
            path = "/summarys",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<ResumeSummary>> findAllSummary() {
        Collection<ResumeSummary> summaries = resumeSummaryService.findAll();
        return new ResponseEntity<>(summaries, HttpStatus.OK);
    }

    @RequestMapping(
            path = "/summary/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResumeSummary> getById(@PathVariable("id") String id) {
        ResumeSummary resumeSummary = resumeSummaryService.findOne(id);
        return new ResponseEntity<>(resumeSummary, HttpStatus.OK);
    }

    @RequestMapping(
            path = "/summary/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResumeSummary> updateSummary(@PathVariable("id") String id, @RequestBody ResumeSummary resumeSummary) {
        ResumeSummary updatedSummary = resumeSummaryService.update(resumeSummary);
        if (updatedSummary == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(resumeSummary, HttpStatus.OK);
        }
    }
    @RequestMapping(path="/summary",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResumeSummary> createSummary(@RequestBody ResumeSummary summary) {
            resumeSummaryService.create(summary);
        return new ResponseEntity<>(summary, HttpStatus.CREATED);
    }

}

