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

/**
 * 递归
 */
public class Solution2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        ListNode result = l1.val > l2.val ? l2 : l1;
        result.next = mergeTwoLists(result.next, l1.val > l2.val ? l1 : l2);
        return result;
    }
}
