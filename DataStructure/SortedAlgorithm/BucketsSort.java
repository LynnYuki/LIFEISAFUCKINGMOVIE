/**
 * 桶排序O(n+k)
 */
 public void bucktesSort(int[] arr){
   int max = Integer.MIN_VALUE;
   int min = Integer.MAX_VALUE;
   for(int i = 0; i < arr.length; i++) {
     max = Math.max(max,arr[i]);
     min = Math.min(min,arr[i]);
   }
   //桶的数量
   int bcuketNum = (max - min) / arr.length + 1;
   ArrayList<ArrayList<Integer>> bucketsArr = new ArrayList<>(bcuketNum);
   for(int i = 0; i < bcuketNum; i++) {
     bucketsArr.add(new ArrayList<Integer>());
   }
   //将每个元素放入桶中
   for(int i = 0; i < arr.length; i++) {
     int num = (arr[i] - min) / arr.length;
     bucketsArr.get(num).add(arr[i]);
   }
  //构造接收排序的list
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    for(int i = 0; i < bcuketNum; i++) {
        res.add(new ArrayList<>());
    }
   //对每个桶排序
   for(int i = 0; i < bucketsArr.size(); i++) {
     int[] temp = bucketsArr.get(i).stream().mapToInt(Integer::valueOf).toArray();
      insertSort(temp);
        for(int j = 0; j < temp.length; j++) {
            res.get(i).add(temp[j]);
        }
   }
    System.out.println(res.toString());
 }

 public void quickSort(int[] arr,int start,int end){
   if(start < end) {
     int standard = arr[start];
     int low = start;
     int high = end;
     while (low < high) {
       while (low < high && standard <= arr[high]){
         high--;
       }
       arr[low] = arr[high];
       while (low < high && standard >= arr[low]) {
         low++;
       }
       arr[high] = arr[low];
     }
     arr[low] = standard;
     quickSort(arr,start,low);
     quickSort(arr,low + 1,end);
   }
 }

 public void insertSort(int[] arr) {
   for (int i = 1; i < arr.length;i++) {
     int insertVal = arr[i];
     int index = i - 1;
     while (index >= 0 && insertVal < arr[index]) {
       arr[insertIndex + 1] = arr[insertIndex];
       index--;
     }
    arr[index + 1] = insertVal;
   }
 }