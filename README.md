## 手动实现常见的数据结构和算法

### 数据结构

##### 数组
* <code>SimpleArray</code> 数组的插入,删除,按照下标随机访问

##### 链表
* <code>SimpleLinkedList</code> 单链表的插入、删除、查找操作 
* <code>LinkedListInverse</code> 单链表反转
	* <code>directInverse()</code>就地反转
	* <code>headInsertInvers\*()</code>头插法反转（*\*号表示有多种实现*）
	* <code>arrayInverse()</code>借助数组反转
* <code>LinkedListApp</code> 单链表应用
	* <code>getMiddle()\*</code>	获取单链表中间节点（*\*号表示有多种实现*）
	* <code>palindrome()</code> 判断链表是否为回文链表

##### 栈
* <code>SimpleStack</code> 基于单链表实现的栈，提供入栈和出栈
* <code>SampleBrowser</code> 基于栈模拟浏览器的前进和后退
	* <code>printInverse()</code> 递归逆序打印节点值

##### 队列
* <code>SimpleArrayQueue</code> 基于数组实现先进先出的队列
  *  实现为循环数组,入队出队只改变指针位置,不进行数据搬移

### 算法
* <code>SimpleSort</code>简单排序
	* <code>insertionSort</code>插入排序
	* <code>selectionSort</code>选择排序
	* <code>bubbleSort</code>冒泡排序 	