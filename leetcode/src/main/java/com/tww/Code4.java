package com.tww;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2020-07-09 10:29
 */
public class Code4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1=nums1.length;
        int length2=nums2.length;
        double mid=0,mid2=0;
        if(length1!=0){
            mid=((length1&1)==1)?nums1[(length1-1)/2]:(nums1[(length1-2)/2]+nums1[length1/2])/2.0;
        }
        if(length2!=0){
            mid2=((length2&1)==1)?nums2[(length2-1)/2]:(nums2[(length2-2)/2]+nums2[length2/2])/2.0;
        }
        return length1==0?mid2:length2==0?mid:(mid+mid2)/2.0;
    }

    public static void main(String[] args) {
        int[] nums1={1,3};
        int[] nums2={2};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
