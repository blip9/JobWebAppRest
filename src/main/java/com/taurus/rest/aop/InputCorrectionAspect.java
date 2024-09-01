package com.taurus.rest.aop;

import com.taurus.rest.model.Jobpost;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class InputCorrectionAspect {
    public static final Logger LOGGER = LoggerFactory.getLogger(InputCorrectionAspect.class);

    @Around("execution(* com.taurus.rest.controller.JobRestController.addJob(..)) && args(jobpost)")
    public Object validateAndUpdate(ProceedingJoinPoint pjp,Jobpost jobpost) throws Throwable {

        if(jobpost.getPostId()<0){
            int newPostId = -jobpost.getPostId();
            jobpost.setPostId(newPostId);
            LOGGER.info("Value updated");

        }
        return pjp.proceed(new Object[]{jobpost}    );
    }


}
