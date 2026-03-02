import java.util.*;
class UseCase9PalindromeCheckerApp
{
 static boolean check(String s,int start,int end)
 {
  if(start>=end) return true;
  if(s.charAt(start)!=s.charAt(end)) return false;
  return check(s,start+1,end-1);
 }
 public static void main(String[] args)
 { Scanner sc=new Scanner(System.in);
  System.out.println("enter string");
  String s=sc.nextLine();
  s=s.replaceAll("\\s+","").toLowerCase();
  if(check(s,0,s.length()-1)) System.out.println("palindrome");
  else System.out.println("not palindrome");
 }
}
