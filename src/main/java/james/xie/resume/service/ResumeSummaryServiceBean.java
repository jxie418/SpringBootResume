package james.xie.resume.service;

import james.xie.resume.model.ResumeSummary;
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
 * Created by jamesxieaudaexplorecom on 5/6/16.
 */
@Service(value="resumeSummaryService")
@CacheConfig(cacheNames = "summaries")
public class ResumeSummaryServiceBean{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Cacheable
    //@Override
    public Collection<ResumeSummary> findAll() {
        return mongoTemplate.findAll(ResumeSummary.class);
    }

    @CachePut(
            value = "summary",
            key ="#id")
    public ResumeSummary findOne(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query,ResumeSummary.class);
    }
    @CachePut(
            value = "summary",
            key ="#summary.id")
    //@Override
    public void create(ResumeSummary summary) {
        mongoTemplate.save(summary,"Summary");
    }

    @CachePut(
            value = "summary",
            key = "#resumeSummary._id"
    )
    //@Override
    public ResumeSummary update(ResumeSummary summary) {
       ResumeSummary resumeSummary = findOne(summary.get_id());
        if (resumeSummary == null) {
            return null;
        }
        Query query = new Query(Criteria.where("_id").is(summary.get_id()));
        mongoTemplate.updateFirst(query,
                Update.update("summaryInfo",summary.getSummaryInfo()),ResumeSummary.class);
        return mongoTemplate.findOne(query,ResumeSummary.class);

    }

   @CacheEvict(value ="summary",
        key = "#id")
   //@Override
    public void delete(String id) {
        ResumeSummary resumeSummary = findOne(id);
        mongoTemplate.remove(resumeSummary);
    }

    @CacheEvict(
            value = "summary",
            allEntries = true)
    //@Override
    public void evictCache() {

    }
}
