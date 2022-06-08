class Solution
{
public:
    bool detectCycle_util(vector<vector<int>> &adj, vector<int> &visited, int node)
    {
        if (visited[node] == 1)
            return true;
        if (visited[node] == 2)
            return false;

        visited[node] = 1; // Mark current as visited
        for (auto it : adj[node])
            if (detectCycle_util(adj, visited, it))
                return true;

        visited[node] = 2; // Mark current node as processed
        return false;
    }

    // Cycle detection
    bool detectCycle(vector<vector<int>> &adj, int n)
    {
        vector<int> visited(n, 0);
        for (int i = 0; i < n; ++i)
            if (!visited[i])
                if (detectCycle_util(adj, visited, i))
                    return true;
        return false;
    }

    void findTopoSort(int node, vector<vector<int>> &adj, vector<int> &vis, stack<int> &st)
    {
        vis[node] = 1;

        for (auto it : adj[node])
        {
            if (vis[it] == 0)
                findTopoSort(it, adj, vis, st);
        }

        st.push(node); // to store the topo sorted elements
    }

    vector<int> findOrder(int numCourses, vector<vector<int>> &prerequisites)
    {
        vector<vector<int>> adj(numCourses);

        for (int i = 0; i < prerequisites.size(); i++) // building the graph
            adj[prerequisites[i][0]].push_back(prerequisites[i][1]);

        stack<int> st;
        vector<int> vis(numCourses, 0);
        vector<int> res;

        if (detectCycle(adj, numCourses))
            return res;

        for (int i = 0; i < numCourses; i++)
            if (vis[i] == 0)
            {
                findTopoSort(i, adj, vis, st);
            }

        while (!st.empty())
        {
            int node = st.top();
            st.pop();
            res.push_back(node);
        }

        reverse(res.begin(), res.end());

        return res;
    }
};