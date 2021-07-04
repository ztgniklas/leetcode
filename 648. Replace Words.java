/**
 * 对每个词尝试prefix是否在字典中
 * 还可以使用Trie数
 */
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> roots = new HashSet<>();
        roots.addAll(dictionary);
        String[] words = sentence.split(" ");
        StringBuffer sb = new StringBuffer();
        for (String word : words) {
            boolean hasRoot = false;
            for (int i = 1; i < word.length() + 1; i++) {
                if (roots.contains(word.substring(0, i))) {
                    sb.append(word.substring(0, i));
                    sb.append(" ");
                    hasRoot = true;
                    break;
                }
            }
            if (!hasRoot) {
                sb.append(word);
                sb.append(" ");
            }
            
        }
        return sb.substring(0, sb.length() - 1).toString();
    }
}