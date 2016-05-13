package james.xie.resume.webservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import james.xie.resume.webservice.configuration.properties.ResumeDataWebServiceProperties;
import james.xie.resume.webservice.exception.ResumeDataException;
import james.xie.resume.webservice.models.*;
import james.xie.resume.webservice.service.ResumeDataWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by jamesxieaudaexplorecom on 2/23/16.
 */
@Service(value = "resumeDataWebService")
public class ResumeDataWebServiceImpl implements ResumeDataWebService {

    private static String DATA_MODEL_SUMMARY = "Summary";

    private static String DATA_MODEL_INTRODUCTION = "Introduction";

    private static String DATA_MODEL_PROJECT = "Project";

    private static String DATA_MODEL_EDUCATION="Education";

    private static String DATA_MODEL_WORK_EXPERIENCE="WorkExperience";

    @Autowired
    private ResumeDataWebServiceProperties resumeDataWebServiceProperties;

    @Autowired
    private ObjectMapper resumeDataWebServiceObjectMapper;

    public ResumeData[] getResumeData(String dataModel) throws ResumeDataException {
        try {
            StringBuilder sb = new StringBuilder(String.format(resumeDataWebServiceProperties.getResumeUrl(),dataModel));
            if (DATA_MODEL_WORK_EXPERIENCE.equals(dataModel)) {
                return resumeDataWebServiceObjectMapper.readValue(getResponseString(sb.toString()), ResumeWorkExperience[].class);
            } else if (DATA_MODEL_EDUCATION.equals(dataModel)) {
                return resumeDataWebServiceObjectMapper.readValue(getResponseString(sb.toString()), ResumeEducation[].class);
            } else if (DATA_MODEL_PROJECT.equals(dataModel)){
                return resumeDataWebServiceObjectMapper.readValue(getResponseString(sb.toString()), ResumeProject[].class);
            } else if (DATA_MODEL_INTRODUCTION.equals(dataModel)){
                return resumeDataWebServiceObjectMapper.readValue(getResponseString(sb.toString()), ResumeIntroduction[].class);
            } else if (DATA_MODEL_SUMMARY.equals(dataModel)){
                return resumeDataWebServiceObjectMapper.readValue(getResponseString(sb.toString()), ResumeSummary[].class);
            } else {
                throw new ResumeDataException("Data Model name is not right!");
            }
        } catch (Exception e) {
            throw new ResumeDataException("Can't get Resume Data from MongoDB.",e);
        }
    }

    private String getResponseString(String urlPath) throws Exception {
        URL url = new URL(urlPath);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(resumeDataWebServiceProperties.getResumeRequestTimeoutInMillis());
        conn.setRequestProperty("Accept", "application/json");
        if (conn.getResponseCode() != 200) {
            throw new ResumeDataException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            output.append(line);
        }
        conn.disconnect();
        return output.toString();
    }
}
