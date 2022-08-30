import java.util.*;

/***
 * Given a string and a list of words, find all the starting indices 
 * of substrings in the given string that are a concatenation of all the given words exactly once without any overlapping of words. 
 * It is given that all words are of the same length.
 *
 * Example 1:
 * 
 * Input: String="catfoxcat", Words=["cat", "fox"]
 * Output: [0, 3]
 * Explanation: The two substring containing both the words are "catfox" & "foxcat".
 * Example 2:
 * 
 * Input: String="catcatfoxfox", Words=["cat", "fox"]
 * Output: [3]
 * Explanation: The only substring containing both the words is "catfox".
 * 
 */
class Solution {
    
    /***
     * Sliding Window
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> wordFreq = new HashMap<>();
        for(int i = 0; i < words.length; ++i) {
            wordFreq.put(words[i], wordFreq.getOrDefault(words[i],0)+1);
        }
        List<Integer> results = new ArrayList<>();
        int wordCount = words.length, wordSize = words[0].length();
        
        for(int i = 0; i <= s.length() - wordCount * wordSize; ++i) {
            Map<String, Integer> newWordFreq = new HashMap<>();
            for(int j = 0; j < wordCount; ++j) {
                int nextWord = i + j * wordSize;
                String word = s.substring(nextWord, nextWord + wordSize);
                
                if(!wordFreq.containsKey(word)){
                    break;
                }
                newWordFreq.put(word, newWordFreq.getOrDefault(word, 0) + 1);
                
                if(newWordFreq.get(word) > wordFreq.getOrDefault(word, 0)) {
                    break;
                }
                
                if(j+1 == wordCount) {
                    results.add(i);
                }
            }
        }
        
        return results;
        
    }
}