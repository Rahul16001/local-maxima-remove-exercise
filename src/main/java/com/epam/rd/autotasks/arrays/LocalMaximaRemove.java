package com.epam.rd.autotasks.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, -5};

        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] arr){

        //put your code here
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        boolean flag;
        for(int i=0; i<arr.length;i++)
        {
            int left = i - 1;
            int right = i + 1;

            flag = true;
            if(left >= 0)
            {
                if(arr[i] <= arr[left]) flag = false;
            }
            if(right < arr.length)
            {
                if(arr[i] <= arr[right]) flag = false;
            }
            if(flag) set.add(i);// if flag is true then it's local maxima add it's index to set
        }

        for(int i=0;i<arr.length;i++)
        {
            if(!set.contains(i))
            {
                list.add(arr[i]);
            }
        }

        int []ans = new int[list.size()];
        int counter = 0;
        for(int x : list)
        {
            ans[counter] = x;
            counter++;
        }

        return ans;
    }
}
