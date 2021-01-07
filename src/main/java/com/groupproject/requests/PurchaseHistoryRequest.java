package com.groupproject.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseHistoryRequest {

    private LocalDateTime purchaseDate=LocalDateTime.now();

    private double eurosSpent;

    private double purchasedCoins;


}
