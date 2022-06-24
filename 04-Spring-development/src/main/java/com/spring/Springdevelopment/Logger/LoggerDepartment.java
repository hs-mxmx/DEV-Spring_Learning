package com.spring.Springdevelopment.Logger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Aspect
@Component
public class LoggerDepartment { 
    private final Logger LOGGER = LoggerFactory.getLogger(LoggerDepartment.class);
    private String severity = "";
    private String message = "";

    public void DepartmentControllerGenericLog(String functionName){
        String logMessage = String.format("1 - Trace detected on function '%s' ", functionName) ;
        if (!message.isEmpty()){
            logMessage.concat(message);
        }
        if(severity.equalsIgnoreCase("info") || severity.isEmpty()){
            LOGGER.info(logMessage);
            return;
        } if (severity.equalsIgnoreCase("error")) {
            LOGGER.error(logMessage);
            return;
        }
        LOGGER.debug(logMessage);
        return;
    }

    public void DepartmentServiceGenericLog(String functionName){
        String logMessage = String.format("2 - Trace detected on function '%s' ", functionName) ;
        if (!message.isEmpty()){
            logMessage.concat(message);
        }
        if(severity.equalsIgnoreCase("info") || severity.isEmpty()){
            LOGGER.info(logMessage);
            return;
        } if (severity.equalsIgnoreCase("error")) {
            LOGGER.error(logMessage);
            return;
        }
        LOGGER.debug(logMessage);
        return;
    }

}


