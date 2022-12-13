package com.glx.javaddt.payment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.glx.javaddt.payment.Payment.PaymentMethod;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PaymentDdtTests {

  @Autowired
  private Payment payment;

  @ParameterizedTest
  @CsvSource(delimiter = ':', value = {
      "CREDITCARD:false:Not logged in",
      "CREDITCARD:true:Paid with credit card",
      "DEBITCARD:true:Paid with debit card",
      "VIRTUALACCOUNT:true:Paid with virtual account",
      "EWALLET:true:Paid with ewallet"
  })
  void pay_test(PaymentMethod method, boolean loggedIn, String expected) {
    String result = payment.pay(method, loggedIn);
    assertEquals(expected, result);
  }
}
