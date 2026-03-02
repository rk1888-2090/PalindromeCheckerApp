import java.util.Scanner;
public class UseCase4PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("PALINDROME CHECKER APP");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        char[] characters = input.toCharArray();
        int left = 0;
        int right = characters.length - 1;
        boolean isPalindrome = true;
        while (left < right) {
            if (characters[left] != characters[right]) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }
        if (isPalindrome) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }
        scanner.close();
    }
}
