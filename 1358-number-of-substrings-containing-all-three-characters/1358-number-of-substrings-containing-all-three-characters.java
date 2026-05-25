class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length(), i = 0, res = 0;
        Map<Character, Integer> mp = new HashMap<>();
        for(int j = 0; j < n; j++) {
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) + 1);
            while(mp.size() == 3) {
                res += n - j;
                mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                if(mp.get(s.charAt(i)) == 0) {
                    mp.remove(s.charAt(i));
                }
                i++;
            }
        }

        return res;
    }
}