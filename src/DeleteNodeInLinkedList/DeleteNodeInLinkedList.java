package DeleteNodeInLinkedList;
public class DeleteNodeInLinkedList {
    public static void main(String[] args) {

        // Simple Test Code

        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        printNodes(head);

        
        Solution solution = new Solution();
        solution.deleteNode(head.next);
        printNodes(head);
    }

    public static void printNodes (ListNode node) {
        
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        do {
            sb.append(node.val + ", ");
            node = node.next;
        } while (node != null);
        sb.delete(sb.length() - 2, sb.length());
        sb.append("}");

        // Input Head
        System.out.println("Head : " +sb.toString());
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


class Solution {
    public void deleteNode(ListNode node) {
    node = deleteNodeRecurive(node, node);
    }
    
    public ListNode deleteNodeRecurive(ListNode node, ListNode current){

        current.val = current.next.val;
        if(current.next.next == null){
            current.next = null;
            return node;
        }
        return  deleteNodeRecurive(node,current.next);
    }
}