import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        
        // The first element is always 1
        row.add(1);
        
        // Use long to prevent integer overflow during multiplication
        long prev = 1; 
        
        for (int k = 1; k <= rowIndex; k++) {
            // Calculate current element using the previous element
            long next_val = prev * (rowIndex - k + 1) / k;
            
            // Cast back to int since the final value is guaranteed to fit in 32-bit int
            row.add((int) next_val); 
            
            // Update prev for the next iteration
            prev = next_val;
        }
        
        return row;
    }
}