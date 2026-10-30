import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0 || s.length() == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int numWords = words.length;
        int totalLen = wordLen * numWords;

        if (s.length() < totalLen) {
            return result;
        }

        // Frequency map for all words in the input array
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        // Iterate over all possible wordLen starting offsets
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i;
            Map<String, Integer> seenWords = new HashMap<>();
            int count = 0;

            while (right + wordLen <= s.length()) {
                String sub = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordFreq.containsKey(sub)) {
                    seenWords.put(sub, seenWords.getOrDefault(sub, 0) + 1);
                    count++;

                    // If there are more instances of 'sub' than allowed, shrink from the left
                    while (seenWords.get(sub) > wordFreq.get(sub)) {
                        String leftSub = s.substring(left, left + wordLen);
                        seenWords.put(leftSub, seenWords.get(leftSub) - 1);
                        left += wordLen;
                        count--;
                    }

                    // If all words are matched, record the starting index
                    if (count == numWords) {
                        result.add(left);
                        // Slide the window left by one word to search for overlapping matches
                        String leftSub = s.substring(left, left + wordLen);
                        seenWords.put(leftSub, seenWords.get(leftSub) - 1);
                        left += wordLen;
                        count--;
                    }
                } else {
                    // Not a valid word, reset the window
                    seenWords.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}