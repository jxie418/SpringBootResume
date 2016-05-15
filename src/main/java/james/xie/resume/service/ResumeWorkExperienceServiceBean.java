package james.xie.resume.service;

import james.xie.resume.model.ResumeWorkExperience;
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
@Service(value="resumeWorkExperienceService")
@CacheConfig(cacheNames = "workExperiences")
public class ResumeWorkExperienceServiceBean {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Cacheable
    public Collection<ResumeWorkExperience> findAll() {
        return mongoTemplate.findAll(ResumeWorkExperience.class);
    }

    @CachePut(
            value = "workExperience",
            key ="#id")
    public ResumeWorkExperience findOne(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query,ResumeWorkExperience.class);
    }
    @CachePut(
            value = "workExperience",
            key ="#workExperience.id")
    public void create(ResumeWorkExperience workExperience) {
        mongoTemplate.save(workExperience,"WorkExperience");
    }

    @CachePut(
            value = "workExperience",
            key = "#workExperience._id"
    )
    public ResumeWorkExperience update(ResumeWorkExperience workExperience) {
        ResumeWorkExperience resumeWorkExperience = findOne(workExperience.get_id());
        if (resumeWorkExperience == null) {
            return null;
        }
        Query query = new Query(Criteria.where("_id").is(workExperience.get_id()));
        Update update = new Update();
        if (workExperience.getCompanyName() != null)
            update.set("companyName",workExperience.getCompanyName());
        if (workExperience.getLocation() != null)
            update.set("location",workExperience.getLocation());
        if (workExperience.getManager() != null)
            update.set("manager",workExperience.getManager());
        if (workExperience.getPosition() != null)
            update.set("position",workExperience.getPosition());
        if (workExperience.getYear() != null)
            update.set("year",workExperience.getYear());
        mongoTemplate.updateFirst(query, update, ResumeWorkExperience.class);
        return mongoTemplate.findOne(query,ResumeWorkExperience.class);

    }

    @CacheEvict(value ="workExperience",
            key = "#id")
    public void delete(String id) {
        ResumeWorkExperience resumeWorkExperience = findOne(id);
        mongoTemplate.remove(resumeWorkExperience);
    }

    @CacheEvict(
            value = "workExperience",
            allEntries = true)
    public void evictCache() {

    }
}
