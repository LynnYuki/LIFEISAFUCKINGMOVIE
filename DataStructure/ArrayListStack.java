/**
 * Stack的动态数组实现
 */
public class ArrayListStack {
    private List<Integer> list;

    public ArrayListStack(){
        list = new ArrayList<>();
    }

    /**
     * 入栈  
     */
    
    public void push(int val) {
        list.add(val);
    }

    /**
     * 出栈 
     */
    public boolean pop() {
        if(isEmpty()){
            return false;
        }
        list.remove(list.size()-1);
        return true;
    }

    /**
     * 返回栈顶元素
     */
    public int peek() {
        return list.get(list.size()-1);
    }
    
    /** 
     * 判空
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

}