package com.csharp.bikerental.Service;

import com.csharp.bikerental.persistence.model.Subscriptions.Interceptor;
import com.csharp.bikerental.persistence.model.Subscriptions.Subscription;

import java.util.List;

public class ConcreteInterceptor implements Interceptor {
    @Override
    public void preRequest(List<Subscription> context) {
        System.out.println("Reached the Concrete Interceptor Pre request, Subscription Count: " + context.size());
    }

    @Override
    public void postRequest(List<Subscription> context) {
        System.out.println("Reached the Concrete Interceptor post request");

    }
}
