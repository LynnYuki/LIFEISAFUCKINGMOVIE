/**
 * 队列的数组实现
 */

 public class ArrayQueue {
     private int maxSize;//队列最大容量
     private int front;//头指针
     private int rear;//尾指针
     private int[] arr;//模拟队列数组

     public ArrayQueue(int arrMaxSize) {
         maxSize = arrMaxSize;
         arr = new int[maxSize];
         front = -1;//指向队列头部元素前一个节点
         rear = -1;//指向队尾元素  
    }

    //队列是否满
    public boolean isFull () {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty () {
        return rear == front;
    }

    //入队
    public void addQueue (int n) {
        //判断是否队满
        if (isFull()) {
            System.out.println("队列满，不能加入数据！");
            return;
        }
        rear++;//尾指针后移
        arr[rear] = n;
    }

    //出队
    public int outQueue () {
        if (isEmpty())) {
            throw new RuntimeException("队列空，不能出队！");
        }
        front++;//头指针后移
        return arr[front];
    }

    //展示所有队列数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空！");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[%d]=%d\n",i,arr[i]);
        }
    }
    
    //返回队列头数据
    public ind peekQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        return arr[front + 1];
    }

 }