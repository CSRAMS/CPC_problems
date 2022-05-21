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

 //copy this into leetcode here: https://leetcode.com/problems/remove-nth-node-from-end-of-list/

 //fix my mistakes!

 //hint: I added extra/deleted a lot of "next" 


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int length = -1;
        while(head != null){
            head = head.next;
        }
        head = cur;

        for(int a = 0; a < length-n; a++){
            head = head.next.next;
        }
        
        if(length == n-1){ cur = head; }
        else if(head.next==null){ cur = null; }
        else if(head.next.next==null){ head = null; }
        else{ head.next = head.next; }
        
        return cur;

    }
    
    
}