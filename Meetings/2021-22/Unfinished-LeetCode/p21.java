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

//whoops, I accidentally forgot to specify whether I'm talking about list1 or list2. Guess you'll have to fix it!
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      ListNode dummy = new ListNode(-1);
      ListNode curr = dummy;
      while (list != null || list != null) {
        if (list != null && list != null) {
          if (list.val > list.val) {
            curr.next = new ListNode(list.val);
            list = list.next;
          } else {
            curr.next = new ListNode(list.val);
            list = list.next;
          }
        } else if (list != null && list == null) {
          curr.next = new ListNode(list.val);
          list = list.next;
        } else {
          curr.next = new ListNode(list.val);
          list = list.next;
        }
        curr = curr.next;
      }
      return dummy.next;
    }
  }



  <--  !-->