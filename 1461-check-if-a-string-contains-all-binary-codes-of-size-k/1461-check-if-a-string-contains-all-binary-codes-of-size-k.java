class Solution {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < k) return false;
        
        Set<Integer> seen = new HashSet<>();
        int target = 1 << k;
        int windowVal = 0;
        int mask = target - 1;

        for(int i = 0; i < k; i++) {
            windowVal = (windowVal << 1) | (s.charAt(i) - '0');
        }

        seen.add(windowVal);

        for(int i = k; i < s.length(); i++) {
            windowVal = ((windowVal << 1) | s.charAt(i) - '0') & mask;
            seen.add(windowVal);
            if(seen.size() == target) return true;
        }

        return false;
    }
}