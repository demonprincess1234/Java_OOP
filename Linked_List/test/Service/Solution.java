package Service;

import java.util.NoSuchElementException;

public class Solution {
    public static int removeDuplicates(int[] nums) {
        try{
            if(nums == null || nums.length ==0){ throw new NoSuchElementException("Mang rong"); }

            int i =0;

            for(int j=1;j< nums.length;j++) {
                if (nums[j] != nums[i]) {
                    i++;
                    nums[i] =nums[j];
                }
            }
            return i+1;
        } catch (Exception e) { throw new NoSuchElementException("Loi nhap lieu"); }

    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k = removeDuplicates(nums);

        System.out.println("Số lượng phần tử duy nhất k = " + k);
        System.out.print("Mảng sau khi lọc: [");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + (i < k - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}
