package simple;
/*
第206题
 */
public class ReverseList {
    /*
    我的方法1：头插法，顺序将每个节点从头部插入，从而构造一个逆序的链表
     */
    public ListNode reverseList(ListNode head){
        if(head==null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head.next;
        ListNode q = head;
        head.next = null;

        while(p!=null){
            q= dummy.next;
            dummy.next = p;
            p=p.next;
            dummy.next.next = q;
        }
        head = dummy.next;
        return head;
    }
    /*
    方法2：递归
     */
    public ListNode reverseList_two(ListNode head){
        if(head == null || head.next==null){
            return head;
        }
        ListNode p = head.next;
        ListNode rehead = reverseList_two(p);
        p.next = head;
        head.next = null;
        return rehead;
    }
}
