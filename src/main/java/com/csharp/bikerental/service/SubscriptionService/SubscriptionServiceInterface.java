package com.csharp.bikerental.service.SubscriptionService;

import com.csharp.bikerental.persistence.model.Customer;
import com.csharp.bikerental.persistence.model.Payment;
import com.csharp.bikerental.persistence.model.Subscriptions.Subscription;
import com.csharp.bikerental.persistence.model.Subscriptions.SubscriptionEnum;
import com.csharp.bikerental.persistence.model.User;
import com.csharp.bikerental.persistence.repo.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface SubscriptionServiceInterface {

	public boolean buySubcription(String username, Payment payment, SubscriptionEnum subscriptionEnum);
    public List<Subscription> getUserSubscriptions(String username);
}
