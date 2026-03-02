import java.util.*;
public class UseCase12PalindromeCheckerApp {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print("Input : ");
String s = sc.hasNextLine() ? sc.nextLine() : "";
PalindromeStrategy st;
String cleaned = clean(s);
if (cleaned.length() % 2 == 0) st = new DequeStrategy();
else st = new StackStrategy();
boolean ans = st.check(s);
System.out.println("Is Palindrome? : " + ans);
sc.close();
}
static String clean(String s) {
if (s == null) return "";
StringBuilder sb = new StringBuilder();
for (int i = 0; i < s.length(); i++) {
char c = s.charAt(i);
if (Character.isLetterOrDigit(c)) sb.append(Character.toLowerCase(c));
}
return sb.toString();
}
}

interface PalindromeStrategy {
boolean check(String input);
}

class StackStrategy implements PalindromeStrategy {
public boolean check(String input) {
String s = UseCase12PalindromeCheckerApp.clean(input);
Stack<Character> st = new Stack<>();
for (int i = 0; i < s.length(); i++) st.push(s.charAt(i));
for (int i = 0; i < s.length(); i++) {
if (st.pop() != s.charAt(i)) return false;
}
return true;
}
}

class DequeStrategy implements PalindromeStrategy {
public boolean check(String input) {
String s = UseCase12PalindromeCheckerApp.clean(input);
Deque<Character> dq = new ArrayDeque<>();
for (int i = 0; i < s.length(); i++) dq.addLast(s.charAt(i));
while (dq.size() > 1) {
if (dq.removeFirst() != dq.removeLast()) return false;
}
return true;
}
}

