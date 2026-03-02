import java.util.*;
class UseCase10PalindromeCheckerApp
{
 public static void main(String[] args)
 {
  Scanner sc=new Scanner(System.in);
  System.out.println("enter string");
  String s=sc.nextLine();
  s=s.replaceAll("\\s+","").toLowerCase();
  int i=0;
  int j=s.length()-1;
  boolean ok=true;
  while(i<j)
  {
   if(s.charAt(i)!=s.charAt(j))
   {
    ok=false;
    break;
   }
   i++;
   j--;
  }
  if(ok) System.out.println("palindrome");
  else System.out.println("not palindrome");
 }
}
