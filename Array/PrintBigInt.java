/**
 * 剑指Offer 17 打印从1到最大的n位数
 */
class Solution {
    public int[] printNumbers(int n) {
        if(n<1){
            return new int [0];
        }
        int [] numbers = new int[(int)Math.pow(10,n)-1];
        numbers[0]=1;
        for(int i=2;i<(int)Math.pow(10,n);i++){
            numbers[i-1] = i;
        }
        return numbers;
    }
}