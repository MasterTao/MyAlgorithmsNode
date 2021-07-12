package com.monkey.xor;

/**
 * 怎么把一个int类型的数，提取出最右侧的1
 *
 * @author tao
 * @date 2021/7/12 4:59 下午
 */
public class FindRightOne {


    public static int findRightOne(int a) {

        // a & (~a + 1)
        return a & (-a);
    }

    public static void main(String[] args) {
        System.out.println(findRightOne(8));
    }
}
