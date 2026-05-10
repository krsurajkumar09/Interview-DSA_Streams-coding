package LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeTwoSortedLinkedLists {

    // Function to merge two sorted linked lists
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Dummy node
        ListNode dummy = new ListNode(-1);

        // Pointer to build merged list
        ListNode current = dummy;

        // Compare nodes from both lists
        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        // Attach remaining nodes
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // Return merged list
        return dummy.next;
    }

    // Utility method to print linked list
    public static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    // Main method
    public static void main(String[] args) {

        // Creating first linked list: 1 -> 2 -> 4
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        // Creating second linked list: 1 -> 3 -> 5
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(5);

        // Merge lists
        ListNode mergedHead = mergeTwoLists(list1, list2);

        // Print merged list
        System.out.println("Merged Linked List:");
        printList(mergedHead);
    }
}