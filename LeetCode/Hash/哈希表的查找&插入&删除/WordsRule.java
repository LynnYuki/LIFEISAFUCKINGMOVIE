/**
 * leetcode 290 单词规律
 */
class Solution {
    // 1：我们只管 pattern 与 s 之间字符一一对应即可，看一个例子 pattern=abba，s=dog cat cat dog；第一次调用 map 的 put 方法时返回 null，如果是第 n 次调用的话即返回第 n-1 次的 value，很明显 valua 至关重要，因为 pattern 与 s 的长度是相等的，所以数组下标 i 是一一对应的，我们用 i 做 map 的 value 即可；
    // 2：所以我们直接遍历 pattern 就可以了，第一次 map.put(a)跟 map.put(dog)都是返回 null，第二次 map.put(a)跟 map.put(dog)都是返回 0，以此类推下去即可；
    // 3：这种解决问题的方法的重点在于利用两个字符串的下标是一一对应的，其次则是利用put的返回值；

    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }
        Map map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if(!Objects.equals(map.put(pattern.charAt(i), i), map.put(arr[i], i))) {
                return false;
            }
        }
        return true;
    }
}