package org.hswebframework.iot.logging;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class IotLoggingAutoConfiguration implements ApplicationEventPublisherAware, EnvironmentAware {

    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        IotLogAppender.setPublisher(applicationEventPublisher);
    }

    public void setEnvironment(Environment environment) {
        IotLogAppender.appId = environment.getProperty("hsweb.app.name", environment.getProperty("spring.application.name"));
    }
}
