package com.groupproject.services;

import com.groupproject.receips.Receipt;

public interface IReceiptService {

    Receipt getReceiptByOrderId(Long orderId);
}
