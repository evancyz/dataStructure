import domain.Node;
import java.util.ArrayList;

/**
 * Created by evan on 2019/4/1.
 *
 * 单链表反转
 *
 * 数组反转,头插入反转,就地反转
 *
 * 带哨兵节点(dummy node)与不带哨兵节点的对比
 */
public class LinkedListInverse {

    //就地反转
    public static Node directInverse(Node head) {

        if (head == null) {
            return null;
        }

        //单节点
        if (head.next == null) {
            return head;
        }

        //当前节点head
        Node a = head;
        //需要反转的节点
        Node b = head.next;
        //下一个需要反转的节点
        Node tmp;

        //把头结点致空
        head.next = null;

        while (b != null) {
            //记录下一个需要反转的节点
            tmp = b.next;

            b.next = a;

            //前进
            a = b;
            b = tmp;
        }
        return a;
    }

    //头插法反转  新增链表
    public static Node headInsertInverseAdd(Node head) {

        if (head == null) {
            return null;
        }

        //上一个头结点
        Node pre = null;
        //新的头结点
        Node newHead = null;

        while (head != null) {

            newHead = new Node(head.data);
            newHead.next = pre;

            //前进
            pre = newHead;
            head = head.next;
        }

        return newHead;
    }

    //头插法反转 不新增
    public static Node headInsertInverse(Node p) {

        //需要4个指针
        Node head = p; //指向头结点
        Node curr = p.next; //当前处理的节点
        //把尾节点next给他切断
        p.next = null;

        Node tmp; //下一个节点

        while (curr != null) {

            tmp = curr.next;

            curr.next = head;

            head = curr;
            curr = tmp;
        }

        return head;
    }


    //头插法反转,加入哨兵节点(dummy) 明显就比 headInsertInverse 这个要简单的多,因为加入了一个不变的Head
    public static Node headInsertInverseWithDummy(Node p){
        //先用一个临时节点
        Node dummy = new Node(-1, null);
        dummy.next = p;

        //当前正在处理的
        Node curr = p.next;

        //断掉p的引用,头插法,是逆序
        p.next = null;

        Node tmp;

        while (curr != null) {

            //给下一个需要处理的标个号
            tmp = curr.next;

            curr.next = dummy.next;
            dummy.next = curr;

            curr = tmp;

        }

        return dummy.next;
    }


    //数组反转
    public static Node arrayInverse(Node head) {

        if (head == null) {
            return null;
        }

        ArrayList<Node> array = new ArrayList<>();

        while (head != null) {
            array.add(head);
            head = head.next;
        }

        for (int i = array.size() - 1; i >= 0; i--) {

            Node node = array.get(i);

            //如果只有一个节点
            if (i == 0) {
                node.next = null;
            }else {
                node.next = array.get(i - 1);
            }
        }

        return array.get(array.size() - 1);
    }

    public static void main(String[] args) {

        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

        simpleLinkedList.insertTail(10);
        simpleLinkedList.insertTail(20);
        simpleLinkedList.insertTail(30);
        simpleLinkedList.insertTail(40);

        simpleLinkedList.printAll();
        System.out.println("============");

        Node node = LinkedListInverse.headInsertInverse(simpleLinkedList.head);
        //Node node = LinkedListInverse.arrayInverse(simpleLinkedList.head);
        //Node node = LinkedListInverse.headInsertInverse(simpleLinkedList.head);

        Node tmp = node;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;

        }

    }






}
