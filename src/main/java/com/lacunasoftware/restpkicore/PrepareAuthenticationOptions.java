package com.lacunasoftware.restpkicore;

public class PrepareAuthenticationOptions extends RequestOptions {

    private SecurityContext securityContext;
    private Boolean ignoreRevocationStatusUnknown;

    public PrepareAuthenticationOptions() {
        super();
    }

    public SecurityContext getSecurityContext() {
        return securityContext;
    }

    public void setSecurityContext(SecurityContext value) {
        securityContext = value;
    }

    public Boolean getIgnoreRevocationStatusUnknown() {
        return ignoreRevocationStatusUnknown;
    }

    public void setIgnoreRevocationStatusUnknown(boolean value) {
        ignoreRevocationStatusUnknown = value;
    }

    PrepareAuthenticationRequest getRequest() {
        PrepareAuthenticationRequest request = new PrepareAuthenticationRequest();
        if (securityContext != null) {
            request.setSecurityContextId(securityContext.getUUID());
        }
        request.setIgnoreRevocationStatusUnknown(ignoreRevocationStatusUnknown);
        return request;
    }
}
