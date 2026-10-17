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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        int count = 0;
        ListNode temp= head;
        while(count<k){
            if(temp==null) return head;
            temp=temp.next;
            count++;
        }
    ListNode prevnode = reverseKGroup(temp,k);
    count=0;
    temp=head;
    while(count<k){
        ListNode next=temp.next;
        temp.next=prevnode;
        prevnode=temp;
        temp=next;
        count++;
    }
    return prevnode;
       

    }
}