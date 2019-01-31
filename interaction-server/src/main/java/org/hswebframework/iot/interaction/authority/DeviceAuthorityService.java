package org.hswebframework.iot.interaction.authority;

public interface DeviceAuthorityService {
    boolean verification(String clientId, String username, String password);
}
