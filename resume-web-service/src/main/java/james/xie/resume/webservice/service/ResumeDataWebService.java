package james.xie.resume.webservice.service;

import james.xie.resume.webservice.exception.ResumeDataException;
import james.xie.resume.webservice.models.ResumeData;

/**
 * Created by jamesxieaudaexplorecom on 2/23/16.
 */
public interface ResumeDataWebService {
    ResumeData[] getResumeData(String dataModel) throws ResumeDataException;
}
