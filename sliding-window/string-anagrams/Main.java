import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * Given a string and a pattern, find all anagrams of the pattern in the given string.
 *
 * Anagram is actually a Permutation of a string. For example, "abc" has the following six anagrams:
 *
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * Write a function to return a list of starting indices of the anagrams of the pattern in the given string.
 *
 * Example 1:
 *
 * Input: String="ppqp", Pattern="pq"
 * Output: [1, 2]
 * Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".
 * Example 2:
 *
 * Input: String="abbcabc", Pattern="abc"
 * Output: [2, 3, 4]
 * Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".
 */
public class Main {

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> anagrams = new ArrayList<>();
        int start = 0, end = 0;
        Map<Character, Integer> patFreq = new HashMap<>();
        Map<Character, Integer> strFreq = new HashMap<>();

        for(int i = 0; i < pattern.length(); ++i) {
            Character patChar = pattern.charAt(i);
            patFreq.put(patChar, patFreq.getOrDefault(patChar, 0) + 1);
        }

        while(end < str.length()) {
            Character endChar = str.charAt(end);
            strFreq.put(endChar, strFreq.getOrDefault(endChar, 0) + 1);

            if(end >= pattern.length()-1) {
                Character startChar = str.charAt(start);
                if(strFreq.equals(patFreq)) {
                    anagrams.add(start);
                }
                strFreq.put(startChar, strFreq.get(startChar) - 1);
                if(strFreq.get(startChar) == 0) {
                    strFreq.remove(startChar);
                }
                ++start;
            } 

            ++end;
        }

        return anagrams;
    }

  public static void main(String[] args) {
    String str = "ppqp", pattern = "pq";
    System.out.println(findStringAnagrams(str, pattern));

    str="abbcabc"; pattern = "abc";
    System.out.println(findStringAnagrams(str, pattern));
  }
}
