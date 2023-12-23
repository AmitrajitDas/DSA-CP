class NumberContainers {
    // Map to store the mapping of index to number
    private Map<Integer, Integer> idx_num;
    // Map to store the mapping of number to a sorted set of indices
    private Map<Integer, TreeSet<Integer>> num_idx;

    public NumberContainers() {
        idx_num = new HashMap<>();
        num_idx = new HashMap<>();
    }

    public void change(int index, int number) {
        // Check if the index is already in the map
        if (idx_num.containsKey(index)) {
            // Retrieve the existing number for the index
            Integer existingNum = idx_num.get(index);

            // Retrieve the set of indices for the existing number
            TreeSet<Integer> idxSet = num_idx.get(existingNum);

            // Check if the set of indices is not null
            if (idxSet != null) {
                // Remove the current index from the set
                idxSet.remove(index);

                // Check if the set is now empty and remove the mapping if so
                if (idxSet.isEmpty()) {
                    num_idx.remove(existingNum);
                }
            }
        }

        // Update the mapping of index to number
        idx_num.put(index, number);

        // Retrieve the set of indices for the new number
        TreeSet<Integer> idxSet = num_idx.get(number);

        // Check if the set is null
        if (idxSet == null) {
            // If the set is null, create a new TreeSet
            idxSet = new TreeSet<>();
            // Put the new set in the map
            num_idx.put(number, idxSet);
        }

        // Add the current index to the set
        idxSet.add(index);
    }

    public int find(int number) {
        // Retrieve the set of indices for the given number
        TreeSet<Integer> idxSet = num_idx.get(number);
        // Check if the set is null or empty
        return (idxSet == null || idxSet.isEmpty()) ? -1 : idxSet.iterator().next();
    }
}