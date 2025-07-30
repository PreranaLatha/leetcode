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
         ListNode ptr=head;
         ListNode tail=null;
         ListNode newHead=null;

         while(ptr!=null){
            ptr=head;
            int count=0;
            while(ptr!=null && count<k){
                ptr=ptr.next;
                count++;
            }
            if(count==k){
                ListNode revHead=reverseLinkedList(head,k);
                if(newHead==null)newHead=revHead;
                if(tail!=null)tail.next=revHead;
                tail=head;
                head=ptr;
            }
         }if(tail!=null)tail.next=head;
         return newHead==null?head:newHead;
    }
    private ListNode reverseLinkedList(ListNode head,int k){
        ListNode newHead=null;
        ListNode ptr=head;
        while(k>0){
            ListNode temp=ptr.next;
            ptr.next=newHead;
            newHead=ptr;
            ptr=temp;
            k--;
        }return newHead;
    }
}