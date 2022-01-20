/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.math.*;
import java.util.*;
import java.io.*;
//add two integers in place
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(-1);
        ListNode tmp = l;
        while ( (l1 != null) || (l2 != null) ) {
            proceed(l, l1, l2);
            l = l.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        ListNode curr = tmp;
        while (curr.next != null && curr.next.val != -1) curr = curr.next;
        curr.next = null;
        return tmp;
			
    }
  
    void proceed(ListNode l, ListNode l1, ListNode l2) {
        if (l1 == null) {
            if (l.val == -1) l.val = l2.val; else l.val += l2.val;
            if (l.next == null) l.next = new ListNode(-1);
            if (l.val > 9) {
                l.val -= 10;
                l.next.val = 1;
            }
        } else if (l2 == null) {
            if (l.val == -1) l.val = l1.val; else l.val += l1.val;
            if (l.next == null) l.next = new ListNode(-1);
            if (l.val > 9) {
                l.val -= 10;
                l.next.val = 1;
            }
        } else {
            if (l.val== -1) l.val = l1.val + l2.val; else l.val += l1.val + l2.val;
            if (l.next == null) l.next = new ListNode(-1);
            if (l.val > 9) {
                l.next.val = l.val / 10;
                l.val %= 10;
            }
        }
    }
}
