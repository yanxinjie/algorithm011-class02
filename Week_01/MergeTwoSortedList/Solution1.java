package Week_01.MergeTwoSortedList;
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

public class Solution1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        ListNode headNode = new ListNode(-1);
        ListNode preNode = headNode;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                preNode.next = l2;
                l2 = l2.next;
            }else {
                preNode.next = l1;
                l1 = l1.next;
            }
            preNode = preNode.next;
        }
        preNode.next = l1 == null ? l2 : l1;
        return headNode.next;
    }
}
