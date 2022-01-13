/**
 * This program merges multiple ordered linked lists, preserving the order of the nodes.
 *
 * Definition for singly-linked list:
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.util.PriorityQueue;


class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode retHead = null;
        ListNode retTail = null;
        
        PriorityQueue q = new PriorityQueue<ListNode>((ListNode l1, ListNode l2)->l1.val-l2.val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) q.add(lists[i]);
        }
        
        if (!q.isEmpty()) {
            ListNode tmp = (ListNode)q.poll();
            retHead = tmp;
            if (tmp.next != null) q.add(tmp.next);
            retTail = tmp;
        }
        
        while (!q.isEmpty()) {
            ListNode tmp = (ListNode)q.poll();
            retTail.next = tmp; 
            if (tmp.next != null) q.add(tmp.next);
            retTail = tmp;
        }
        
        if (retTail != null) retTail.next = null;
        
        return retHead;
    }
}
