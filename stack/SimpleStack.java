/**
 * Created by evan on 2019/4/6.
 *
 * 基于链表实现的栈
 *
 * 先进后出
 *
 * 入栈和出栈
 */
public class SimpleStack {

    Node head;

    //入栈操作
    public void push(String value) {

        Node node = new Node(value);

        if (head == null) {
            head = node;
        }else {
            node.next = head;
            head = node;
        }
    }

    //出栈
    public Node pop() {
        if (head == null) {
            System.out.println("栈为空");
            return null;
        }

        Node data = head;

        head = head.next;

        return data;
    }

    public void printAll() {

        Node tmp = head;

        while (tmp != null) {
            System.out.println(tmp.value);
            tmp = tmp.next;
        }

    }

    public static void main(String[] args) {

        SimpleStack stack = new SimpleStack();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");

        stack.printAll();

        System.out.println("==============");

        stack.pop();


        stack.printAll();

    }


    public static class Node {

        String value;
        Node next;

        public Node(String value) {
            this.value = value;
        }
    }



}
