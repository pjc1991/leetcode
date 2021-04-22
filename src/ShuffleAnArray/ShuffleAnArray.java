package ShuffleAnArray;

import java.util.HashMap;

public class ShuffleAnArray {
    public static void main(String[] args) {

        // make some test cases
        int max = 200;
        int len = (int) (Math.random() * max);
        
        // specific case
        // len = 10;
        int[] nums = new int[len];

        
        // should be unique -- use hashmap to make it unique numbers. 
        HashMap<Integer, Integer> uniqueMap = new HashMap<Integer, Integer>();
        for(int i=0; i<len;i++){
            int randomNumber = (int)(Math.random() * 2 * 1000000 - 1000000  + 1);
            if(uniqueMap.get(randomNumber) == null){
                uniqueMap.put(randomNumber, 1);
                nums[i] = randomNumber;
            } else {
                i--;
            }
        }

        Solution solution = new Solution(nums);
        printSolution(solution.reset());
        printSolution(solution.shuffle());
        printSolution(solution.reset());
        printSolution(solution.shuffle());
        
    }
    public static void printSolution(int[] nums){
        StringBuffer sb = new StringBuffer();
        sb.append("nums = [");
        for(int i : nums){
            sb.append(i + ", ");
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append("]");
        System.out.println(sb.toString());
    }
    
}

class Solution {

    int[] backup;
    int[] nums;
    int memory1;
    int memory2;

    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        if (backup != null){
            for(int i = 0;i < backup.length; i++){
                this.nums[i] = backup[i];
            }
        }
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (backup == null){
            backup = this.nums.clone();
        }
        for(int i=0;i<this.nums.length;i++){
            int random = (int) (Math.random() * this.nums.length);
            memory1 = this.nums[i];
            memory2 = this.nums[random];
            this.nums[i] = memory2;
            this.nums[random] = memory1;
        }
        return this.nums;    
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */