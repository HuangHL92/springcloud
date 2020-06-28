package com.hhu.springcloud.service;

import com.hhu.springcloud.entities.Payment;

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById( Integer id);
}
