package org.koreait.tests.chap03;

import org.hibernate.validator.internal.util.privilegedactions.LoadClass;

import java.time.LocalDate;

public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(PayData payData){
        int addMonths =1;
        if(payData.getFirstBillingDate()!=null){
            LocalDate cadidiateExp = payData.getBillingDate().plusMonths(addMonths);
            if(payData.getFirstBillingDate().getDayOfMonth() !=
            cadidiateExp.getDayOfMonth()){
                return cadidiateExp.withDayOfMonth(payData.getFirstBillingDate().getDayOfMonth());
            }
        }
        return  payData.getBillingDate().plusMonths(addMonths);
    }
}
