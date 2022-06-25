class Solution {
  public:
    int furthestBuilding(vector < int > & heights, int bricks, int ladders) {
      int n = heights.size();
      int totalBricksUsed = 0;
      priority_queue < int > bricksUsed;
      int reach = 0;
      for (; reach < n - 1; reach++) {
        // If current height is higher, we don't have to use
        // bricks or ladder.
        if (heights[reach] >= heights[reach + 1]) {
          continue;
        }

        // We have to use either brick or ladder.
        int diff = heights[reach + 1] - heights[reach];

        if (totalBricksUsed + diff <= bricks) {
          // Prefer bricks because we can later change from 
          // bricks to ladder as we will see below.
          totalBricksUsed += diff;
          bricksUsed.push(diff);
        } else if (ladders > 0) {
          // If even bricks are insufficient, check ladders.
          if (!bricksUsed.empty() && bricksUsed.top() > diff) {
            totalBricksUsed = totalBricksUsed - bricksUsed.top() + diff;
            bricksUsed.pop();
            bricksUsed.push(diff);
          }
          ladders--;
        } else {
          // Unfortunately, it's not possible to go ahead any further.
          break;
        }
      }
      return reach; // This is the max we can go ahead.
    }
};