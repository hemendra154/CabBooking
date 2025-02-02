package com.hs.cabbooking.aop;

import com.hs.cabbooking.exception.CabBookingException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect
{

    private static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);

    @AfterThrowing(pointcut = "execution(* com.hs.cabbooking.service.*Impl.*(..))", throwing = "exception")
    public void logServiceException(CabBookingException exception)
    {
        LOGGER.error(exception.getMessage(), exception);

    }

}
