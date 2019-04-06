/**
 * Created by evan on 2019/4/6.
 *
 * 使用浏览器模仿栈的前进和后退
 */
public class SampleBrowser {

    //前进栈
    SimpleStack forward = new SimpleStack();
    //后退栈
    SimpleStack back = new SimpleStack();

    //打开链接
    public void open(String url) {

        if (forward.head != null) {

            //当没有进行过前进后退操作
            if (forward.head.next == null) {
                back.push(forward.pop().value);
            }else {//如果有过前进后退
                //弹出当前页,压到返回里面
                back.push(forward.pop().value);
                //把前进里的前进页都去掉
                forward.head = null;
            }
        }

        forward.push(url);
    }


    //前进
    public boolean forward() {

        if (forward.head == null || forward.head.next == null) {
            return false;
        }

        back.push(forward.pop().value);
        return true;
    }

    //后退
    public boolean back() {

        if (back.head == null) {
            return false;
        }

        forward.push(back.pop().value);
        return true;
    }

    public void printCondition() {

        printInverse(back.head);

        boolean current = false;
        SimpleStack.Node forwardTmp = forward.head;

        while (forwardTmp != null) {

            String value = forwardTmp.value;

            if (!current) {
                value = "*" + value;
                current = true;
            }
            System.out.print(value + ",");
            forwardTmp = forwardTmp.next;
        }

    }


    boolean printInverse(SimpleStack.Node node) {

        if (node == null) {
            return true;
        }

        if (printInverse(node.next)) {
            System.out.print(node.value+",");
        }

        return true;
    }




    public static void main(String[] args) {

        SampleBrowser browser = new SampleBrowser();

        browser.open("A");
        browser.open("B");
        browser.open("C");
        browser.back();
        browser.forward();
        browser.back();
        browser.open("D");

        browser.printCondition();

    }





}
