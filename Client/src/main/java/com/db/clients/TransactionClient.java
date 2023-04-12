package com.db.clients;

import com.db.configuration.ClientConfiguration;

import com.db.entity.Transaction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
@FeignClient(url = "http://localhost:8082/transaction", value = "transactions", configuration = ClientConfiguration.class)
public interface TransactionClient {
    @RequestMapping(method= RequestMethod.PUT, value = "/add-json")
    Transaction performPayment(Transaction transaction);
}
