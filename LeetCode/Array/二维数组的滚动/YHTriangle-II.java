/**
 * leetcode 119 杨辉三角II
 */
 class Solution {
    public List<Integer> getRow(int N) {
        List<Integer> res = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            //先全部变为[1,1,1,...n+1] 总共n+1个1的数组 再替换其中需要改变的元素
            res.add(1);
            for (int j = i - 1; j > 0; j--) {
                //set方法为替换指定位置的元素
                res.set(j, res.get(j) + res.get(j - 1));
            }
        }
        return res;
    }
    //递推公式 索引从0开始，索引为n的行有n+1个值 且每一行的后一个值为res.get(index -1) *(n+1 - index)/index
     public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <rowIndex + 1;i++) {
          if (i == 0) {
              res.add(1);
          } else {
              long ele = (long) res.get(i-1) * (long)(rowIndex + 1 - i) / i;
              res.add((int)ele);
          }
    }
     return res;
    }
}
