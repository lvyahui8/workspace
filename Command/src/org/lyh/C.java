package org.lyh;

/*n个数选择k个出来
 * 123456789,选择4个
 * 首先肯定是1234
 * 其次1235,1236...
 * 最后是6789,跳出循环
 *
 * 由本组合推出下一个组合,递推思想:
 * 把本组合与最后一组合   倒回来个相比较
 * :1234---6789,4<9,4+1=5-->1235,1236
 * 后面的依次加一
 * 3589-->36,6+1,6+1+1
 *
 * 最后看是否到了最后一个组合,跳出循环
 *
 *
 * */
public class C {

    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        com(n, k);
    }

    // 组合函数
    static void com(int n, int k) {// 1-n里面取k个组合
        if (n < k || n <= 0 || k <= 0) {
            System.out.println("n,k数据输入不合理");
            return;
        }
        int[] a = new int[k + 1];
        int[] fg = new int[k + 1];// 标记对照
        int count = 1;

        for (int i = 1; i <= k; i++) {
            a[i] = i;
            fg[i] = i - k + n;// 12345,3,fg就是(345)
        }
        while (true) {
            System.out.print("第" + (count++) + ":\t");
            for (int i = 1; i <= k; i++)
                System.out.print(a[i] + "\t");
            System.out.println();

            if (a[1] == n - k + 1)
                break;// 跳出条件

            for (int i = k; i >= 1; i--) {
                if (a[i] < fg[i]) {// 那个数小于标记,加一
                    a[i]++;// 123456789,3589->3678(5->6,6+1,6+1+1)
                    for (int j = i + 1; j <= k; j++)
                        a[j] = a[j - 1] + 1;// 后面的数,依次加一升序
                    break;
                }// if
            }// for i

        }// while

    }

}
