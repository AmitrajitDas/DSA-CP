class Pair {
    int height;
    String name;
    
    Pair(int height, String name) {
        this.height = height;        
        this.name = name;
    }
}

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        List<Pair> pairs = new ArrayList<>();
        List<String> res = new ArrayList<>();

        // Creating pairs of heights and names
        for(int i = 0; i < n; i++) {
            pairs.add(new Pair(heights[i], names[i]));
        }

        // Sorting pairs by height in descending order
        Collections.sort(pairs, (a, b) -> b.height - a.height);

        // Adding sorted names to the result list
        for(Pair pair : pairs) {
            res.add(pair.name);
        }

        // Converting result list to array and returning
        return res.toArray(new String[0]);
    }
};