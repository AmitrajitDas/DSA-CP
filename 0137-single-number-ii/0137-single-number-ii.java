class Solution {
  public int singleNumber(int[] nums) {
    int ones = 0, twos = 0;

    for (final int num : nums) {
      ones ^= (num & ~twos);
      twos ^= (num & ~ones);
    }
    return ones;
  }
}