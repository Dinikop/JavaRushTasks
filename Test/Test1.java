import java.util.concurrent.ThreadLocalRandom;

public class Test1 {
    public static void main(String[] args) {
        int min = 1;
        int max = 4;

        for (int i = 0; i < 1000; i++) {
            System.out.println(ThreadLocalRandom.current().nextInt(min, max + 1));
        }
    }
}
