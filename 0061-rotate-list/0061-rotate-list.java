/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
    return head;
}
        ListNode temp=head;
        int len=1;
        while(temp.next!=null)
        {
            len++;
            temp=temp.next;
        }
        k=k%len;
        if(k==0) return head;
        int pos=1;
        ListNode slow=head;
        while(pos<len-k){
            slow=slow.next;
            pos++;
        }
        temp.next=head;
        ListNode fast=slow.next;
        slow.next=null;
        head=fast;
        return head;
    }
}