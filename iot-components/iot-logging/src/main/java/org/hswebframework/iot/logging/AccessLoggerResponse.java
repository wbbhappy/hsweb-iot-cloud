package org.hswebframework.iot.logging;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class AccessLoggerResponse {
    private String id;
    private long responseTime;
    private Object response;
}
