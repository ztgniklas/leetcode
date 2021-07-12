/**
 * O(n^2)的方法会TLE
 */
class Solution {
    public String minWindow(String s, String t) {
        String rst = "";
        Map<Character, Integer> mapT = new HashMap<>();
        for (char c : t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (mapT.containsKey(s.charAt(i))) {
                //stop
                String curS = search(s, i, new HashMap<>(mapT));
                if ("".equals(rst) && rst.length() < curS.length()) {
                    rst = curS;
                } else if (!"".equals(curS) && rst.length() > curS.length()) {
                    rst = curS;
                }
            }
        }
        return rst;
    }
    
    private String search(String s, int start, Map<Character, Integer> map) {
        int end = -1;
        for (int i = start; i < s.length(); i++) {
            char curC = s.charAt(i);
            if (map.containsKey(curC)) {
                map.put(curC, map.get(curC) - 1);
                if (map.get(curC) == 0) {
                    map.remove(curC);
                }
                if (map.isEmpty()) {
                    end = i;
                    break;
                }
            }
        }
        return end == -1 ? "" : s.substring(start, end + 1);
    }
}

/**
 * 一定将Integer转为intValue()再比较大小
 * 使用slide window，使用两个指针l和r，都起始于第0个字符。首先r向右，每次统计当前处于window
 * 内的字符情况，一旦完全包含了t，则循环右移l，不断取最短长度，直到substring(l, r + 1)不再完全
 * 包含t了，则重复以上步骤，再次右移r......
 */
class Solution {
    public String minWindow(String s, String t) {
        int left = 0, right = 0, formed = 0;
        String rst = "";
        Map<Character, Integer> mapT = new HashMap<>(), mapW = new HashMap<>();
        for (char c : t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }
        while (left <= right && right < s.length()) {
            char curC = s.charAt(right);
            if (mapT.containsKey(curC)) {
                mapW.put(curC, mapW.getOrDefault(curC, 0) + 1);
                if (mapW.get(curC).intValue() == mapT.get(curC).intValue() && formed < mapT.size()) {
                    formed++;
                }
            }
            if (formed == mapT.size()) {
                // stop and calculate
                while (left <= right && formed == mapT.size()) {
                    String curS = s.substring(left, right + 1);
                    if ("".equals(rst) && curS.length() > rst.length() ||
                       !"".equals(rst) && !"".equals(curS) && curS.length() < rst.length()) {
                        rst = curS;
                    }
                    if (mapT.containsKey(s.charAt(left))) {
                        // check if need to extend right
                        mapW.put(s.charAt(left), mapW.get(s.charAt(left)) - 1);
                        if (mapW.get(s.charAt(left)).intValue() < mapT.get(s.charAt(left)).intValue()) {
                            formed--;
                        }
                    }
                    left++;
                }
            }
            
            right++;
        }
        return rst;
    }
}