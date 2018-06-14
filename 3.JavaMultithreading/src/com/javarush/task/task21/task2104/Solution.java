package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

//    public boolean equals(Object n) {
//        if (this == n) return true;
//        if (n == null) return false;
//        if (getClass() != n.getClass()) return false;
//        Solution other = (Solution) n;
//        return other.first.equals(first) && other.last.equals(last);
//    }

//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        if (first == null || last == null) return 0;
//        result = prime * result + first.hashCode();
//        result = prime * result + last.hashCode();
////        return 31 * first.hashCode() + last.hashCode();
//        return result;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;
        Solution solution = (Solution) o;
        return Objects.equals(first, solution.first) &&
                Objects.equals(last, solution.last);
    }

    @Override
    public int hashCode() {

        return Objects.hash(first, last);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        Solution s0 = new Solution("Donald", "Duck");
        s.add(s0);
        for (Solution solution :s) {
            System.out.println("first " +  solution.first.hashCode());
            System.out.println("last " +  solution.last.hashCode());
            System.out.println("Solution hashCode" + solution.hashCode());
        }

        System.out.println("=========================");

        Solution s1 = new Solution("Donald", "Duck");
        System.out.println("first " +  s1.first.hashCode());
        System.out.println("last " +  s1.last.hashCode());
        System.out.println("Solution hashCode" + s1.hashCode());

        System.out.println("=========================");

        System.out.println(s0.first.equals(s1.first));
        System.out.println(s0.last.equals(s1.last));
        System.out.println(s0.first.equals(s1.first) && s0.last.equals(s1.last));

        System.out.println("=========================");
        System.out.println(s0.equals(s1));
        System.out.println(s1.equals(s0));
        System.out.println("=========================");

        System.out.println(s.contains(s1));
    }
}
