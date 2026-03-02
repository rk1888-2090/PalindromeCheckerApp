import java.util.*;
public class UseCase13PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input : ");
        String s = sc.hasNextLine() ? sc.nextLine() : "";
        PalindromeAlgo[] algos = {
            new TwoPointerAlgo(),
            new StackAlgo(),
            new ReverseAlgo()
        };
        System.out.println();
        for (int i = 0; i < algos.length; i++) {
            PalindromeAlgo a = algos[i];
            long start = System.nanoTime();
            boolean ok = a.check(s);
            long end = System.nanoTime();
            double ms = (end - start) / 1_000_000.0;
            System.out.println("Algorithm : " + a.name());
            System.out.println("Is Palindrome? : " + ok);
            System.out.printf("Execution Time : %.3f ms%n", ms);
            if (i != algos.length - 1) System.out.println();
        }
        sc.close();
    }
    static String clean(String input) {
        if (input == null) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLetterOrDigit(c)) sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }
}
interface PalindromeAlgo {
    String name();
    boolean check(String s);
}
class TwoPointerAlgo implements PalindromeAlgo {
    public String name() {
        return "Two Pointer";
    }
    public boolean check(String input) {
        String s = UseCase13PalindromeCheckerApp.clean(input);
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
class StackAlgo implements PalindromeAlgo {
    public String name() {
        return "Stack";
    }
    public boolean check(String input) {
        String s = UseCase13PalindromeCheckerApp.clean(input);
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) st.push(s.charAt(i));
        for (int i = 0; i < s.length(); i++) {
            if (st.pop() != s.charAt(i)) return false;
        }
        return true;
    }
}
class ReverseAlgo implements PalindromeAlgo {
    public String name() {
        return "Reverse String";
    }
    public boolean check(String input) {
        String s = UseCase13PalindromeCheckerApp.clean(input);
        String r = new StringBuilder(s).reverse().toString();
        return s.equals(r);
    }
}

