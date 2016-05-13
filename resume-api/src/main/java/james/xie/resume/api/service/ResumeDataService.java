package james.xie.resume.api.service;

import james.xie.resume.webservice.exception.ResumeDataException;
import james.xie.resume.webservice.models.ResumeData;

public interface ResumeDataService {

    ResumeData[] getData(final String dataName) throws ResumeDataException;

}
