class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        
        // Sort the skill array
        Arrays.sort(skill);
        
        // Calculate the total skill of the first team
        int targetSkill = skill[0] + skill[n - 1];
        long sum = 0;
        
        // Use two-pointer technique to pair players and check for consistency
        int i = 0, j = n - 1;
        while (i < j) {
            // Check if the current pair's skill matches the target skill
            if (skill[i] + skill[j] != targetSkill) {
                return -1; // Teams can't be formed with equal total skill
            }
            
            // Calculate the chemistry (product of skills) and add to the sum
            sum += (long) skill[i] * skill[j];
            
            // Move pointers towards the center
            i++;
            j--;
        }
        
        // Return the sum of chemistry of all valid teams
        return sum;
    }
}