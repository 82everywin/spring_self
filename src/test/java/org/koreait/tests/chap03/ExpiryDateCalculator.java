package org.koreait.tests.chap03;

import org.hibernate.validator.internal.util.privilegedactions.LoadClass;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(PayData payData) {
        int addMonths = payData.getPayAmount() / 10_000;
        if (payData.getFirstBillingDate() != null) {
            return expiryDateUsingFirstBillingDate(payData,addMonths);
        } else {
            return payData.getBillingDate().plusMonths(addMonths);
        }
    }

    private LocalDate expiryDateUsingFirstBillingDate(PayData payData,int addMonths){
        LocalDate candidateExp = payData.getBillingDate().plusMonths(addMonths);

        final int dayOffFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
        if (dayOffFirstBilling != candidateExp.getDayOfMonth()) {
            final int dayLenOfCandiMon = YearMonth.from(candidateExp).lengthOfMonth();
            if (dayLenOfCandiMon < dayOffFirstBilling) {
                return candidateExp.withDayOfMonth(dayLenOfCandiMon);
            }
            return candidateExp.withDayOfMonth(dayOffFirstBilling);
        } else {
            return candidateExp;
        }
    }
}
