package com.csharp.bikerental.persistence.model.Subscriptions;

import javax.persistence.Transient;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

public class SubscriptionCache {

    private Map<SubscriptionEnum, Subscription> map;
    public SubscriptionCache(){
        map  = SubscriptionInMemory.loadPrototypes();
    }

    public Subscription getSubscription(SubscriptionEnum subscriptionEnum){
       Subscription subscription = map.get(subscriptionEnum);
       return  (Subscription) subscription.clone();
    }


}
