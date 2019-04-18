package com.csharp.bikerental.service.SubscriptionService;

import com.csharp.bikerental.dto.SubscriptionDto;
import com.csharp.bikerental.persistence.model.Customer;
import com.csharp.bikerental.persistence.model.Payment;
import com.csharp.bikerental.persistence.model.Subscriptions.Subscription;
import com.csharp.bikerental.persistence.model.Subscriptions.SubscriptionEnum;
import com.csharp.bikerental.persistence.model.User;
import com.csharp.bikerental.persistence.repo.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceFacadeImpl implements SubscriptionServiceFacadeInterface {

	@Qualifier("subscriptionServiceImpl")
	@Autowired
	SubscriptionServiceInterface subscriptionService;

	 public boolean buySubcription(String username, Payment payment, SubscriptionEnum subscriptionEnum){
		 return subscriptionService.buySubcription(username, payment, subscriptionEnum);
	}
	 public List<SubscriptionDto> getUserSubscriptions(String username) {
		 return subscriptionService.getUserSubscriptions(username);
	 }


}
