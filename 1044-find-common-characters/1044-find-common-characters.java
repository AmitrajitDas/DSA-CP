class Solution {
    private int[] count(String str) {
        int[] freq = new int[26];
        for(char c : str.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }

    private int[] intersection(int[] a, int[] b) {
        int[] arr = new int[26];
        for(int i = 0; i < 26; i++) {
            arr[i] = Math.min(a[i], b[i]);
        }
        return arr;
    }

    public List<String> commonChars(String[] words) {
        int[] pre = count(words[0]);

        for(int i = 1; i < words.length; i++) {
            pre = intersection(pre, count(words[i]));
        }

        List<String> res = new ArrayList<>();
        for(int i = 0; i < 26; i++) {
            if(pre[i] > 0) {
                char ch = (char) ('a' + i);
                String str = String.valueOf(ch);
                while(pre[i] > 0) {
                    res.add(str);
                    pre[i]--;
                }
            }
        }

        return res;
    }
}