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
    //Time complexity: O(Nlogk)
    //Space complexity: O(N)
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode head:lists){
            if(head!=null){
                pq.add(head);
            }
        }
        ListNode res=new ListNode(-1); 
        ListNode curr=res;
        while(!pq.isEmpty()){
            ListNode min=pq.poll();
            curr.next=min;
            curr=curr.next;
            if(min.next!=null){
                pq.add(min.next);
            }
        }
        return res.next;
    }
}