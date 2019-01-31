package org.hswebframework.iot.interaction.vertx;

import io.vertx.core.Verticle;
import io.vertx.core.spi.VerticleFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SpringVerticleFactory implements VerticleFactory {
    @Autowired
    private ApplicationContext context;

    public String prefix() {
        return "spring";
    }

    public Verticle createVerticle(String verticleName, ClassLoader classLoader) throws Exception {
        verticleName = VerticleFactory.removePrefix(verticleName);
        return context.getBean(verticleName, Verticle.class);
    }
}
