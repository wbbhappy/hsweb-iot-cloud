package org.hswebframework.iot.interaction.vertx.client;

public interface ClientRepository {
    Client getClient(String idOrClientId);
    Client register(Client client);
    Client unregister(String idOrClientId);
    long total();
}
