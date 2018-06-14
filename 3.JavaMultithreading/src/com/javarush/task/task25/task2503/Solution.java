package com.javarush.task.task25.task2503;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
Свой enum
*/
public class Solution {
    /**
     * Output:
     * <p/>
     * Available Amount
     * Account Number
     * Bank Name
     * --------------------
     * Available Amount
     * Bank Name
     */
    public static void main(String[] args) {

        for (Columnable columnable :Column.values()) {
            System.out.println(columnable.getColumnName());
        }
        System.out.println("--------------------");


        Column.configureColumns(Column.Amount, Column.AccountNumber, Column.BankName);
//        System.out.println(Arrays.toString(Column.realOrder));

        for (Columnable columnable : Column.getVisibleColumns()) {
            System.out.println(columnable.getColumnName());
        }


        System.out.println("--------------------");
        System.out.println("testing isShown: ");
        System.out.println(Column.Customer.isShown());
        System.out.println(Column.Amount.isShown());

        System.out.println("--------------------");
        Column.AccountNumber.hide();

        for (Columnable columnable : Column.getVisibleColumns()) {
            System.out.println(columnable.getColumnName());
        }
    }
}
