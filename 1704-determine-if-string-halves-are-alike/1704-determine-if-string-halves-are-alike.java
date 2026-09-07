class Solution {
    public boolean halvesAreAlike(String s) {
        int count = 0;
        int mid = s.length() / 2;

        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                if (i < mid) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        return count == 0;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
            || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}

