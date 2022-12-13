package com.glx.javaddt.payment;

import org.springframework.stereotype.Component;

@Component
public class Payment {
    
    enum PaymentMethod {
        CREDITCARD,
        DEBITCARD,
        VIRTUALACCOUNT,
        EWALLET
    }

    public String pay(PaymentMethod paymentMethod, boolean loggedIn) {
        if (!loggedIn) return "Not logged in";
        return switch (paymentMethod) {
            case CREDITCARD -> "Paid with credit card";
            case DEBITCARD -> "Paid with debit card";
            case VIRTUALACCOUNT -> "Paid with virtual account";
            case EWALLET -> "Paid with ewallet";
        };
    }
}
