package com.csharp.bikerental.persistence.model.Subscriptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class SubscriptionInMemory {


    Map<SubscriptionEnum, Subscription> Subscription = loadPrototypes();

    public static Map<SubscriptionEnum, Subscription> loadPrototypes() {

        Map<SubscriptionEnum,Subscription> map = new HashMap<SubscriptionEnum,Subscription>();
        PayAsYouGoSubscription payAsYouGoSubscription = new PayAsYouGoSubscription(1,SubscriptionEnum.PayAsYouGo);
        map.put(SubscriptionEnum.PayAsYouGo, payAsYouGoSubscription );
        AnnualSubscription annualSubscription = new AnnualSubscription(1,new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()+31536000000l),SubscriptionEnum.AnnualSubscription);
        map.put(SubscriptionEnum.AnnualSubscription, annualSubscription);
        AnnualSubscription monthlySubscription = new AnnualSubscription(1,new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis() + 2592000000l ),SubscriptionEnum.MonthSubscription);
        map.put(SubscriptionEnum.MonthSubscription, monthlySubscription);
        return map;
    }
}
