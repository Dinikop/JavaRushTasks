import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTestHarness {
    public static void main(String[] args)
    {
//        Console console = System.console();
        Scanner sc = new Scanner(System.in);
        if(sc == null){
            System.err.println("No console");
            System.exit(1);
        }
        while (true){
            System.out.print("\nEnter your regex: ");
            Pattern pattern = Pattern.compile(sc.nextLine());
            System.out.print("Enter input string to search: ");
            Matcher matcher = pattern.matcher(sc.nextLine());
            boolean found = false;
            while (matcher.find()){
                System.out.format("I found the text \"%s\" starting at index %d and ending at index %d.\n",
                        matcher.group(),
                        matcher.start(),
                        matcher.end());
                found = true;
            }
            if(!found){
                System.out.format("No match found.\n");
            }
        }
    }
}
