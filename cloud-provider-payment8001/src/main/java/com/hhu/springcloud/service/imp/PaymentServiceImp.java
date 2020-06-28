package com.hhu.springcloud.service.imp;

import com.hhu.springcloud.dao.PaymentDao;
import com.hhu.springcloud.entities.Payment;
import com.hhu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: huanghl
 * @createDate: 2020/6/23
 * @version: 1.0
 */
@Service
public class PaymentServiceImp implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        int i = paymentDao.create(payment);
        return i;
    }

    @Override
    public Payment getPaymentById(Integer id) {
        Payment paymentById = paymentDao.getPaymentById(id);
        return paymentById;
    }
}
