package com.tww;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-26 17:21
 */
public class Code3 {
    public static void main(String[] args) {
        String s="abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        int length=s.length();
        int max=0;
        for(int i=0;i<length-1;i++){
            int m=length-i;
            for(int j=i+1;j<length;j++){
               if(s.charAt(i)==s.charAt(j)){
                   m=j-i;
                   break;
               }
            }
            if(m>max){
                max=m;
            }
        }
        return max;
    }
}
