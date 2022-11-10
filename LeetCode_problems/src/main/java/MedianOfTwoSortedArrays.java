/*https://leetcode.com/problems/median-of-two-sorted-arrays/
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

Constraints:
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-10^6 <= nums1[i], nums2[i] <= 10^6*/
package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //we gonna add both series' elements to an array and then sort it, then we'll take the median.
        List<Integer> list = new ArrayList();
        int maxSize = 0;
        if(nums1.length < nums2.length){
            maxSize = nums2.length;
        }else
        {
            maxSize = nums1.length;
        }
        for(int i = 0; i < maxSize; i++){
            if(maxSize == nums2.length){
                if(i <= nums1.length - 1){
                    list.add(nums1[i]);
                }
                list.add(nums2[i]);
            }else{
                if(i <= nums2.length - 1){
                    list.add(nums2[i]);
                }
                list.add(nums1[i]);
            }
        }
        Collections.sort(list); //we now sort the array - need to find a better sorting algo for this
        if (list.size() % 2 == 0){ //the list has even size
            return (list.get(list.size()/2 - 1) + list.get(list.size()/2)) / 2.0;
        }
        return list.get(list.size()/2); //the list has odd size
    }
}
