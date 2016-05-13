package james.xie.resume.webservice.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebClientOptions;
import james.xie.resume.webservice.configuration.properties.ResumeDataWebServiceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Created by jamesxieaudaexplorecom on 2/24/16.
 */
@Configuration
@Import(ResumeDataWebServiceProperties.class)
@ComponentScan(basePackages = "james.xie.resume.webservice")
public class ResumeDataWebServiceConfiguration {

    public static final String PATTERN = "yyyy-MM-dd' 'HH:mm:ss";

    @Bean(destroyMethod = "close")
    public WebClient webClient() {
        final WebClient webClient = new WebClient(BrowserVersion.CHROME);

        final WebClientOptions webClientOptions = webClient.getOptions();
        webClientOptions.setJavaScriptEnabled(false);
        webClientOptions.setThrowExceptionOnScriptError(false);

        return webClient;
    }

    @Bean
    public ObjectMapper resumeDataWebServiceObjectMapper() {
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(PATTERN, Locale.ENGLISH)));
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(PATTERN, Locale.ENGLISH)));

        return new ObjectMapper()
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false)
                .setDateFormat(new SimpleDateFormat(PATTERN))
                .registerModule(javaTimeModule)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
}
