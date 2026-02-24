class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        if (n <= 10) return new ArrayList<>();

        Map<Character, Integer> dnaMap = new HashMap<>();
        dnaMap.put('A', 0);
        dnaMap.put('C', 1);
        dnaMap.put('G', 2);
        dnaMap.put('T', 3);

        int winLen = 10;
        int base = 4;
        long highPow = (long)Math.pow(base, winLen - 1);

        Set<Long> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        long hash = 0;
        for(int i = 0; i < winLen; i++) {
            hash = hash * base + dnaMap.get(s.charAt(i));
        }
        seen.add(hash);

        for(int i = 1; i <= n - winLen; i++) {
            int leftChar = dnaMap.get(s.charAt(i - 1));
            int rightChar = dnaMap.get(s.charAt(i + winLen - 1));

            hash = (hash - leftChar * highPow) * base + rightChar;

            if(seen.contains(hash)) {
                repeated.add(s.substring(i, i + winLen));
            } else {
                seen.add(hash);
            }
        }

        return new ArrayList<>(repeated);
        
    }
}