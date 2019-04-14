package com.csharp.bikerental.persistence.model.Subscriptions;

import java.util.Date;
import java.util.Hashtable;

public class SubscriptionCache {
    private static Hashtable<SubscriptionEnum, Subscription> map  = new Hashtable<SubscriptionEnum, Subscription>();

    public SubscriptionCache(){
        PayAsYouGoSubscription payAsYouGoSubscription = new PayAsYouGoSubscription(1);
        map.put(SubscriptionEnum.PayAsYouGo, payAsYouGoSubscription );
        AnnualSubscription annualSubscription = new AnnualSubscription(1,new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()+31536000000l));
        map.put(SubscriptionEnum.AnnualSubscription, payAsYouGoSubscription);
        AnnualSubscription monthlySubscription = new AnnualSubscription(1,new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis() + 2592000000l ));
        map.put(SubscriptionEnum.MonthSubscription, monthlySubscription);
    }
    public Subscription getSubscription(SubscriptionEnum subscriptionEnum){
       Subscription subscription = map.get(subscriptionEnum);
       return  (Subscription) subscription.clone();
    }


}
