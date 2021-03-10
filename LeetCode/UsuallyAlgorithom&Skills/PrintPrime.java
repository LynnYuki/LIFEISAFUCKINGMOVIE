/**
 * 打印指定范围内的素数及其和
 */
 
 //暴力
public  int printPrime (int bounds) {
    int sum = 0;
    int i,j;
    for (i = 1; i <= bounds; i++) {
        //从2开始逐一累加并判断能否整除
        for (j = 2; j < i; j++) {
            if (i % j == 0) {
                //能被整除则中断内循环
                break;
            }
        }
        if (j == i) {
            System.out.println(i);
            sum += i;
        }
    }
    return sum;
}

//优化

public int printPrime2 (int bounds) {
    int sum = 2;
    int i,j;
    //考虑特殊的素数2
    System.out.println(2);
    //从3开始判断，大于2的偶数都不是素数，只需要判断奇数
    for (i = 3; i <= bounds; i += 2) {
        //内循环只需要判断小于sqrt（含）能否被整除的情况
        int sqrt = (int)Math.sqrt(i);
        for (j = 2; j <= sqrt; j++) {
            if (i % j == 0) {
                break;
            }
        }
        if (j > sqrt) {
            System.out.println(i);
            sum += i;
        }
    }
    return sum;
}