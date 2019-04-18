package com.csharp.bikerental.service.SubscriptionService;

import com.csharp.bikerental.dto.SubscriptionDto;
import com.csharp.bikerental.persistence.model.Payment;
import com.csharp.bikerental.persistence.model.Subscriptions.SubscriptionEnum;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface SubscriptionServiceFacadeInterface {

	public boolean buySubcription(String username, Payment payment, SubscriptionEnum subscriptionEnum);
    public List<SubscriptionDto> getUserSubscriptions(String username);
}