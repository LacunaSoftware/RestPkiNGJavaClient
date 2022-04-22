package com.lacunasoftware.restpkicore;

import java.util.UUID;

public class RequestOptions {

    private UUID subscriptionId;

    public RequestOptions() {
    }

    public UUID getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(UUID value) {
        subscriptionId = value;
    }

    public void setSubscriptionId(String value) {
        subscriptionId = UUID.fromString(value);
    }
}
