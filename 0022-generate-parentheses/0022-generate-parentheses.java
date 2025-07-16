class Solution {
    private void generate(int opened, int closed, int n, StringBuilder sb, List<String> res) {
        if(opened == n && closed == n) {
            res.add(sb.toString());
        }

        if(opened < n) {
            sb.append('(');
            generate(opened + 1, closed, n, sb, res);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }
        if(closed < opened) {
            sb.append(')');
            generate(opened, closed + 1, n, sb, res);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        } 
    }

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        generate(0, 0, n, sb, res);
        return res;
    }
}