package org.koreait.tests.chap03;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PayData {
  private LocalDate billingDate;
  private int payAmount;
  private LocalDate firstBillingDate;

}
