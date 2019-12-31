package com.tww;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-27 14:39
 */
public class Code15 {

    public static void main(String[] args) {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});

    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<Integer> arrayList = new ArrayList<>(nums.length);
        IntStream.range(0,nums.length).forEach(i->{
            arrayList.add(nums[i]);
        });
        List<List<Integer>> list=generate(arrayList,3);
        System.out.println(list);
        list=list.stream().distinct().filter(item->item.stream().mapToInt(Integer::intValue).sum()==0).collect(Collectors.toList());
        System.out.println(list);
        return list;

    }

    public static <T> List<List<T>> generate(List<T> list, int r) {
        List<List<T>> result = new ArrayList<>();
        int[] indexs = new int[r];
        int n=list.size();
        for (int i = 0; i < r; i++) {
            indexs[i] = i;
        }

        while (indexs[r - 1] < n) {
            result.add(addData(list,indexs));
            int t = r - 1;
            while (t != 0 && indexs[t] == n - r + t) {
                t--;
            }
            indexs[t]++;
            for (int i = t + 1; i < r; i++) {
                indexs[i] = indexs[i - 1] + 1;
            }
        }
        return result;
    }

    private static <T> List<T> addData(List<T> list, int[] indexs) {
        List<T> result=new ArrayList<>(indexs.length);
        for(int i=0;i<indexs.length;i++){
            result.add(list.get(indexs[i]));
        }
        return result;
    }
}
