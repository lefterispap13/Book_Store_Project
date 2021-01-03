package com.groupproject.requests;

import com.groupproject.entities.Account;
import com.groupproject.entities.OrderDetails;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private Account account;
    private double totalCoins;
    private Set<OrderDetails> orderDetails;
}
