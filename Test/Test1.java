public class Test1 {
    public static void main(String[] args) {
        int numberOfLocks = 12;

        for (int i = 0; i <= 1000; i++) {
            System.out.printf("i: %s, i / nol: %s \n", i, i % numberOfLocks);
        }


    }
}
