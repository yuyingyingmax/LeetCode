package simple;
/*
第141题 简单
 */
public class HasCycle {
    /*
    我的方法：利用快慢指针，如果他俩相遇，则说明有环
     */
    public boolean hasCycle(ListNode head){
        if(head==null || head.next==null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean flag = false;
        while(fast!=null&&fast.next!=null&&!flag){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                flag = true;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        HasCycle hc = new HasCycle();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next=l2;
        l2.next=null;
        System.out.println(hc.hasCycle(l1));
    }
}
