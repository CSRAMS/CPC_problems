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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int length = -1;
        while(head != null){
            head = head.next;
            length++;
        }
        head = cur;

        for(int a = 0; a < length-n; a++){
            head = head.next;
        }
        
        if(length == n-1){ cur = head.next; }
        else if(head.next==null){ cur = null; }
        else if(head.next.next==null){ head.next = null; }
        else{ head.next = head.next.next; }
        
        return cur;

    }
    
    
}