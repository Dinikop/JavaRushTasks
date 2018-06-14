package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");

    }

    public static void main(String[] args) {
//        IncomeData incomeData = new IncomeData() {
//            @Override
//            public String getCountryCode() {
//                return "UA";
//            }
//
//            @Override
//            public String getCompany() {
//                return "JavaRush Ltd.";
//            }
//
//            @Override
//            public String getContactFirstName() {
//                return "Ivan";
//            }
//
//            @Override
//            public String getContactLastName() {
//                return "Ivanov";
//            }
//
//            @Override
//            public int getCountryPhoneCode() {
//                return 38;
//            }
//
//            @Override
//            public int getPhoneNumber() {
//                return 501234567;
//            }
//        };
//        IncomeDataAdapter incomeDataAdapter = new IncomeDataAdapter(incomeData);
//        System.out.println(incomeDataAdapter.getName());
//        System.out.println(incomeDataAdapter.getPhoneNumber());
//        System.out.println(incomeDataAdapter.getCompanyName());
//        System.out.println(incomeDataAdapter.getCountryName());
    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData incomeData) {
            this.data = incomeData;
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String s = String.valueOf(data.getPhoneNumber());
            while (s.length() < 10)
                s = "0" + s;


            return "+" + String.valueOf(data.getCountryPhoneCode()) +
                    "(" + s.substring(0, 3) + ")" +
                    s.substring(3,6) +
                    "-" + s.substring(6,8) +
                    "-" + s.substring(8,10);
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}