class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> mp = new HashMap<>();
        for (String ele : arr) {
            mp.put(ele, mp.getOrDefault(ele, 0) + 1);
        }
        for (String ele : arr) {
            if (mp.get(ele) == 1) {
                --k;
                if (k == 0) {
                    return ele;
                }
            }
        }
        return "";
    }
}