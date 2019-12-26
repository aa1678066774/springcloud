package com.tww;

import java.util.Arrays;

/**
 * @program: root
 * @description: 两数之和
 * @author: weiweiTang
 * @create: 2019-12-25 15:58
 */
public class Code1 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        int length=nums.length;
        for(int i=0;i<length;i++){
            int a=target-nums[i];
            for (int j=i+1;j<length;j++){
                if(nums[j]==a){
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
            }
        }
        return result;
    }

    public int[] twoSum1(int[] nums, int target) {
        //3、投机取巧用数组,只适合部分情况
        int number = 2048;
        int bits   = number - 1;
        int[] result = new int[number];

        for (int i = 0; i < nums.length; i++) {
            int c = (target - nums[i]) & bits;  //解决为负数的问题，卧槽
            if(result[c] != 0){
                return new int[]{result[c]-1,i};
            }
            result[nums[i] & bits] = i+1;
        }
        return null;
    }

}
