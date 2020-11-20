/**
 * 二分查找    
 */

 public int binarySearch(int [] nums,int target) {
     int left = 0;
     int right = nums.length-1;//attention
     while (left <= right) { //attention
         int mid = left + ( right - left ) / 2;
         if (nums[mid] == target){
             return mid;
         } else if(nums[mid] < target) {
             left = mid + 1;//attention
         } else if(nums[mid] > target) {
             right = mid - 1;//attention
         }
     }
     return -1;

 }
 
 /**
  * 左侧边界二分查找
  */

 public int leftBinarySearch(int[] nums , int target) {
     int left = 0;
     int right = nums.length - 1;
     // 搜索区间[left,right] while 跳出条件 left = right + 1;
     while (left <= right) {
         int mid = left + ( right - left ) / 2;
         if (nums[mid] < target) {
             //搜索区间 [mid+1,right]
             left = mid + 1;
         } else if (nums[mid] > target) {
             //搜索区间 [left,mid-1]
             right = mid - 1;
         } else if (nums[mid] == target) {
             // 收缩右侧边界继续查找
             right = mid - 1;
         }
     }
     //判断索引超出边界情况
     if(left >= nums.length || nums[left] != target){
         return -1;
     }
     return left;
 }

/**
 * 右侧边界二分查找
 */

 public int rightBinarySearch(int[] nums ,int target) {
     int left = 0;
     int right = nums.length - 1;
     while (left <= right){
         int mid = left + (right - left) / 2;
         if (nums[mid] < target) {
             left = mid + 1;
         } else if (nums[mid] > target) {
             right = mid - 1;
         } else if (nums[mid] == target) {
             left = mid + 1;
         }
     }

     if (right < 0 || nums[right] != target) {
         return -1;
     }
     return right;

 }