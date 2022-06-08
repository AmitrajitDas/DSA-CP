class Solution
{
public:
    bool dfsCycle(int node, vector<vector<int>> &adj, vector<int> &vis)
    {
        if (vis[node] == 2)
            return true;

        vis[node] = 2; // processing state
        for (auto it : adj[node])
        {
            if (vis[it] != 1)
                if (dfsCycle(it, adj, vis))
                    return true;
        }

        vis[node] = 1; // processed state
        return false;
    }

    bool canFinish(int numCourses, vector<vector<int>> &prerequisites)
    {

        vector<vector<int>> adj(numCourses);

        for (int i = 0; i < prerequisites.size(); i++)
            adj[prerequisites[i][0]].push_back(prerequisites[i][1]); // building the adjacency matrix

        vector<int> vis(numCourses);
        for (int i = 0; i < numCourses; i++)
        {
            if (vis[i] == 0)
                if (dfsCycle(i, adj, vis)) // if cycle is formed then the course can't be finished
                    return false;
        }

        return true;
    }
};