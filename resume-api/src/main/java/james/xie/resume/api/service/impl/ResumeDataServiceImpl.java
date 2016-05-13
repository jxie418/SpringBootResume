package james.xie.resume.api.service.impl;

import james.xie.resume.api.service.ResumeDataService;
import james.xie.resume.webservice.exception.ResumeDataException;
import james.xie.resume.webservice.models.ResumeData;
import james.xie.resume.webservice.service.impl.ResumeDataWebServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "vehicleService")
public class ResumeDataServiceImpl implements ResumeDataService {

    @Autowired
    private ResumeDataWebServiceImpl resumeDataWebService;

    @Override
    public ResumeData[] getData(final String dataName) throws ResumeDataException {
        return resumeDataWebService.getResumeData(dataName);
    }

}
