class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> OcurLst = new ArrayList<>();
        if (words.length <= 2) {
            return new String[0];
        }
        for (int i = 0; i < words.length - 2; i++) {
            if (first.equals(words[i]) && second.equals(words[i + 1])) {
                OcurLst.add(words[i + 2]);
            }
        }
        return OcurLst.toArray(new String[0]);
    }
}