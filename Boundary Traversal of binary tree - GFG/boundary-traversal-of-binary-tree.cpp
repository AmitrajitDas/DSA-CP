// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;
#define MAX_HEIGHT 100000

// Tree Node
struct Node
{
    int data;
    Node* left;
    Node* right;
};

// Utility function to create a new Tree Node
Node* newNode(int val)
{
    Node* temp = new Node;
    temp->data = val;
    temp->left = NULL;
    temp->right = NULL;

    return temp;
}


// Function to Build Tree
Node* buildTree(string str)
{
    // Corner Case
    if(str.length() == 0 || str[0] == 'N')
        return NULL;

    // Creating vector of strings from input
    // string after spliting by space
    vector<string> ip;

    istringstream iss(str);
    for(string str; iss >> str; )
        ip.push_back(str);

    // Create the root of the tree
    Node* root = newNode(stoi(ip[0]));

    // Push the root to the queue
    queue<Node*> queue;
    queue.push(root);

    // Starting from the second element
    int i = 1;
    while(!queue.empty() && i < ip.size()) {

        // Get and remove the front of the queue
        Node* currNode = queue.front();
        queue.pop();

        // Get the current node's value from the string
        string currVal = ip[i];

        // If the left child is not null
        if(currVal != "N") {

            // Create the left child for the current node
            currNode->left = newNode(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->left);
        }

        // For the right child
        i++;
        if(i >= ip.size())
            break;
        currVal = ip[i];

        // If the right child is not null
        if(currVal != "N") {

            // Create the right child for the current node
            currNode->right = newNode(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->right);
        }
        i++;
    }

    return root;
}









 // } Driver Code Ends
/* A binary tree Node
struct Node
{
    int data;
    Node* left, * right;
}; */

class Solution {
    
bool isLeaf(Node* root) {
    return !root->left && !root->right;
}
    
void addLeftBoundary(Node *root, vector<int> &ds) {
    Node *curr = root->left;
    while(curr) {
        if(!isLeaf(curr)) 
            ds.push_back(curr->data);
        if(curr->left)
            curr = curr->left;
        else
            curr = curr->right;
    }
}

void addLeaves(Node* root, vector<int> &ds) {
        if (isLeaf(root)) {
            ds.push_back(root->data);
            return;
        }
        if (root->left) addLeaves(root->left, ds);
        if (root->right) addLeaves(root->right, ds);
}

void addRightBoundary(Node *root, vector<int> &ds) {
    Node *curr = root->right;
    stack<int> right;
    while(curr) {
        if(!isLeaf(curr))
            right.push(curr->data);
        if(curr->right)
            curr = curr->right;
        else
            curr = curr->left;
    }
    
    while(!right.empty()) {
        int val = right.top();
        ds.push_back(val);
        right.pop();
    }
}
    
public:
    vector <int> boundary(Node *root) {
        vector<int> ds;
        if(!root) return ds;
        if(!isLeaf(root)) ds.push_back(root->data);
        addLeftBoundary(root, ds);
        addLeaves(root, ds);
        addRightBoundary(root, ds);
        
        return ds;
    }
};

// { Driver Code Starts.

/* Driver program to test size function*/

int main() {
    int t;
    string tc;
    getline(cin, tc);
    t=stoi(tc);
    while(t--)
    {
        string s ,ch;
        getline(cin, s);
        Node* root = buildTree(s);
        Solution ob;
        vector <int> res = ob.boundary(root);
        for (int i : res) cout << i << " ";
        cout << endl;
    }
    return 0;
}  // } Driver Code Ends