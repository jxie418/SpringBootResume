package james.xie.resume.webservice.service;

import james.xie.resume.webservice.models.ResumeSummary;

import java.util.Collection;

/**
 * Created by jamesxieaudaexplorecom on 5/6/16.
 */
public interface ResumeSummaryService {
    Collection<ResumeSummary> findAll();
    ResumeSummary findOne(String id);
    void create(ResumeSummary summary);
    ResumeSummary update(ResumeSummary summary);
    void delete(String id);
    void evictCache();
}
