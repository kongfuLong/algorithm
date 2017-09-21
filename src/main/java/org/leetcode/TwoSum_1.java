package org.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ruancl@xkeshi.com on 2017/9/15.
 */
public class TwoSum_1 {
    /**
     * 1. Two Sum
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int size = nums.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new NullPointerException("没有合适答案");
    }


    /**
     * 300. Longest Increasing Subsequence   动态规划问题
     * Given an unsorted array of integers, find the length of longest increasing subsequence.
     * For example,
     * Given [10, 9, 2, 5, 3, 7, 101, 18],
     * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
     * <p>
     * Your algorithm should run in O(n2) complexity.
     * <p>
     * Follow up: Could you improve it to O(n log n) time complexity?
     *
     * @param nums
     */
     public int dynamic(int[] nums) {
        int size = nums.length;
        if (size == 1) {
            return 1;
        }
        int[] tmp = new int[size];
        int length = 0;
        for (int i = 1; i <= size; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i]) {
                    tmp[i] = Math.max(tmp[i], tmp[j]);
                }
            }
            tmp[i] += 1;
            length = Math.max(length, tmp[i]);

        }
        return length;
    }



    /**
     * 2. Add Two Numbers
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rs = null;
        int nextInt = 0;
        while (l1 != null || l2 != null) {
            int v1 = 0;
            int v2 = 0;
            if (l1 != null) {
                v1 += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                v2 += l2.val;
                l2 = l2.next;
            }
            int num = v1 + v2 + nextInt;
            nextInt = 0;
            if (num >= 10) {
                nextInt = 1;
                num = num - 10;
            }
            ListNode lnn = new ListNode(num);
            lnn.next = rs;
            rs = lnn;
        }
        if (nextInt > 0) {
            ListNode lnn = new ListNode(nextInt);
            lnn.next = rs;
            rs = lnn;
        }

        ListNode p = rs;
        ListNode now = null;
        ListNode front = null;
        while (p != null) {
            now = p.next;
            p.next = front;
            front = p;
            p = now;
        }
        rs = front;

        return rs;
    }


    /**
     * 643. Maximum Average Subarray I
     * <p>
     * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
     * <p>
     * Example 1:
     * Input: [1,12,-5,-6,50,3], k = 4
     * Output: 12.75
     * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
     * Note:
     * 1 <= k <= n <= 30,000.
     * Elements of the given array will be in the range [-10,000, 10,000].
     *
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        int size = nums.length;
        for(int i=1;i<size;i++){
            nums[i] = nums[i-1] + nums[i];
        }
        int sum = nums[k-1];
        for(int j=k;j<size;j++){
            sum = Math.max(sum,nums[j]-nums[j-k]);
        }

        return sum*1.0d/k;
    }


    
    
    public static void main(String[] args) {

        String[] news =
                {"10.175.206.139",
                "10.27.213.56",
                "10.161.168.25",
                "10.168.62.87",
                "10.26.201.102",
                "10.27.213.61",
                "10.31.128.158",
                "10.31.132.180"};


        String[] old = {"10.117.22.68",
                "10.47.106.186",
                "10.28.41.7",
                "10.27.234.196",
                "10.252.123.12",
                "10.161.235.103",
                "10.117.20.99",
                "10.26.238.71",
                "10.168.136.70",
                "10.168.100.151",
                "10.117.22.68",
                "10.26.38.95",
                "10.27.110.73",
                "10.27.213.56",
                "10.27.213.61",
                "10.168.62.87",
                "10.175.206.139",
                "10.168.112.198",
                "10.168.93.173",
                "10.161.168.25",
                "10.27.211.87",
                "10.31.132.180",
                "10.29.192.17",
                "10.29.54.146",
                "10.30.207.13",
                "10.30.196.246",
                "10.27.61.4",
                "10.27.63.173",
                "10.26.202.252",
                "10.168.7.76",
                "10.27.88.65",
                "10.31.129.248",
                "10.169.154.99",
                "10.26.201.102",
                "10.26.255.175"};
        String[] news2 = {"10.168.100.151",
                "10.168.222.71",
                "10.175.206.139",
                "10.168.62.87",
                "10.31.131.153",
                "10.168.222.71",
                "10.31.131.58",
                "10.168.62.87",
                "10.168.100.151",
                "10.30.201.232",
                "10.31.131.153",
                "10.26.201.102",
                "10.26.255.175",
                "10.168.222.71",
                        "10.31.131.45",
                        "10.168.222.71",
                        "10.30.202.2",
                        "10.168.222.71",
                        "10.24.238.14",
                        "10.168.62.87",
                        "10.31.131.45",
                        "10.30.202.2",
                        "10.27.213.56",
                        "10.30.201.41",
                        "10.31.131.106",
                        "10.29.112.87",
                        "10.29.118.72",
                        "10.161.168.25",
                        "10.31.132.180",
                        "10.168.222.71",
                        "10.168.222.71",
                        "10.30.201.232",
                        "10.31.131.176",
                        "10.168.222.71",
                        "10.175.206.139",
                        "10.30.196.160",
                        "10.31.131.45",
                        "10.29.117.230",
                        "10.27.213.61",
                        "10.27.63.134",
                        "10.31.131.155",
                        "10.168.100.151",
                        "10.168.222.71",
                        "10.26.254.39",
                        "10.168.222.71",
                        "10.31.128.158",
                        "10.30.201.232",
                        "10.168.222.71",
                        "10.31.131.106",
                        "10.26.196.107",
                        "10.31.131.176",
                        "10.29.195.222",
                        "10.31.131.143",
                        "10.168.222.71",
                        "10.30.201.41",
                        "10.26.254.39",
                        "10.168.222.71",
                        "10.168.62.87",
                        "10.24.238.14",
                        "10.168.222.71",
                        "10.29.117.230",
                        "10.168.222.71",
                        "10.26.202.252",
                        "10.29.118.72",
                        "10.29.195.222"};
        HashSet olds = new HashSet(Arrays.asList(old));
        olds.forEach(System.out::println);
        System.out.println("老配置去重后有："+olds.size()+"个ip");
        HashSet newsSet = new HashSet(Arrays.asList(news));
        newsSet.forEach(System.out::println);
        System.out.println("zk配置去重后有："+newsSet.size()+"个ip");
        HashSet set = new HashSet();
        for(String n : news){
            for(String o:old){
                if(n.equals(o)){
                    set.add(n);
                }
            }
        }
        System.out.println("两者重合的有："+set.size()+" 个ip");
        set.forEach(System.out::println);
        //zk 有老的没有的
        System.out.println("zk有 配置中心没有的：");
        newsSet.forEach(o->{
            if(olds.add(o) && !o.equals("10.27.89.71") && !o.equals("10.27.87.97") && !o.equals("10.26.254.10") && !o.equals("10.160.58.85") && !o.equals("10.132.86.64") && !o.equals("10.168.222.71")){
                System.out.println(o);//"10.31.128.158"
            }
        });
    }
}

