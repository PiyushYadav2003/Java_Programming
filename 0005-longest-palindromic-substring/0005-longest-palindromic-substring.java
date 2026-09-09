class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Check for odd-length palindromes (center is at a character)
            int len1 = expandAroundCenter(s, i, i);
            // Check for even-length palindromes (center is between characters)
            int len2 = expandAroundCenter(s, i, i + 1);
            
            // Take the maximum length found from both center types
            int len = Math.max(len1, len2);
            
            // If we found a longer palindrome, update the bounds
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the actual length of the valid palindrome
        // Note: the loop breaks when the condition fails, meaning left and right 
        // are one step beyond the valid palindrome boundaries. 
        // (right - left + 1) - 2 = right - left - 1
        return right - left - 1;
    }
}