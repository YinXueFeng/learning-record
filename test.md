# 1、Typora 语法

## 1.1 标题#

## 1.2 段落

Shif+Enter

## 1.3 列表（* list item 1）

* *为无序列表
* 1.有序列表



## 1.4 字体相关

### 1.4.1 字体加粗

**两个星号，字体加粗**

__两个下划线字体加粗__

***三个星号，加粗斜体***

~~两个~删除线~~



### 1.4.2 下划线





# 2、Java基础语法

## 2.1 Java中的数据类型

Java中数据类型分为：`基本数据类型`和`引用数据类型`两个大类，其中：

* 基础数据类型：

  | 名称         | 数据类型 | 位数 | 默认值 | 取值范围       | 举例说明          |
  | ------------ | -------- | ---- | ------ | -------------- | ----------------- |
  | 字节型       | byte     | 8    | 0      | -2^7 - 2^7-1   | byte b = 10;      |
  | 短整型       | short    | 16   | 0      | -2^15 - 2^15-1 | short s = 10;     |
  | 整型         | int      | 32   | 0      | -2^31 - 2^31-1 | int i = 10;       |
  | 长整型       | long     | 64   | 0      | -2^63 - 2^63-1 | long l = 10L;     |
  | 单精度浮点型 | float    | 32   | 0.0    | -2^31 - 2^31-1 | float f = 10.0f;  |
  | 双精度浮点型 | double   | 64   | 0.0    | -2^63 - 2^63-1 | double d = 10.0d; |
  | 字符型       | char     | 16   | null   | 0 - 2^16-1     | char c = 'c';     |
  | 布尔型       | boolean  | 8    | false  | true、false    | boolean b = true; |

  

* 引用类型：

  * 类：
  * 接口：
  * 数组：
  * 枚举：
  * 注解：

### 2.1.2 基本数据类型与引用数据类型在jvm中的分配位置



## 2.2 多线程

### 2.2.1 基本概念：程序/进程/线程

1. 程序：是为完成特定任务、用某种语言编写的一组指令的集合。即**一段静态的代码**，静态对象。
2. 进程：是程序的一次执行过程，或是**正在运行的一个程序**。是一个动态的过程：有它自身的产生、存在和消亡的过程——**生命周期**。
   * 程序是静态的，进程是动态的
   * **进程作为资源分配的单位**，系统在运行时会为每个进程分配不同的内存区域。

3. 线程：进程可进一步细化为线程，是一个程序内部的一条执行路径。
   * 若一个进程同一时间**并行**执行多个线程，就是支持多线程的
   * **线程作为调度和执行的单位，每个线程拥有独立的运行站和程序计数器（PC）**，线程切换的开销小
   * 一个进程中的多个线程共享相同的内存单元/内存地址空间——它们从同一个堆中分配对象，可以访问相同的变量和对象。这使得线程间通信更简便高效。但是多个线程操作共享的系统资源可能就会带来安全隐患。

### 2.2.2 线程的生命周期

```java
public enum State {
        /**
         * Thread state for a thread which has not yet started.
         */
        NEW,

        /**
         * Thread state for a runnable thread.  A thread in the runnable
         * state is executing in the Java virtual machine but it may
         * be waiting for other resources from the operating system
         * such as processor.
         */
        RUNNABLE,

        /**
         * Thread state for a thread blocked waiting for a monitor lock.
         * A thread in the blocked state is waiting for a monitor lock
         * to enter a synchronized block/method or
         * reenter a synchronized block/method after calling
         * {@link Object#wait() Object.wait}.
         */
        BLOCKED,

        /**
         * Thread state for a waiting thread.
         * A thread is in the waiting state due to calling one of the
         * following methods:
         * <ul>
         *   <li>{@link Object#wait() Object.wait} with no timeout</li>
         *   <li>{@link #join() Thread.join} with no timeout</li>
         *   <li>{@link LockSupport#park() LockSupport.park}</li>
         * </ul>
         *
         * <p>A thread in the waiting state is waiting for another thread to
         * perform a particular action.
         *
         * For example, a thread that has called <tt>Object.wait()</tt>
         * on an object is waiting for another thread to call
         * <tt>Object.notify()</tt> or <tt>Object.notifyAll()</tt> on
         * that object. A thread that has called <tt>Thread.join()</tt>
         * is waiting for a specified thread to terminate.
         */
        WAITING,

        /**
         * Thread state for a waiting thread with a specified waiting time.
         * A thread is in the timed waiting state due to calling one of
         * the following methods with a specified positive waiting time:
         * <ul>
         *   <li>{@link #sleep Thread.sleep}</li>
         *   <li>{@link Object#wait(long) Object.wait} with timeout</li>
         *   <li>{@link #join(long) Thread.join} with timeout</li>
         *   <li>{@link LockSupport#parkNanos LockSupport.parkNanos}</li>
         *   <li>{@link LockSupport#parkUntil LockSupport.parkUntil}</li>
         * </ul>
         */
        TIMED_WAITING,

        /**
         * Thread state for a terminated thread.
         * The thread has completed execution.
         */
        TERMINATED;
    }
```



![线程的生命周期](D:\Program Files\Typorab\notes\线程的生命周期.png)



1. 新建：当使用new关键字创建了一个线程后，该线程就处于新建状态，此时JVM为其分配内存并初始化其成员变量的值；
2. 就绪：当调用了start()方法后，该线程处于就绪状态，此时JVM为其创建**方法调用栈和程序计数器**，等待调度运行；
3. 运行：处于就绪状态的线程获得了CPU执行权，开始执行run()方法的线程执行体，则该线程处于运行状态；
4. 阻塞：当处于运行状态的线程失去占用的资源，进入阻塞状态；
5. 死亡：当线程正常执行完run()或者发生错误及异常或调用stop()，则该线程结束。

### 2.2.3 线程的创建方式

* 继承Thread类

  * 创建一个类，继承Thread类
  * 重写Thread的run()方法
  * 创建Thread类的子类对象
  * 通过此对象调用start()

  注意：

  1. 启动一个线程，必须调用start()，不能以调用run()的方式启动线程
  2. 已经启动一次线程的情况下，如果再启动一个线程，必须重新创建一个Thread子类的对象，调用此对象的start()。

* 实现Runnable接口

  * 创建一个实现了Runnable接口的类
  * 实现类去实现Runnable接口的抽象方法：run()
  * 创建实现类的对象
  * 将次对象作为参数传递到Thread类的构造器中，创建Thread类的对象
  * 通过Thread类的对象调用start()



​		继承Thread类与实现Runnable接口的对比：

​			开发中，优先选择**实现Runnable接口的方式**

​			原因：实现Runnable接口的方式没有类的单继承性的局限性；

​							实现Runnable接口的方式更适合处理多个线程共享数据的情况。

​		联系：public class Thread implements Runnable

​		相同点：两种方式都需要重写run()，将线程要执行的逻辑声明在run()中

* 实现Callable接口

   * 创建一个实现Callable<T>的类

   * 实现call()方法，

   * 创建Callable实现类的对象

   * 将Callable实现类的对象作为构造器参数，传入FutureTask中，创建FutureTask的对象

   * 将FutureTask的对象作为参数传入Thread中，创建Thread的对象

   * 使用Thread的对象调用start()

     如何理解实现Callable接口的方式创建多线程比实现Runnable接口创建多线程的方式强大？

     1）call()可以有返回值

     2）call()可以抛出异常，被外面的操作捕获，获取异常的信息

     3）Callable支持泛型

* 线程池

  * 创建实现Runnable接口或Callable接口的子类对象

  * 调用Executors.xxxx创建线程池

  * 将子类对象作为execute()或submit()的参数

    

  JDK5起提供了线程池相关API，**ExecutorService**和**Executors**

  * ExecutorService：真正的线程池接口。常见子类ThreadPoolExecutor
    * void execute(Runnable command)：执行任务/命令，没有返回值，一般用来执行Runnable
    * <T> Future<T> submit(Callable<T> task)：执行任务，有返回值，一般用来执行Callable
    * void shutdown()：关闭线程池。

  * Executors：工具类/线程池的工厂类，用于创建并返回不同类型的线程池
    * Executors.newCachedThreadPool()：创建一个可根据需要创建新线程的线程池；
    * Executors.newFixedThreadPool(int n)：创建一个可重用固定线程数的线程池；
    * Executors.newSingleThreadExecutor()：创建一个只有一个线程的线程池；
    * Executors.newScheduledThreadPool(int corePoolSize,)：创建一个线程池，它可安排在给定延迟后运行。

  * 使用线程池的好处

    * 提高相应速度（减少了创建新线程的时间）

    * 降低资源消耗（重复使用线程池中线程，不需要每次都创建销毁）

    * 便于线程管理：

      1）corePoolSize：线程池大小

      2）maximumPoolSize：最大线程数

      3）keepAliveTime：线程没有任务时最多保持多长时间后终止

      4）。。。

```java
public class CreateThread{
    /**
     * 创建线程有四种方式：
     *  1. 继承Thread类
     *  2. 实现Runnable接口
     *  3. 实现Callable接口
     *  4. 使用线程池
     */

    public static void main(String[] args) {

        // 方法一：继承Thread类
        Ticket t1 = new Ticket();
        Ticket t2 = new Ticket();
        Ticket t3 = new Ticket();
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();


        // 方法二：实现Runnable接口
        TicketTwo ticketTwo = new TicketTwo();
        Thread thread1 = new Thread(ticketTwo);
        Thread thread2 = new Thread(ticketTwo);
        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread1.start();
        thread2.start();

        // 方法三：实现Callable接口，需要借助FutureTask
        TicketThree ticketThree = new TicketThree();
        FutureTask<Integer> future = new FutureTask<Integer>(ticketThree);
        new Thread(future).start();
        try {
            Integer integer = future.get();
            System.out.println(integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // 方法四：使用线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newScheduledThreadPool(100);
        
        // 适合使用Runnable
        service.execute(new TicketTwo());
        // 适合使用Callable
//        service.submit(Callable callable);
    }
}



/**
 * 方法一：继承Thread类
 *  1. 继承Thread类
 *  2. 重写run()方法
 *  3. 创建子类对象
 *  4. 调用子类对象的start()方法
 */
class Ticket extends Thread {
    private int ticket = 100;
    @Override
    public  void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName()+"卖票，票号：" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }

}


/**
 * 方式二：实现Runnable接口
 *  1. 创建实现Runnable接口的类
 *  2. 实现Runnable的抽象方法run()
 *  3. 创建实现类的对象
 *  4. 将此对象作为构造器参数，传入Thread类中
 *  5. 通过Thread类的对象调用run()
 *
 */
class TicketTwo implements Runnable {
    private int ticket = 100;
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName()+"卖票，票号：" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}

/**
 * 方式三：实现Callable接口
 *  1. 创建一个实现Callable<T>的类
 *  2. 实现call()方法，
 *  3. 创建Callable实现类的对象
 *  4. 将Callable实现类的对象作为构造器参数，传入FutureTask中，创建FutureTask的对象
 *  5. 将FutureTask的对象作为参数传入Thread中，创建Thread的对象
 *  6. 使用Thread的对象调用start()
 *
 */
class TicketThree implements Callable<Integer> {
    private int ticket = 100;
    public Integer call() throws Exception {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName()+"卖票，票号：" + ticket);
                ticket--;
            } else {
                break;
            }
        }
        return ticket;
    }
}
```

### 2.2.4 线程同步

* 线程安全问题



* 同步代码块处理线程安全



* 同步方法处理线程安全



* Lock锁处理线程安全





# 3、JVM相关

## 3.1 jvm基本模型图





## 3.2 jvm中一些概念

### 3.2.1 程序计数器(Program Counter Register)

程序计数器是一块较小的内存空间，`可以看作是`当前线程所执行的字节码的行号指示器。

在java虚拟机的`概念模型`<sup>[1]</sup>里，字节码解释器工作时就是通过改变这个计数器的值来选取吓一跳需要执行的字节码指令，它是程序控制流的指示器，分支、循环、跳转、异常处 理、线程恢复等基础功能都需要依赖这个计数器来完成。

程序计数器是线程私有的，每个线程都有一个独立的程序计数器，各个线程之间计数器互不影响，独立存储。

如果线程正在执行的是一个**`Java方法`**，这个计数器记录的是正在执行的虚拟机字节码指令的地 址；如果正在执行的是**`本地（Native）方法`**，这个计数器值则应为空（Undefined）。此内存区域是唯 一一个在《Java虚拟机规范》中没有规定任何OutOfMemoryError情况的区域。

### 3.2.2 Java虚拟机栈(Java Virtual Machine Stack)



### 3.2.3 本地方法栈



### 3.2.4 Java堆



### 3.2.5 方法区



### 3.2.6 运行时常量池



### 3.2.7 直接内存



## 3.3 对象



# 4、数据结构

数据结构从逻辑上划分为四种基本类型：集合、线性结构、树形结构、图状结构；

顺序存储结构、链式存储结构；

## 4.1 线性表

线性表：

​	线性表的顺序表示：用一组地址连续的存储单元依次存储线性表的数据元素。

​	线性表的链式表示：线性链表、循环链表、双向链表。



## 4.2 栈

栈也是线性表的一种，其特殊性在于栈的基本操作是线性表操作的子集，是操作受限的线性表。

### 4.2.1 定义

栈（stack）是限定仅在表（线性表）尾进行插入或删除操作的线性表。因此，对栈来说，表尾端称为栈顶（top），表头端称为栈底（bottom），不含元素的空表称为空栈。

栈是特殊的线性表，所以对栈的实现也有两种：顺序存储结构，链式存储结构。

### 4.2.2 特点

栈的修改按后进先出的原则，即后进先出线性表（last in first out）(LIFO)。

## 4.3 队列



## 4.4 树

### 4.4.1 树的基本知识

1. 定义

![树的定义](D:\Program Files\Typorab\notes\树的定义.png)

2. 树的特点

   树是n(n>=0)个节点的有限集。

   在任意一棵非空树种：

   * 有且仅有一个特定的称为***根*** 的节点；

   * 当n>1时，其余节点可分为m(m>0)个互不相交的有限集T<sub>1</sub>,T<sub>2</sub>,·······,T<sub>m</sub>，其中每一个集合本身又是一棵树，并且称为根的子树。

3. 树结构中的一些基本术语

   树示例：

![树](D:\Program Files\Typorab\notes\树示例.png)

* 树的**结点**包含一个数据元素及若干指向其子树的分支。
* 结点拥有的子树数称为**结点的度**（Degree），如上图，A的度为3，C的度为1，F的度为0。
* 度为0的结点称为**叶子**（Leaf）或终端结点，如上图，K、L、F、G、M、I、J都是树的叶子。
* 度不为0的结点称为**分支结点**或非终端结点。
* **树的度**是树内各节点的度的最大值，如上图，树的度为3。
* 结点的子树的根称为该结点的**孩子**，相应地，该结点称为孩子的**双亲**，如上图D为A的子树T<sub>3</sub>的根，则D为A的孩子，而A是D的双亲。
* 同一个双亲的孩子之间互称为**兄弟**。
* 结点的**祖先**是从根到该结点所经分支上的所有结点，以某结点为根的子树中的任一结点都称为该结点的子孙。
* 结点的**层次**是从根开始定义起，根为第一层，根的孩子为为第二层。若某结点在第 l 层，则其子树的根就在第 l+1 层。双亲在同一层的结点互为堂兄弟。
* 树中结点的最大层次称为树的**深度**。
* 如果书中结点的各子树看成从左至右是有次序的（即不能互换），则称该树为**有序树**，否则称为**无序数**。
* **森林**是m(m>=0)棵互不相交的树的集合。



### 4.4.2 二叉树

1. 二叉树的定义

   二叉树(Binary Tree)：每个结点至多只有两棵子树（即二叉树中不存在度大于2的结点），并且，二叉树的子树有左右之分，其次序不能任意颠倒。

2. 二叉树的5种基本形态

   ![二叉树的5种基本形态](D:\Program Files\Typorab\notes\二叉树的5种基本形态.png)

   （a) 空二叉树；(b)仅有根结点的二叉树；(c)右子树为空的二叉树；(d)左、右子树均非空的二叉树；(e)左子树为空的二叉树

3. 二叉树的性质

   * 在二叉树的第i层上至多右2<sup>i-1</sup>个结点(i>=1)。

   * 深度为k的二叉树至多有2<sup>k</sup>-1个结点(k>=1)。

   * 对任何一个二叉树**T**,如果其终端结点（叶子）结点数为**n<sub>0</sub>**，度为2的结点数为n<sub>2</sub>，则n<sub>0</sub>=n<sub>2</sub>+1。

   * 具有n个结点的完全二叉树的深度为  floor(log<sub>2</sub>n)  +1。 **(floor(x)表示不大于x的最大整数)**

   * 如果对一棵有n个结点的完全二叉树（其深度为 floor(log<sub>2</sub>n)  +1）的结点按层序编号（从第1层到第 floor(log<sub>2</sub>n)  +1层，每层从左到右），则对任一结点 i（l<=i<=n），有

     * 如果 i=1，则结点 i 是二叉树的根，无双亲；如果 i>1，则其双亲PARENT(i)是结点 floor(i/2)。
     * 如果 2i > n ，则结点 i 无左孩子(结点 i 为叶子结点)；否则其左孩子LCHILD(i)是结点 2i。
     * 如果 2i + 1 > n ，则结点 i 无右孩子；否则其右孩子RCHILD(i)是结点 2i + 1。

     

4. 满二叉树和完全二叉树

   * 一棵深度为k且有2<sup>k</sup>-1个结点的二叉树，称为**满二叉树**。

   * 对满二叉树的结点进行连续编号，约定编号从根结点起，自上而下，自左至右。

   * 深度为k的，有n个结点的二叉树，当且仅当其每一个结点都与深度为k的满二叉树中编号从1至n的结点一一对应时，称之为**完全二叉树**。

   * 满二叉树是完全二叉树，完全二叉树不一定是满二叉树。

5. 遍历二叉树

   深度优先遍历（先序遍历、中序遍历、后续遍历）

   广度优先遍历（层序遍历）

   * 先（根）序遍历
     * 若二叉树为空，则空操作
     * 访问根结点
     * 先序遍历左子树
     * 先序遍历右子树
   * 中（根）序遍历
     * 若二叉树为空，则空操作
     * 中序遍历左子树
     * 访问根结点
     * 中序遍历右子树
   * 后（根）序遍历
     * 若二叉树为空，则空操作
     * 后序遍历左子树
     * 后序遍历右子树
     * 访问根结点

   ```java
   public class BinaryTree {
   
       // 二叉树定义
       private static class TreeNode {
           int data;
           TreeNode leftChild;
           TreeNode rightChild;
   
           TreeNode(int data) {
               this.data = data;
           }
       }
   
       // 构建二叉树：以先序方式构建二叉树
       public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
           TreeNode node = null;
           if (inputList == null || inputList.isEmpty()) {
               return null;
           }
           Integer data = inputList.removeFirst();
           if (data != null) {
               node = new TreeNode(data);
               node.leftChild = createBinaryTree(inputList);
               node.rightChild = createBinaryTree(inputList);
           }
           return node;
       }
   
       // 先序遍历
       public static void preOrderTraversal(TreeNode node) {
           if (node == null) {
               return;
           }
           System.out.println(node.data);
           preOrderTraversal(node.leftChild);
           preOrderTraversal(node.rightChild);
       }
   
       // 中序遍历
       public static void inOrderTraversal(TreeNode node) {
           if (node == null) {
               return;
           }
           inOrderTraversal(node.leftChild);
           System.out.println(node.data);
           inOrderTraversal(node.rightChild);
       }
   
       // 后序遍历
       public static void postOrderTraversal(TreeNode node) {
           if (node == null) {
               return;
           }
           postOrderTraversal(node.leftChild);
           postOrderTraversal(node.rightChild);
           System.out.println(node.data);
       }
   
       public static void main(String[] args) {
           // null 表示该结点为空结点
           LinkedList<Integer> inputList = new LinkedList<Integer>(
                   Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4}));
           TreeNode node = createBinaryTree(inputList);
           System.out.println("前序遍历：");
           preOrderTraversal(node);
           System.out.println("中序遍历：");
           inOrderTraversal(node);
           System.out.println("后序遍历：");
           postOrderTraversal(node);
       }
   }
   ```

   

   * 层序遍历

     



# 5、算法

## 5.1 冒泡排序

### 5.1.1 算法描述



### 5.1.2 动画演示

![img](https://img-blog.csdnimg.cn/20190517142259572.gif)

### 5.1.3 代码实现

```java
	/**
     * 冒泡算法： 从小到大排序 （例）
     *  算法描述：
     *  1.比较相邻的两个元素，如果较大的排在前面，则交换两个元素的位置，否则位置不变
     *  2.对每一对相邻的元素都进行比较
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) { // 排多少趟
            for (int j = 0; j < arr.length - 1; j++) { // 每趟比较多少个元素
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

            // 输出记录
            printArr(arr, i);
        }
        return arr;
    }

	/**
     * 冒泡算法改进1：
     *      增加一个标识，当整个数组完成排序之后结束多余的遍历,
     *      完全排完序后，会多遍历一遍
     * @param arr
     * @return
     */
    public static int[] bubbleSortImprove(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            boolean sorted = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    sorted = false;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

            // 输出
            printArr(arr, i);

            // 改进
            if (sorted) {
                return arr;
            }
        }
        return arr;
    }

	/**
     * 冒泡排序算法改进2：
     *  分析：第一趟排序，最后一个数是所有数中最大的一个，所以在第二趟排序时，最后一个数不需要比较
     *      同样，第二趟排序之后，倒数第二个数一定是数组中第二大的数，
     *			所以第三趟排序时，最后两个数都不需要比较
     * @param arr
     * @return
     */
    public static int[] bubbleSortImprove2(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            boolean sorted = true;
            for (int j = 0; j < arr.length - (i+1); j++) {
                System.out.println("j="+j);
                if (arr[j] > arr[j + 1]) {
                    sorted = false;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

            // 输出
            printArr(arr, i);

            // 改进
            if (sorted) {
                return arr;
            }
        }
        return arr;
    }

	public static void printArr(int[] arr, int i) {
        // 输出记录
        String num = "";
        for (int j = 0; j < arr.length; j++) {
            num = num +","+ arr[j];
        }
        System.out.println("第"+(i+1)+"次排序：" + num);
    }

    /**
     * 随机生成一个包含10个元素的数组
     * @return
     */
    public static int[] randomArr() {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) Math.ceil(Math.random() * 100);
        }
        return arr;
    }

	public static void main(String[] args) {
        int[] arr = randomArr();
        for(int i = 0; i < 10; i++) {
            System.out.print("," + arr[i]);
        }
        bubbleSortImprove2(arr);
    }
```

### 5.1.3 算法分析



### 5.1.4 使用场景建议





## 5.2 选择排序

### 5.2.1 算法描述

n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：

- 初始状态：无序区为R[1..n]，有序区为空；
- 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
- n-1趟结束，数组有序化了。

### 5.2.3 动画演示

![img](https://img-blog.csdnimg.cn/20190517142411197.gif)

### 5.2.2 代码实现

```java
/**
     * 选择排序： 从小到大排序
     *  算法描述：
     *      1.第一次遍历数组，找到数组中最小的数，将第一位的数据与最小的值交换位置
     *      2.从第二个元素开始，找到剩余数组中最小的数，将其与第二个元素交换位置
     *      3.重复以上操作
     * @param arr
     * @return
     */
    public static int[] selectionSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int temp;
        int min;
        for (int i = 0; i < arr.length-1; i++) {
            min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;

            // 输出
            printArr(arr, i);
        }
        return arr;
    }
```



### 5.2.3 算法分析



MySQL实战、高性能MySQL



## 5.3 插入排序

### 5.3.1 算法描述

*概念：插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。

   插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。

 

*算法描述: 

 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：

- 从第一个元素开始，该元素可以认为已经被排序；
- 取出下一个元素，在已经排序的元素序列中从后向前扫描；
- 如果该元素（已排序）大于新元素，将该元素移到下一位置；
- 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
- 将新元素插入到该位置后；
- 重复步骤2~5。

### 5.3.2 动画演示

![img](https://img-blog.csdnimg.cn/20190517142521855.gif)



### 5.3.3 代码实现

```java
/**
     * 插入排序
     *  算法描述：
     *      1.从第一个元素开始，认为该元素已经被排序
     *      2.取下一个元素，在已经排序的元素序列中从后向前扫描
     *      3.如果该元素（已排序）大于新元素，将该元素移到下一位置
     *      4.重复步骤3，直到找到已排序的元素小于或等于新元素的位置
     *      5.将新元素插入到该位置
     *      6.重复2~5
     * @param arr
     * @return
     */
    public static int[] insertionSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int temp;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
//            printArr(arr, i-1);
//            System.out.println("第" + i + "次排序");
        }
        return arr;
    }

    /**
     * 插入排序改进： in-place
     *  使用一个数组以外的空间临时保存数据，然后只需一层遍历数组
     * @param arr
     * @return
     */
    public static int[] insertionSortImprove(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int len = arr.length;
        int preIndex, current;
        for (int i = 0; i < len; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex +1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
//        printArr(arr, 1);

        return arr;
    }

```



### 5.3.4 算法分析





### 5.3.5 应用场景





## 5.4 希尔排序

### 5.4.1 算法描述

**参考引用自：** [图解排序算法(二)之希尔排序](https://www.cnblogs.com/chengxiao/p/6104371.html)

**希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。**

简单插入排序很循规蹈矩，不管数组分布是怎么样的，依然一步一步的对元素进行比较，移动，插入，比如[5,4,3,2,1,0]这种倒序序列，数组末端的0要回到首位置很是费劲，比较和移动元素均需n-1次。而希尔排序在数组中采用跳跃式分组的策略，通过某个增量将数组元素划分为若干组，然后分组进行插入排序，随后逐步缩小增量，继续按组进行插入排序操作，直至增量为1。希尔排序通过这种策略使得整个数组在初始阶段达到从宏观上看基本有序，小的基本在前，大的基本在后。然后缩小增量，到增量为1时，其实多数情况下只需微调即可，不会涉及过多的数据移动。

　　我们来看下希尔排序的基本步骤，在此我们选择增量gap=length/2，缩小增量继续以gap = gap/2的方式，这种增量选择我们可以用一个序列来表示，{n/2,(n/2)/2...1}，称为**增量序列**。希尔排序的增量序列的选择与证明是个数学难题，我们选择的这个增量序列是比较常用的，也是希尔建议的增量，称为希尔增量，但其实这个增量序列不是最优的。此处我们做示例使用希尔增量。

![img](https://images2015.cnblogs.com/blog/1024555/201611/1024555-20161128110416068-1421707828.png)

### 5.4.2 动画演示



![img](https://images2018.cnblogs.com/blog/849589/201803/849589-20180331170017421-364506073.gif)

### 5.4.3 代码实现

```java
public class ShellSort {

    public static void main(String[] args) {
        shellSort(randomArr(10,100));

    }

    /**
     * 希尔排序：交换法,两两一组，与5.4.2的分析有所不同，注意区分
     * @param arr
     * @return
     */
    public static int[] shellSort1(int[] arr) {

        /*int a = 0;*/
        
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            /*System.out.println("gap = " + gap);*/

            int j;
            for (int i = gap; i < arr.length; i++) {
                j = i;

                /*System.out.print("i = " + i);
                System.out.print("\t");
                System.out.print("j = " + j);
                System.out.print("\t");
                System.out.print("j-gap = " + (j-gap));*/

                while (j - gap >= 0 && arr[j] < arr[j - gap]) {

                    /*System.out.print("\t");
                    System.out.print("j = " + j);
                    System.out.print("\t");
                    System.out.print("j-gap = " + (j-gap));*/

                    swap(arr, j, j - gap);
                    j -= gap;
                }
                /*System.out.println();*/

            }
            /*printArr(arr, a++);*/
        }

        return arr;
    }
    
    
     /**
     * 希尔排序：移动法,两两一组，与5.4.2的分析有所不同，注意区分
     * @param arr
     */
    public static void shellSort2(int[] arr) {
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动法
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }
    
    /**
     * 交换数组元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        // arr[b] = arr[a]
        arr[b] = arr[a] - arr[b];
        // arr[a] = arr[b]
        arr[a] = arr[a] - arr[b];
    }
}

```



### 5.4.4 算法分析



### 5.4.5 应用场景



# 6.Netty







# 7、LeetCode刷题记录

