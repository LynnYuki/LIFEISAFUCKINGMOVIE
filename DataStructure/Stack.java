/**
 * Stack的静态数组实现
 */
public class Stack {
    private int[] arr ;

    public Stack(){
        arr = new int[0];
    }

    /**
     * 入栈  
     */
    public void push(int val) {
        int [] temp = new int [arr.length+1];
        for(int i=0;i<arr.length;i++) {
            temp[i] = arr[i];
        }
        temp[arr.length] =val;
        arr = temp;
    }

    /**
     * 出栈 
     */
    public void pop() {
        if(arr.length == 0) {
            throw new RuntimeException("stack is empty");
        }
        int [] temp = new int[arr.length-1];
        for(int i=0;i<arr.length-1;i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    /**
     * 返回栈顶元素
     */
     public int peek() {
        if(arr.length == 0) {
            throw new RuntimeException("stack is empty");
        } 
         return arr[arr.length-1];
     }

     /** 
      * 判空
      */
    public boolean isEmpty() {
        return arr.length == 0 ? true : false;
    }
}
