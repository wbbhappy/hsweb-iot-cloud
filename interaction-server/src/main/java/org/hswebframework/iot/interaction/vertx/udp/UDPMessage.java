package org.hswebframework.iot.interaction.vertx.udp;

import lombok.Getter;
import lombok.Setter;
import org.hswebframework.iot.interaction.vertx.client.message.ClientMessage;

@Getter
@Setter
public class UDPMessage extends ClientMessage {
    private String type;
}
