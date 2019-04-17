package com.csharp.bikerental.persistence.model.Subscriptions;

import java.util.List;

public interface Interceptor {
    void preRequest(List<Subscription> context);
    void postRequest(List<Subscription> context);
}
