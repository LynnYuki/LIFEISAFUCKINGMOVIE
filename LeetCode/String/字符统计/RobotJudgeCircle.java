/**
 * leetcode 657 机器人能否回到原点
 */
class Solution {
    public boolean judgeCircle(String moves) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('U',0);
        map.put('D',0);
        map.put('L',0);
        map.put('R',0);
        int xSum = 0;
        int ySum = 0;
        for(char ch : moves.toCharArray()) {
            if('U' == ch || 'L' == ch) {
                map.put(ch,map.getOrDefault(ch,0) + 1);
            } else if ('D' == ch || 'R' == ch) {
                map.put(ch,map.getOrDefault(ch,0) - 1);
            }
            
        }
        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            if (entry.getKey() == 'U' || entry.getKey() == 'D') {
                ySum += entry.getValue();
            } 
            if (entry.getKey() == 'L' || entry.getKey() == 'R') {
                xSum += entry.getValue();
            }
        }
        return xSum == 0 && ySum == 0;
    }

    //直接遍历
    public boolean judgeCircle(String moves) {
        int xSum = 0;
        int ySum = 0;
        for (char ch : moves.toCharArray()) {
            switch (ch) {
                case'U':
                    xSum += 1;
                    break;
                case'D':
                    xSum -= 1;
                    break;
                case'L':
                    ySum += 1;
                    break;
                case'R':
                    ySum -= 1;
                    break;
            }
        }
        return xSum == 0 && ySum == 0;
    }
}