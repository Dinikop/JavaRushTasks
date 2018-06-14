package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<>();
        String s = reader.readLine();
        char[] chars = s.toCharArray();
        String valueAfterObj = "";
        String parameterName;
        int startIndexOfParameterName;


        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] == '?') || (chars[i] == '&')) {
                startIndexOfParameterName = i + 1;
                for (int j = startIndexOfParameterName; true; j++) {
                    if (chars[j] == '=' || chars[j] == '&') {
                        parameterName = String.copyValueOf(chars, startIndexOfParameterName, j - startIndexOfParameterName);
                        list.add(parameterName);
                        i = j - 1;
                        if (parameterName.equals("obj")) {
                            for (int k = j + 1; true; k++) {
                                if (chars[k] == '&') {
                                    valueAfterObj = String.copyValueOf(chars, j + 1, k - (j + 1));
                                    break;
                                }

                            }
                        }
                        break;
                    }
                }
            }

        }
        for (String s1 : list) {
            System.out.print(s1 + " ");
        }

        System.out.println();


        if (!valueAfterObj.isEmpty()) {
            try {
                alert(Double.parseDouble(valueAfterObj));
            } catch (NumberFormatException e) {
                alert(valueAfterObj);
            }
        }

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
