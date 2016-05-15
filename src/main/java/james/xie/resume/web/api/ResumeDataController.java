package james.xie.resume.web.api;

import james.xie.resume.model.*;
import james.xie.resume.service.*;
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

    @Autowired
    private ResumeProjectServiceBean resumeProjectServiceBean;

    @Autowired
    private ResumeEducationServiceBean resumeEducationServiceBean;

    @Autowired
    private ResumeIntroductionServiceBean resumeIntroductionServiceBean;

    @Autowired
    private ResumeWorkExperienceServiceBean resumeWorkExperienceServiceBean;

    @RequestMapping(
            path = "/summaries",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<ResumeSummary>> findAllSummary() {
        Collection<ResumeSummary> summaries = resumeSummaryService.findAll();
        return new ResponseEntity<>(summaries, HttpStatus.OK);
    }

    @RequestMapping(
            path = "/projects",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<ResumeProject>> findAllProject() {
        Collection<ResumeProject> projects = resumeProjectServiceBean.findAll();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @RequestMapping(
            path = "/educations",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<ResumeEducation>> findAllEducation() {
        Collection<ResumeEducation> projects = resumeEducationServiceBean.findAll();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @RequestMapping(
            path = "/introduction",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<ResumeIntroduction>> findAllIntroduction() {
        Collection<ResumeIntroduction> introductions = resumeIntroductionServiceBean.findAll();
        return new ResponseEntity<>(introductions, HttpStatus.OK);
    }

    @RequestMapping(
            path = "/workExperience",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<ResumeWorkExperience>> findAllWorkExperience() {
        Collection<ResumeWorkExperience> workExperiences = resumeWorkExperienceServiceBean.findAll();
        return new ResponseEntity<>(workExperiences, HttpStatus.OK);
    }

    @RequestMapping(
            path = "/summary/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResumeSummary> getSummaryById(@PathVariable("id") String id) {
        ResumeSummary resumeSummary = resumeSummaryService.findOne(id);
        return new ResponseEntity<>(resumeSummary, HttpStatus.OK);
    }

    @RequestMapping(
            path = "/workExperience/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResumeWorkExperience> getWorkExperienceById(@PathVariable("id") String id) {
        ResumeWorkExperience resumeWorkExperience = resumeWorkExperienceServiceBean.findOne(id);
        return new ResponseEntity<>(resumeWorkExperience, HttpStatus.OK);
    }

    @RequestMapping(
            path = "/education/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResumeEducation> getEducationById(@PathVariable("id") String id) {
        ResumeEducation resumeEducation = resumeEducationServiceBean.findOne(id);
        return new ResponseEntity<>(resumeEducation, HttpStatus.OK);
    }

    @RequestMapping(
            path = "/introduction/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResumeIntroduction> getIntroductionById(@PathVariable("id") String id) {
        ResumeIntroduction resumeIntroduction = resumeIntroductionServiceBean.findOne(id);
        return new ResponseEntity<>(resumeIntroduction, HttpStatus.OK);
    }

    @RequestMapping(
            path = "/project/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResumeProject> getProjectById(@PathVariable("id") String id) {
        ResumeProject resumeProject = resumeProjectServiceBean.findOne(id);
        return new ResponseEntity<>(resumeProject, HttpStatus.OK);
    }

    @RequestMapping(
            path = "/education/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResumeEducation> updateWorkExperience(@PathVariable("id") String id, @RequestBody ResumeEducation resumeEducation) {
        ResumeEducation updatedEducation = resumeEducationServiceBean.update(resumeEducation);
        if (updatedEducation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updatedEducation, HttpStatus.OK);
        }
    }

    @RequestMapping(
            path = "/workExperience/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResumeWorkExperience> updateWorkExperience(@PathVariable("id") String id, @RequestBody ResumeWorkExperience resumeWorkExperience) {
        ResumeWorkExperience updatedWorkExperience = resumeWorkExperienceServiceBean.update(resumeWorkExperience);
        if (updatedWorkExperience == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updatedWorkExperience, HttpStatus.OK);
        }
    }

    @RequestMapping(
            path = "/project/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResumeProject> updateProject(@PathVariable("id") String id, @RequestBody ResumeProject resumeProject) {
        ResumeProject updateResumeProject = resumeProjectServiceBean.update(resumeProject);
        if (updateResumeProject == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updateResumeProject, HttpStatus.OK);
        }
    }

    @RequestMapping(
            path = "/introduction/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResumeIntroduction> updateIntroduction(@PathVariable("id") String id, @RequestBody ResumeIntroduction resumeIntroduction) {
        ResumeIntroduction updatedResumeIntroduction = resumeIntroductionServiceBean.update(resumeIntroduction);
        if (updatedResumeIntroduction == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updatedResumeIntroduction, HttpStatus.OK);
        }
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


    @RequestMapping(path="/introduction",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResumeIntroduction> createEducation(@RequestBody ResumeIntroduction introduction) {
        resumeIntroductionServiceBean.create(introduction);
        return new ResponseEntity<>(introduction, HttpStatus.CREATED);
    }

    @RequestMapping(path="/workExperience",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResumeWorkExperience> createEducation(@RequestBody ResumeWorkExperience workExperience) {
        resumeWorkExperienceServiceBean.create(workExperience);
        return new ResponseEntity<>(workExperience, HttpStatus.CREATED);
    }

    @RequestMapping(path="/project",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResumeProject> createEducation(@RequestBody ResumeProject project) {
        resumeProjectServiceBean.create(project);
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }

    @RequestMapping(path="/education",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResumeEducation> createEducation(@RequestBody ResumeEducation education) {
        resumeEducationServiceBean.create(education);
        return new ResponseEntity<>(education, HttpStatus.CREATED);
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

