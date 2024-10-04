class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        Arrays.sort(skill);
        int i = 0, j = n - 1;
        int totalSkill = 0;
        long sum = 0;

        while(i < j) {
            System.out.println("totalSkill: " + totalSkill);
            if(totalSkill != 0 && totalSkill != skill[i] + skill[j]) return -1;
            totalSkill = skill[i] + skill[j];
            int chemistry = (skill[i] * skill[j]);
            sum += chemistry;
            i++;
            j--;    
        }

        return sum;
    }
}