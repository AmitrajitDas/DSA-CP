class DisjointSet {
    int[] parent, size;
    
    /**
     * Constructor to initialize the disjoint set
     * @param n - number of nodes (0 to n-1)
     */
    DisjointSet(int n) {
        parent = new int[n + 1];  // Parent array to store parent of each node
        size = new int[n + 1];    // Size array to store size of each component
        
        // Initialize each node as its own parent (separate component)
        // and each component size as 1
        for(int i = 0; i < n; i++) {
            parent[i] = i;  // Each node is initially its own parent
            size[i] = 1;    // Each component initially has size 1
        }
    }
    
    /**
     * Find the ultimate parent (root) of a node with path compression
     * Path compression: makes the tree flatter by directly connecting 
     * nodes to their ultimate parent during traversal
     * @param node - the node whose ultimate parent we want to find
     * @return ultimate parent of the node
     */
    int findParent(int node) {
        if(parent[node] == node) return node;  // Base case: node is its own parent
        // Path compression: update parent[node] to ultimate parent while recursing
        return parent[node] = findParent(parent[node]);
    }
    
    /**
     * Union by size: merge two components by attaching smaller component 
     * to the root of larger component to keep tree balanced
     * @param u - first node
     * @param v - second node
     */
    public void unionBySize(int u, int v) {
        int ulp_u = findParent(u);  // Find ultimate parent of u
        int ulp_v = findParent(v);  // Find ultimate parent of v
        
        // If both nodes already belong to same component, no union needed
        if(ulp_u == ulp_v) return;
        
        // Union by size: attach smaller component to larger one
        if(size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;      // Make ulp_v parent of ulp_u
            size[ulp_v] += size[ulp_u]; // Update size of resulting component
        } else {
            parent[ulp_v] = ulp_u;      // Make ulp_u parent of ulp_v
            size[ulp_u] += size[ulp_v]; // Update size of resulting component
        }
    }
}

class Solution {
    /**
     * Merges accounts belonging to the same person based on common email addresses
     * Uses Union-Find data structure to efficiently group related accounts
     * 
     * Algorithm:
     * 1. Map each email to the first account index where it appears
     * 2. Use Union-Find to connect accounts that share common emails
     * 3. Group all emails by their root parent account
     * 4. Build final result with sorted emails for each merged account
     * 
     * @param accounts - List of accounts, each containing [name, email1, email2, ...]
     * @return List of merged accounts with sorted emails
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        
        // HashMap to store mapping: email -> first account index that contains this email
        HashMap<String, Integer> mapMailsIdx = new HashMap<>();
        
        // Initialize disjoint set with n components (one for each account)
        DisjointSet ds = new DisjointSet(n);
        
        // Phase 1: Build the disjoint set by connecting accounts with common emails
        for(int i = 0; i < n; i++) {
            // Skip index 0 as it contains the account name, not email
            for(int j = 1; j < accounts.get(i).size(); j++) {
                String currMail = accounts.get(i).get(j);
                
                if(mapMailsIdx.containsKey(currMail)) {
                    // Email already seen in another account - union current account with that account
                    ds.unionBySize(i, mapMailsIdx.get(currMail));
                } else {
                    // First time seeing this email - map it to current account index
                    mapMailsIdx.put(currMail, i);
                }
            }
        }
        
        // Phase 2: Initialize mergedMails - array of lists to group emails by root parent
        List<List<String>> mergedMails = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            mergedMails.add(new ArrayList<>());  // Create empty list for each account
        }
        
        // Phase 3: Group emails by their root parent account
        for(Map.Entry<String, Integer> entry : mapMailsIdx.entrySet()) {
            String mail = entry.getKey();           // Get the email
            int accountIdx = entry.getValue();      // Get the account index this email was first seen in
            int rootParent = ds.findParent(accountIdx); // Find the root parent of this account
            
            // Add this email to the list of emails for the root parent account
            mergedMails.get(rootParent).add(mail);
        }
        
        // Phase 4: Build final result with account names and sorted emails
        List<List<String>> res = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            // Skip accounts that have no emails (not root parents of any merged group)
            if(mergedMails.get(i).size() == 0) {
                continue;
            }
            
            // Sort emails in lexicographical order as required
            Collections.sort(mergedMails.get(i));
            
            // Create result entry: [account_name, email1, email2, ...]
            List<String> tmp = new ArrayList<>();
            tmp.add(accounts.get(i).get(0));  // Add account name (first element)
            
            // Add all sorted emails for this merged account group
            for(String email : mergedMails.get(i)) {
                tmp.add(email);
            }
            
            res.add(tmp);  // Add this merged account to final result
        }
        
        return res;
    }
}