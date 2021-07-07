/**
 * 类似permutation，标准的dfs递归
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ips = new ArrayList<>();
        helper(ips, s, new ArrayList<>());
        return ips;
    }
    
    private void helper(List<String> ips, String s, List<String> curIp) {
        if ((s == null || s.length() == 0) && curIp.size() == 4) {
            ips.add(String.join(".", curIp.toArray(new String[0])));
            return;
        }
        if (curIp.size() == 4 || (s == null || s.length() == 0)) {
            return;
        }
        // 0...
        if (s.charAt(0) == '0') {
            curIp.add("0");
            helper(ips, s.substring(1), new ArrayList<>(curIp));
            curIp.remove(curIp.size() - 1);
            return;
        }
        for (int i = 0; i < s.length() && i <= 2; i++) {
            int cur = Integer.parseInt(s.substring(0, i + 1));
            if (cur > 0 && cur <= 255) {
                curIp.add(s.substring(0, i + 1));
                helper(ips, s.substring(i + 1), new ArrayList<>(curIp));
                curIp.remove(curIp.size() - 1);
            }
        }
        
    }
}