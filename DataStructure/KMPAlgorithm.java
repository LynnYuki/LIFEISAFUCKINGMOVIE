import java.util.Arrays;

/**
 * KMP 算法
 */
public class KMPAlgorithm {

    public static void main(String[] args) {
        String txt = "BBC ABCDABD AAC";
        String pat = "ABCDABD";
        int[] next = getKMPNext(pat);
        int index = searchKMP(txt,pat,next);
        System.out.println("next=" + Arrays.toString(next));
        System.out.println("index=" + index);
    }

    /**
     * 获取模式串的next数组
     *
     * @param pat
     * @return int[]
     */
    public static int[] getKMPNext(String pat) {
        int[] next = new int[pat.length()];
        //子串长度为1的前缀表值为0
        next[0] = 0;
        for (int i = 1, j = 0; i < pat.length(); i++) {
            //当不满足该条件时 需要从不满足的值的前一个值获取新的j，直到满足pat.charAt(i) == pat.charAt(j)退出
            while (j > 0 && pat.charAt(i) != pat.charAt(j)) {
                j = next[j - 1];
            }
            //满足该条件时
            if (pat.charAt(i) == pat.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    /**
     * KMP搜索方法
     *
     * @param txt  文本串
     * @param pat  模式串
     * @param next 模式串的next数组
     * @return 匹配到的起始下标
     */
    public static int searchKMP(String txt, String pat, int[] next) {
        for (int i = 0, j = 0; i < txt.length(); i++) {
            //核心
            while (j > 0 && txt.charAt(i) != pat.charAt(j)) {
                j = next[j - 1];
            }
            if (txt.charAt(i) == pat.charAt(j)) {
                j++;
            }
            if (j == pat.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }
}