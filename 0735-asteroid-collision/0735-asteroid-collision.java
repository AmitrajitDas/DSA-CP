class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<Integer>();

        for (int it : asteroids) {
            // Loop through each asteroid in the input array

            while (!st.isEmpty() && st.peek() > 0 && it < 0) {
                // Check if there are asteroids in the stack and the current asteroid `it`
                // is a negative asteroid, while the top of the stack is a positive asteroid.

                int sum = st.peek() + it;

                if (sum < 0) {
                    // If the sum is negative, it means the current asteroid `it` destroys the
                    // asteroid on top of the stack (as they collide).
                    // So, remove the top asteroid from the stack.
                    st.pop();
                } else if (sum > 0) {
                    // If the sum is positive, it means the current asteroid `it` is destroyed
                    // by the asteroid on top of the stack (as they collide).
                    // So, set the current asteroid `it` to 0 to indicate it has been destroyed.
                    it = 0;
                } else {
                    // If the sum is zero, it means both asteroids are destroyed (as they have
                    // the same size and collide).
                    // So, remove the top asteroid from the stack and set the current asteroid `it`
                    // to 0 to indicate it has been destroyed.
                    st.pop();
                    it = 0;
                }
            }

            if (it != 0) {
                // If the current asteroid `it` survived the collision with other asteroids,
                // add it to the stack.
                st.push(it);
            }
        }

        int m = st.size();
        int[] res = new int[m];

        int i = m - 1;
        while (!st.isEmpty()) {
            res[i--] = st.pop();
        }

        return res;
    }
}
