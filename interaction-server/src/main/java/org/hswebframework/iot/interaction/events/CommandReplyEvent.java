package org.hswebframework.iot.interaction.events;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hswebframework.iot.interaction.vertx.client.message.ClientMessage;

@Getter
@Setter
@ToString
public class CommandReplyEvent extends ClientMessage {
    private String operation;
}
