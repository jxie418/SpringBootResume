package james.xie.resume.service;

import james.xie.resume.model.ResumeEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by jamesxieaudaexplorecom on 5/14/16.
 */
@Service(value="resumeEducationService")
@CacheConfig(cacheNames = "educations")
public class ResumeEducationServiceBean {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Cacheable
    public Collection<ResumeEducation> findAll() {
        return mongoTemplate.findAll(ResumeEducation.class);
    }

    @CachePut(
            value = "education",
            key ="#id")
    public ResumeEducation findOne(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query,ResumeEducation.class);
    }
    @CachePut(
            value = "education",
            key ="#education.id")
    public void create(ResumeEducation education) {
        mongoTemplate.save(education,"Education");
    }

    @CachePut(
            value = "education",
            key = "#education._id"
    )
    public ResumeEducation update(ResumeEducation education) {
        ResumeEducation resumeEducation = findOne(education.get_id());
        if (resumeEducation == null) {
            return null;
        }
        Update educationUpdate = new Update();

        if (education.getDegree() != null)
            educationUpdate.set("degree",education.getDegree());
        if (education.getGPA() != null)
            educationUpdate.set("GPA",education.getGPA());
        if (education.getLocation() != null)
            educationUpdate.set("location",education.getLocation());
        if (education.getMajor() != null)
            educationUpdate.set("major",education.getMajor());
        if  (education.getSchool() != null)
            educationUpdate.set("school",education.getSchool());
        if (education.getYear() != null)
            educationUpdate.set("year",education.getYear());

        Query query = new Query(Criteria.where("_id").is(education.get_id()));
        mongoTemplate.updateFirst(query, educationUpdate,ResumeEducation.class);
        return mongoTemplate.findOne(query,ResumeEducation.class);

    }

    @CacheEvict(value ="education",
            key = "#id")
    public void delete(String id) {
        ResumeEducation resumeEducation = findOne(id);
        mongoTemplate.remove(resumeEducation);
    }

    @CacheEvict(
            value = "education",
            allEntries = true)
    public void evictCache() {

    }
}
