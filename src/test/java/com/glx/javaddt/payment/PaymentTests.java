package com.glx.javaddt.payment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.glx.javaddt.payment.Payment.PaymentMethod;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PaymentTests {

    @Autowired
    private Payment payment;

    @Test
    void test_pay_not_logged_in() {
        String result = payment.pay(PaymentMethod.CREDITCARD, false);
        assertEquals("Not logged in", result);
    }

    @Test
    void test_pay_creditcard() {
        String result = payment.pay(PaymentMethod.CREDITCARD, true);
        assertEquals("Paid with credit card", result);
    }

    @Test
    void test_pay_debitcard() {
        String result = payment.pay(PaymentMethod.DEBITCARD, true);
        assertEquals("Paid with debit card", result);
    }

    @Test
    void test_pay_virtualaccount() {
        String result = payment.pay(PaymentMethod.VIRTUALACCOUNT, true);
        assertEquals("Paid with virtual account", result);
    }

    @Test
    void test_pay_ewallet() {
        String result = payment.pay(PaymentMethod.EWALLET, true);
        assertEquals("Paid with ewallet", result);
    }
}
