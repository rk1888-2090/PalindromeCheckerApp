public class UseCase11PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("input : ");
        String s = "";
        if (sc.hasNextLine()) s = sc.nextLine();
        PalindromeService p = new PalindromeService();
        System.out.println("is palindrome? : " + p.checkPalindrome(s));
        sc.close();
    }
}
class PalindromeService {
    public boolean checkPalindrome(String input) {
        if (input == null) return false;
        int start = 0, end = input.length() - 1;
        while (start < end) {
            char a = input.charAt(start), b = input.charAt(end);
            while (start < end && !Character.isLetterOrDigit(a)) {
                start++;
                a = input.charAt(start);
            }
            while (start < end && !Character.isLetterOrDigit(b)) {
                end--;
                b = input.charAt(end);
            }
            if (Character.toLowerCase(a) != Character.toLowerCase(b)) return false;
            start++;
            end--;
        }
        return true;
    }
}
