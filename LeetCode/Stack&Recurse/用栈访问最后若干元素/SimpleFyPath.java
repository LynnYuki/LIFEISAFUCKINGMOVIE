/**
 * leetcode 71 简化路径
 */
class Solution {
    public String simplifyPath(String path) {
        //数组分割
        String[] arr = path.split("/");
        StringBuilder stb = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        for(int i = 0; i < arr.length; i++) {
            //跳过当期目录的标识和空字符串
            if (arr[i].length() == 0 || arr[i].equals(".")) {
                continue;
            }
            //栈不为空
            if (!stack.isEmpty()) {
                //遇到..表示跳到上一级目录，则stack出栈
                if (arr[i].equals("..")) {
                    stack.pop();
                } else {
                    stack.push(arr[i]);
                }
            } else {
                if (!arr[i].equals("..")) {
                    stack.push(arr[i]);
                 }
            }
        }
        //栈为空则返回根目录
        if (stack.isEmpty()) {
            return stb.append("/").toString();
        }
        //添加 /
        while (!stack.isEmpty()) {
            stb.insert(0,stack.pop());
            stb.insert(0,"/");
        }
        return stb.toString();
    }
}