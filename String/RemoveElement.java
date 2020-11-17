/**
 * LeetCode #27 移除元素 快慢双指针
 */
public class RemoveElement{
    public int remove(int[] nums,int val){
        int slow = 0;
        for(int fast = 0;fast<nums.length;fast++){
            if(nums[fast]!=val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
 }