package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        if (a == b) System.out.println(a);
        else if (b == c) System.out.println(b);
        else if (a == c) System.out.println(c);
        else if (max(a,b,c) > a && a > min(a,b,c)) System.out.println(a);
        else if (max(a,b,c) > b && b > min(a,b,c)) System.out.println(b);
        else System.out.println(c);

    }
    private static int max(int a, int b, int c) {
        if ((a > b && b > c) || (a > c && c > b)) return a;
        else if ((b > a && a > c) ||(b > c && c > a)) return b;
        else return c;
    }

    private static int min(int a, int b, int c) {
        if ((a < b && b < c) || (a < c && c < b)) return a;
        else if ((b < a && a < c) ||(b < c && c < a)) return b;
        else return c;
    }

}
