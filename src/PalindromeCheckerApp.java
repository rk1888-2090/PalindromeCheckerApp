import java.util.*;
class UseCase8PalindromeCheckerApp
{
    static class Node
    {
        char data;
        Node next;
        Node(char d)
        {
            data=d;
            next=null;
        }
    }
    static Node head=null;
    static void add(char c)
    {
        Node n=new Node(c);
        if(head==null)
        {
            head=n;
            return;
        }
        Node t=head;
        while(t.next!=null) t=t.next;
        t.next=n;
    }
    static boolean check()
    {
        if(head==null||head.next==null) return true;
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        Node prev=null;
        Node curr=slow;
        Node next=null;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node first=head;
        Node second=prev;
        while(second!=null)
        {
            if(first.data!=second.data) return false;
            first=first.next;
            second=second.next;
        }
        return true;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter string");
        String s=sc.nextLine();
        s=s.replaceAll("\\s+","").toLowerCase();
        for(int i=0;i<s.length();i++) add(s.charAt(i));
        if(check()) System.out.println("palindrome");
        else System.out.println("not palindrome");
    }
}