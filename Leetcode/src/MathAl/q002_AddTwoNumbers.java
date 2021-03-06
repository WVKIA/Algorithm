package MathAl;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * @author wukai
 * @date 2019/5/8
 */
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

public class q002_AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode pre = null;

        while (l1 != null || l2 != null) {
            ListNode node = new ListNode(l1.val + l2.val);
            l1 = l1.next;
            l2 = l2.next;
            if (head == null) {
                head = node;
                pre = node;
                continue;
            }
            pre.next = node;
            pre = pre.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode l = addTwoNumbers(l1, l2);

        ListNode temp=l;

        while (temp != null) {
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
    }

}
