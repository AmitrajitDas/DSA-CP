public class Solution {
    public int minChanges(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n - 1; i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                count++;
            }
        }
        return count;
    }
}