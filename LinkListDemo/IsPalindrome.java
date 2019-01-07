package simple;
/*
第234题
 */
import java.util.Stack;

public class IsPalindrome {
    /*
    1.利用栈来进行比较
     */
    public boolean isPalindrom(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        int count = 0;
        while(p!=null){
            stack.push(p);
            p=p.next;
            count++;
        }
        for(int i = 1,j=count;i<j;i++,j--){
            if(head.val!=stack.pop().val){
                return false;
            }
            head=head.next;
        }
        return true;
    }
    /*
    可以将后半部分链表反转后进行比较
    这里用了快慢指针，快指针一次走两步，慢指针一次走一步，当表长为奇数时，快指针走到表尾，慢指针走到表中间
    当表长为偶数时，快指针走到倒数第二个位置时，满指针走到中间（左中间）
     */
    public boolean isPalindrom_two(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newhead = reverse(slow);
        while(head!=newhead && newhead!=null){
            if(head.val!=newhead.val){
                return false;
            }
            head=head.next;
            newhead=newhead.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode newhead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;
    }


    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
//        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(2);
//        ListNode l5 = new ListNode(1);
        l1.next=l2;
        l2.next=null;
//        l3.next=l4;
//        l4.next=l5;
//        l5.next=null;

        //System.out.println(isPalindrome.isPalindrom(l1));
        System.out.println(isPalindrome.isPalindrom_two(l1));
    }
}
