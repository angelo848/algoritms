package org.example.medium.addTwoNumbers;

// LeetCode link: https://leetcode.com/problems/add-two-numbers/
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
public class Solution {

  /**
   * Iterates the two list nodes, checking whether if each node is the last, if at least one node has values, the other list node value
   * will be considered zero. For each node, sums the 2 values and concatenate at the final sum string and after creates a new ListNode
   * from the sum string created.
   * @param l1 first list node
   * @param l2 second list node
   * @return list node with sum of the two list nodes
   */
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode currentNodeL1 = l1;
    ListNode currentNodeL2 = l2;
    String sum = "";
    int add = 0;

    boolean isLastNode;
    do {
      isLastNode = (currentNodeL1 == null || currentNodeL1.next == null) && (currentNodeL2 == null || currentNodeL2.next == null);

      int currentNode1Val = currentNodeL1 == null ? 0 : currentNodeL1.val;
      int currentNode2Val = currentNodeL2 == null ? 0 : currentNodeL2.val;
      int currentSum = currentNode1Val + currentNode2Val + add;

      // if sum have 2 digits, will only concat the last digit and add a dozen in the next loop
      if (currentSum > 9 && !isLastNode) {
        currentSum = currentSum % 10;
        add = 1;
      } else {
        add = 0;
      }
      sum = String.valueOf(currentSum).concat(sum);

      currentNodeL1 = currentNodeL1 != null ? currentNodeL1.next : null;
      currentNodeL2 = currentNodeL2 != null ? currentNodeL2.next : null;
    } while (!isLastNode);

    return generateListNodeFromStringReverting(sum, null);
  }

  /**
   * Receives a string representation of a number and creates a ListNode, where the deepest node will be the first digit of the string,
   * and the first node will be the last digit, reverting the string.
   * @param nums receives a string of number digits
   * @param lastNode receives the pastNode
   * @return ListNode with all the latest nodes or if are the deepest node, the final node
   */
  public static ListNode generateListNodeFromStringReverting(String nums, ListNode lastNode) {
    if (nums.length() == 1) {
      return new ListNode(
        Integer.parseInt(nums.substring(0, 1)),
        lastNode
      );
    }

    return generateListNodeFromStringReverting(nums.substring(1), new ListNode(
      Integer.parseInt(nums.substring(0, 1)),
      lastNode)
    );
  }


  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public static void main(String[] args) {
//    ListNode l1 = new ListNode(
//      9,
//      new ListNode(
//        9,
//        new ListNode(
//          9,
//          new ListNode(
//            9,
//            new ListNode(
//              9,
//              new ListNode(
//                9,
//                new ListNode(
//                  9
//                )
//              )
//            )
//          )
//        )
//      )
//    );
//    ListNode l2 = new ListNode(
//      9,
//      new ListNode(
//        9,
//        new ListNode(
//          9,
//          new ListNode(
//            9
//          )
//        )
//      )
//    );
    ListNode l1 = new ListNode(
      2,
      new ListNode(
        4,
        new ListNode(3)
      )
    );
    ListNode l2 = new ListNode(
      5,
      new ListNode(
        6,
        new ListNode(4)
      )
    );

    System.out.println(addTwoNumbers(l1, l2));
  }
}
