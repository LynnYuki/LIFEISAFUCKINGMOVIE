/**
 * 循环队列的实现
 * 1、front 指向队列的头部元素
 * 2、rear 指向队列最后一个元素的后一个位置
 * 3、当队列满时的条件为 (rear + 1) % maxSize == front
 * 4、队列为空 rear == front
 * 5、队列的有效个数 (rear + maxSize -front) % maxSize
 */

public class CircleArrayQueue {
     private int maxSize;//队列最大容量
     private int front;//头指针
     private int rear;//尾指针
     private int[] arr;//模拟队列数组

     public CircleArrayQueue (int arrMaxSize) {
         maxSize = arrMaxSize;
         arr = new int[arrMaxSize];
         front = 0;
         rear = 0;
     }

    //判断队列是否满
     public boolean isFull () {
         return (rear+ 1) % maxSize == front;
     }

     //判断队列是否为空
    public boolean isEmpty () {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue (int n) {
        if (isFull()) {
            System.out.println("队列满,不能加入数据。");
            return;
        }
        arr[rear] = n;
        //rear指针后移 必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    //取出队列数据
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空,没有数据可取。");
        }
        //临时变量保存front指向的值 front后移取模
        int temp = arr[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    //列出队列所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据。");
            return;
        }

        for (int i = front; i < front + size() ; i++) {
            System.out.printf("arr[%d]=%d\n",i % maxSize,arr[i % maxSize]);
        }

    }

    //求出当前队列包含的元素个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //获取队首元素
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空,没有数据");
        }
        return arr[front];
    }
}