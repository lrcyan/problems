/**
 * Definition for singly-linked list.
 * public class RemoveNNFE {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode tmp = head;
        while(tmp!=null) {
            len++;
            tmp=tmp.next;
        }
        
        
        
        tmp=head;
        int curr=0;
        int target = len-n;
        if(target==0) return head.next;
        
        while(curr<target-1) {
            curr++;
            tmp=tmp.next;
        }
        tmp.next=tmp.next.next;
        return head;
    }
}
