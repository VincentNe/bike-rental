package com.csharp.bikerental.persistence.model.Subscriptions;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class SubscriptionDispatcher implements Interceptor {

    private ArrayList<Interceptor> Interceptors = new ArrayList<Interceptor>();

    private static AtomicReference<SubscriptionDispatcher> thisDispatcher = new AtomicReference<>();

    public SubscriptionDispatcher(){
        final SubscriptionDispatcher previous = thisDispatcher.getAndSet(this);
        if(previous != null)
            throw new IllegalStateException("Second singleton " + this + " created after " + previous);
     }


    @Override
    public void preRequest(List<Subscription> context) {
        for (Interceptor i:Interceptors) {
            i.preRequest(context);
        }
    }

    @Override
    public void postRequest(List<Subscription> context) {
        for (Interceptor i:Interceptors) {
            i.postRequest(context);
        }
    }

    public void registerDispatcher(Interceptor interceptor) {
        Interceptors.add(interceptor);
    }

    public void removerDispatcher(Interceptor interceptor) {
        Interceptors.remove(interceptor);
    }

    public synchronized static SubscriptionDispatcher getInstanceOfDispatcher() {
        return thisDispatcher.get();
}
}