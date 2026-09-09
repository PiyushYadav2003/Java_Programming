class Solution {
    public String convert(String s, int numRows) {
        // Base case: no zigzagging is possible
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        // Iterate through each row
        for (int i = 0; i < numRows; i++) {
            // Jump by the cycle length to find the characters for the current row
            for (int j = 0; j + i < n; j += cycleLen) {
                // Add the character going down
                result.append(s.charAt(j + i));
                
                // Add the character going diagonally up (only for inner rows)
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    result.append(s.charAt(j + cycleLen - i));
                }
            }
        }

        return result.toString();
    }
}