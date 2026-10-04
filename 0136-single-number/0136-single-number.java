class Solution {
    public int singleNumber(int[] nums) {
        int single = 0;
        
        for (int num : nums) {
            single ^= num; // XOR the current number with the running result
        }
        
        return single;
    }
}
