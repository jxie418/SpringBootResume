package james.xie.resume.service;

import james.xie.resume.model.ResumeIntroduction;
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
@Service(value="resumeIntroductionService")
@CacheConfig(cacheNames = "introductions")
public class ResumeIntroductionServiceBean {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Cacheable
    public Collection<ResumeIntroduction> findAll() {
        return mongoTemplate.findAll(ResumeIntroduction.class);
    }

    @CachePut(
            value = "introduction",
            key ="#id")
    public ResumeIntroduction findOne(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query,ResumeIntroduction.class);
    }
    @CachePut(
            value = "introduction",
            key ="#introduction.id")
    public void create(ResumeIntroduction introduction) {
        mongoTemplate.save(introduction,"Introduction");
    }

    @CachePut(
            value = "introduction",
            key = "#introduction._id"
    )
    public ResumeIntroduction update(ResumeIntroduction introduction) {
        ResumeIntroduction resumeIntroduction = findOne(introduction.get_id());
        if (resumeIntroduction == null) {
            return null;
        }
        Query query = new Query(Criteria.where("_id").is(introduction.get_id()));
        Update update = new Update();
        if (introduction.getImageUrl() != null)
            update.set("imageUrl",introduction.getImageUrl());
        if (introduction.getIntroduction() != null )
            update.set("introduction",introduction.getIntroduction());
        mongoTemplate.updateFirst(query, update,ResumeIntroduction.class);
        return mongoTemplate.findOne(query,ResumeIntroduction.class);
    }

    @CacheEvict(value ="introduction",
            key = "#id")
    public void delete(String id) {
        ResumeIntroduction resumeSummary = findOne(id);
        mongoTemplate.remove(resumeSummary);
    }

    @CacheEvict(
            value = "introduction",
            allEntries = true)
    public void evictCache() {

    }
}
