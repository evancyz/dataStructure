import domain.Node;

/**
 * Created by evan on 2019/3/30.
 *
 * 单链表的插入、删除、查找操作；
 * 链表中存储的是int类型的数据；
 */
public class SimpleLinkedList {

    Node head;

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
    }

}
