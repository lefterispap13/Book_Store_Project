package com.groupproject.services;

import com.groupproject.receipts.Receipt;

public interface IReceiptService {

    Receipt getReceiptByOrderId(Long orderId);
}
