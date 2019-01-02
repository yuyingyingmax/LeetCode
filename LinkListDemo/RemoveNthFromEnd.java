package simple;
/*
第19题 中等
 */
public class RemoveNthFromEnd {
    /*
    通过观察发现，从末尾删除第n个元素相当于从头删除第L-n+1个元素，L为链表长度
    第一种解法：一次先遍历链表得到长度，然后再遍历进行删除（将L-n位置的next指向L-n+2）
    第二种解法：只进行一次遍历，使用两个指针。
    初始first和second都指向头结点，先让first向前n+1步,此时first和second的间隔为n，
    然后同时向前推进，发现只要当first遍历完成（指向null）
    second的位置就是要删除节点的前驱，然后就可以进行second.next = second.next.next
     */
    public ListNode removeNthFromEnd(ListNode head,int n){
        ListNode dummy =new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        for(int i = 1; i<=n+1;i++){
            first = first.next;
        }
        while(first.next!=null){
            first=first.next;
            second=second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
