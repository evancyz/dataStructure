/**
 * Created by evan on 2019/3/30.
 *
 * 单链表的插入、删除、查找操作；
 * 链表中存储的是int类型的数据；
 */
public class SimpleLinkedList {

    Node head;

    public static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public void insertHead(int value) {

        Node node = new Node(value, null);

        if (head == null) {
            head = node;
            return;
        }

        node.next = head;
        head = node;
    }

    public void insertAfter(Node data, int value) {

        if (data == null) {
            return;
        }

        Node newNode = new Node(value, null);

        newNode.next = data.next;
        data.next = newNode;
    }

    public void insertBefore(Node data, int value) {
        if (data == null) {
            return;
        }

        Node newNode = new Node(value, null);

        //如果在头结点插入
        if (data.equals(head)) {
            insertHead(value);
            return;
        }
        //如果在非头结点之前插入

        Node search = head;

        while (search != null && search.next != data) {
            search = search.next;
        }

        if (search == null) {
            return;
        }

        data.next = search.next;
        search.next = newNode;
    }

    public void insertTail(int value) {

        if (head == null) {
            insertHead(value);
            return;
        }

        Node newNode = new Node(value, null);

        Node search = head;
        while (search.next != null) {
            search = search.next;
        }
        search.next = newNode;
    }

    public void deleteNode(Node node) {
        if (node == null) {
            return;
        }

        Node search = head;

        while (search != null && search.next != node) {
            search = search.next;
        }

        //没找到
        if (search == null) {
            return;
        }

        search.next = node.next;
        node = null;
    }

    public void deleteValue(int value) {

        if (head == null) {
            return;
        }

        Node search = head;
        while (search.next.data != value) {
            search = search.next;
        }

        if (search == null) {
            return;
        }
        search.next = search.next.next;
    }

    //头节点插入反转
    public static Node inverseLinkList_head(Node p){
        //先用一个临时节点
        Node HEAD = new Node(-1, null);
        HEAD.next = p;

        //当前正在处理的
        Node curr = p.next;

        //断掉p的引用,头插法,是逆序
        p.next = null;

        Node next;

        while (curr != null) {

            //给下一个需要处理的标个号
            next = curr.next;

            curr.next = HEAD.next;
            HEAD.next = curr;

            curr = next;

        }

        return HEAD.next;
    }

    //就地反转
    public static Node inverseLinkList(Node head){

        Node a = head;  //当前节点A
        Node b = head.next; //下个节点B
        Node tmp;  //下下个节点C

        head.next = null;

        while (b != null) {
            tmp = b.next; //记录C节点
            b.next = a; //a->b反向

            a = b; //移动到下一个节点
            b = tmp;
        }

        return a;
    }



    public void printAll() {

        Node tmp = head;

        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }


    }

    public static void main(String[] args) {

        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

        simpleLinkedList.insertTail(10);
        simpleLinkedList.insertTail(20);
        simpleLinkedList.insertTail(30);
        simpleLinkedList.insertTail(40);

        simpleLinkedList.printAll();
        System.out.println("============");

        Node node = SimpleLinkedList.inverseLinkList(simpleLinkedList.head);

        Node tmp = node;
        while (node != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;

        }

    }

}
