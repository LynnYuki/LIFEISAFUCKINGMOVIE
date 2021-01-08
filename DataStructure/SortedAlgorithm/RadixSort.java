/**
 * 基数排序O(n x k)
 */

//二位数组实现
 public void radixSort(int[] arr){
     //找到数组中最大的数
     int max = arr[0];
     for (int i = 0; i < arr.length;i++){
         if(max < arr[i]){
             max = arr[i];
         }
     }
     //计算最大数的位数
     int maxLength = (max + "").length();
     //存储数据的桶
     int [][] buckets = new int[10][arr.length];
     //存放每个桶里面存的数的多少
     int[] bucketsEleCounts = new int[10];
     //循环比较 将数字放入桶中
     for (int i = 0 ,n = 1; i < maxLength;i++,n *= 10) {
         //计算每一个数字的每一位上的值
         for(int j = 0; j < arr.length;j++ ) {
            int tempNum = arr[j] / n % 10;
            //根据计算的值将该数字放入桶中相应的位置
            buckets[tempNum][bucketsEleCounts[tempNum]] = arr[j];
            //桶中放入数的位置索引+1
            bucketsEleCounts[tempNum]++;   
     }
     //记录取出桶中元素应存放到原数组中的位置
     int index = 0;
     //取出桶中数字放入原来的数组中
     for (int k = 0; k < bucketsEleCounts.length;k++){
         //记录桶中数字的数量不为0
         if(bucketsEleCounts[k] != 0){
             //遍历取出每个桶中的数字
             for(int l = 0; l < bucketsEleCounts[k];l++) {
                arr[index++] = buckets[k][l];
             }
             //取出后将该序位桶中存放的元素个数置0便于下一次存放新的数字
             bucketsEleCounts[k] = 0;
         }
      }
    }
 }
 //队列实现
  public void radixSort(int[] arr){
     //找到数组中最大的数
     int max = arr[0];
     for (int i = 0; i < arr.length;i++){
         if(max < arr[i]){
             max = arr[i];
         }
     }
     //计算最大数的位数
     int maxLength = (max + "").length();
     //存储数据的桶 一个包含一组队列的动态数组
     List<Deque<Integer>> bucketsArr = new ArrayList<>();
     //初始化
     for (int i = 0; i < 10;i++) {
         bucketsArr.add(new LinkedList<Integer>());
     }
     //循环比较 将数字放入桶中
     for (int i = 0 ,n = 1; i < maxLength;i++,n *= 10) {
         //计算每一个数字的每一位上的值
         for(int j = 0; j < arr.length;j++ ) {
            int tempNum = arr[j] / n % 10;
            //根据计算的值将该数字放入桶中tempNum索引的队列中
            bucketsArr.get(tempNum).offer(arr[j]);

     }
     //记录取出桶中元素应存放到原数组中的位置
     int index = 0;
     //取出桶中数字放入原来的数组中
     for (int k = 0; k < bucketsArr.size();k++){
         //取出每一个队列
         LinkedList<Integer> temp = (LinkedList<Integer>)bucketsArr.get(k);
         //判断队列是否为空
         if(temp.size() != 0){
             //出队每个队列的数字
             while(!temp.isEmpty()){
                 arr[index++] = temp.poll();
             }
         }
      }
    }
 }