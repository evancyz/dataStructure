import domain.Node;

/**
 * Created by evan on 2019/4/1.
 *
 * 链表反转应用
 *
 */
public class LinkedListApp {

    /**
     * 遍历一次得到中间节点
     * @param head
     *
     * 看过滤第一个
     * Head为奇数节点
     * @return
     */
    public static Node getMiddle(Node head) {

        if (head == null && head.next == null) {
            return null;
        }

        Node slow = head.next;
        Node fast = head.next.next;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == null) {
                //偶数不管了
                System.out.println("该节点是偶数节点");
                return null;
            }
        }

        return slow;
    }

    /**
     * 遍历一次得到中间节点
     * 从Head开始
     * @param head
     * @return
     */

    public static Node getMiddle2(Node head) {

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }
        Node slow = head;

        Node fast = head;

        while (fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (fast == null) {
                System.out.println("该节点为偶数节点");
                return null;
            }
        }
        return slow;
    }

    /**
     * 判断是否为回文节点
     * @param head
     * @return
     */
    public static boolean palindrome(Node head) {

        //先找到中间节点
        Node middle = getMiddle(head);

        //左边
        Node leftHead = new Node(head.data);

        Node tmp = leftHead;
        Node next = head.next;

        if (next != null && !next.equals(middle)) {

            Node node = new Node(next.data);

            tmp.next = node;
            tmp = node;

            next = next.next;
        }

        //最后一个节点
        tmp.next = new Node(middle.data);

        Node rightHead = null;

        while (middle != null) {

            Node node = new Node(middle.data);

            node.next = rightHead;
            rightHead = node;

            middle = middle.next;
        }

        printAll(leftHead);
        printAll(rightHead);

        return equal(leftHead, rightHead);

    }

    public static void printAll(Node head) {

        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    public static boolean equal(Node left, Node right) {

        while (left != null && right != null) {

            if (left.data != right.data) {
                return false;
            }

            left = left.next;
            right = right.next;
        }

        if (left == null && right == null) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        //SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
        //
        //simpleLinkedList.insertTail(1);
        //simpleLinkedList.insertTail(2);
        //simpleLinkedList.insertTail(3);
        //simpleLinkedList.insertTail(4);
        //simpleLinkedList.insertTail(5);
        //
        //Node middle = getMiddle2(simpleLinkedList.head);
        //
        //System.out.println(Optional.ofNullable(middle).map(e -> e.data).orElse(null));

        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

        simpleLinkedList.insertTail(1);
        simpleLinkedList.insertTail(2);
        simpleLinkedList.insertTail(3);
        simpleLinkedList.insertTail(2);
        simpleLinkedList.insertTail(1);

        System.out.println(palindrome(simpleLinkedList.head));
    }




}
