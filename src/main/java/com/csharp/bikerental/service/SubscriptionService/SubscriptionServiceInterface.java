package com.csharp.bikerental.service.SubscriptionService;

import com.csharp.bikerental.persistence.model.Customer;
import com.csharp.bikerental.persistence.model.Subscription;
import com.csharp.bikerental.persistence.model.SubscriptionEnum;
import com.csharp.bikerental.persistence.model.User;
import com.csharp.bikerental.persistence.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface SubscriptionServiceInterface {

	public void getSubs();

}
