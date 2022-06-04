class Solution {
    public int romanToInt(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        // init map
        
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    
        Integer sum = map.get(s.charAt(s.length() - 1)); // value of last character in the string
        
        for(int i = s.length() - 2; i >= 0; i--) {
            
            // if curr key is lesser than next key then substract value of curr key from the sum
            if(map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) sum -= map.get(s.charAt(i));
            else sum += map.get(s.charAt(i));
        }
        
        return sum;
    }
}