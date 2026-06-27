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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        ArrayList <Integer> arr = new ArrayList<>();
        ListNode odd = head;
        ListNode even = head.next;
        while(odd!=null && odd.next!=null){
            arr.add(odd.val);
            odd = odd.next.next;
        }
        if(odd!=null) arr.add(odd.val);
        while(even!=null && even.next!=null){
            arr.add(even.val);
            even = even.next.next;
        }
        if(even!=null) arr.add(even.val);
        ListNode temp = head;
        int i=0;
        while(temp!=null){
            temp.val = arr.get(i);
            i++;
            temp=temp.next;
        }
        return head;
    }
}