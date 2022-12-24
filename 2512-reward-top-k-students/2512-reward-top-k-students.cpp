class Solution {
public:
    vector<int> topStudents(vector<string>& pf, vector<string>& nf, vector<string>& report, vector<int>& s_id, int k) {
        unordered_set<string> pset(begin(pf), end(pf));
        unordered_set<string> nset(begin(nf), end(nf));
        unordered_map<int, int> mp;
        mp.reserve(s_id.size());

        for(int i = 0; i < report.size(); i++) {
            int id = s_id[i], sz = report[i].size();
            for(int j = 0; j < sz; j++) {
                string r;
                while(j < sz && report[i][j] != 32) {
                    r += report[i][j];
                    j++;
                }
                if(pset.count(r)) mp[id] += 3;
                else if(nset.count(r)) mp[id] -= 1; 
            }
        }

        // Sorting the student_id array stated according to collected points of every student
        partial_sort(begin(s_id), begin(s_id) + k, end(s_id), [&](auto a, auto b) {
            return mp[a] == mp[b] ? a < b : mp[b] < mp[a];
        });

        s_id.resize(k);
        return s_id;
    }
};