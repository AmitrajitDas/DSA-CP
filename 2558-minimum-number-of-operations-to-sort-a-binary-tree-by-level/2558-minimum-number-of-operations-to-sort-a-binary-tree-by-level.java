/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countMinSwapsToSort(List<Integer> vec) {
        int swaps = 0;
        List<Integer> sortedVec = new ArrayList<>(vec);
        Collections.sort(sortedVec);

        Map<Integer, Integer> mp = new HashMap<>(); // nums[i] -> i
        for (int i = 0; i < vec.size(); i++) {
            mp.put(vec.get(i), i);
        }

        for (int i = 0; i < vec.size(); i++) {
            if (vec.get(i).equals(sortedVec.get(i))) {
                continue; // no swap required
            }

            int currIdx = mp.get(sortedVec.get(i));
            mp.put(vec.get(i), currIdx);
            mp.put(vec.get(currIdx), i);
            Collections.swap(vec, currIdx, i);
            swaps++;
        }

        return swaps;
    }

    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        int result = 0;

        while (!que.isEmpty()) {
            int n = que.size(); // total nodes in the current level
            List<Integer> vec = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode temp = que.poll();
                vec.add(temp.val);

                if (temp.left != null) {
                    que.add(temp.left);
                }

                if (temp.right != null) {
                    que.add(temp.right);
                }
            }

            result += countMinSwapsToSort(vec);
        }

        return result;
    }
}