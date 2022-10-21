package com.xjjlearning.spring.boot.listen.publisher;

import com.xjjlearning.spring.boot.listen.event.LoggingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

public class LoggingEventPublisher {
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    public void pushEvent(String message){
        applicationEventPublisher.publishEvent(new LoggingEvent(this));
    }
}