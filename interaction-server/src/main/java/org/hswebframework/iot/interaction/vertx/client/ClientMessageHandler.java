package org.hswebframework.iot.interaction.vertx.client;

public interface ClientMessageHandler<T> {
    void handle(T message);
}
