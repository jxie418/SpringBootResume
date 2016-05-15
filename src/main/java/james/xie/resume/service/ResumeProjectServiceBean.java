package james.xie.resume.service;

import james.xie.resume.model.ResumeProject;
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
@Service(value="resumeProjectService")
@CacheConfig(cacheNames = "projects")
public class ResumeProjectServiceBean {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Cacheable
    public Collection<ResumeProject> findAll() {
        return mongoTemplate.findAll(ResumeProject.class);
    }

    @CachePut(
            value = "project",
            key ="#id")
    public ResumeProject findOne(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query,ResumeProject.class);
    }
    @CachePut(
            value = "project",
            key ="#project.id")
    public void create(ResumeProject project) {
        mongoTemplate.save(project,"Resume");
    }

    @CachePut(
            value = "project",
            key = "#project._id"
    )
    public ResumeProject update(ResumeProject project) {
        ResumeProject resumeProject = findOne(project.get_id());
        if (resumeProject == null) {
            return null;
        }
        Update update = new Update();
        if (project.getProjectName() != null)
            update.set("projectName",project.getProjectName());
        if (project.getDescription() != null)
            update.set("description",project.getDescription());
        if (project.getResponsibility() != null)
            update.set("responsibility",project.getResponsibility());
        if (project.getCompany() != null)
            update.set("company",project.getCompany());
        if (project.getTechnologies()!= null)
            update.set("technologies",project.getTechnologies());
        if (project.getRole() != null)
            update.set("role",project.getRole());
        if (project.getYear() != null)
            update.set("year",project.getYear());
        Query query = new Query(Criteria.where("_id").is(project.get_id()));
        mongoTemplate.updateFirst(query, update,ResumeProject.class);
        return mongoTemplate.findOne(query,ResumeProject.class);

    }

    @CacheEvict(value ="project",
            key = "#id")
    public void delete(String id) {
        ResumeProject resumeProject = findOne(id);
        mongoTemplate.remove(resumeProject);
    }

    @CacheEvict(
            value = "project",
            allEntries = true)
    public void evictCache() {

    }
}
