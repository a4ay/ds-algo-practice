import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/***
 * Smallest Window containing Substring (hard) #
 * Given a string and a pattern, find the smallest substring in the given string which has all the characters of the given pattern.
 *
 * Example 1:
 *
 * Input: String="aabdec", Pattern="abc"
 * Output: "abdec"
 * Explanation: The smallest substring having all characters of the pattern is "abdec"
 * Example 2:
 *
 * Input: String="abdabca", Pattern="abc"
 * Output: "abc"
 * Explanation: The smallest substring having all characters of the pattern is "abc".
 * Example 3:
 *
 * Input: String="adcad", Pattern="abc"
 * Output: ""
 * Explanation: No substring in the given string has all characters of the pattern.
 */
public class Main {

    /***
     * Utility Method
     * Complexity Analysis: Max possible iter is 26 considering all alphabets in worst case
     * Hence: O(1) time and O(1) space
     */
  public static boolean hasPatChar(Map<Character, Integer> strFreq, Map<Character, Integer> patFreq) {
    for(Entry<Character, Integer> entry: patFreq.entrySet()) {
        if(strFreq.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
            return false;
        }
    }

    return true;
  } 

  /***
   * Sliding Window
   * @param str
   * @param pattern
   * @return
   * Worst Case => O(N) time, O(N) space
   */
  public static String findSubstring(String str, String pattern) {
    int start = 0, end = 0, startIndex = 0, endIndex = Integer.MAX_VALUE;
        Map<Character, Integer> patFreq = new HashMap<>();
        Map<Character, Integer> strFreq = new HashMap<>();
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < pattern.length(); ++i) {
          Character patChar = pattern.charAt(i);
          patFreq.put(patChar, patFreq.getOrDefault(patChar, 0) + 1);
        }

        while (end < str.length()) {
          Character endChar = str.charAt(end);

          if (patFreq.containsKey(endChar)) {
            strFreq.put(endChar, strFreq.getOrDefault(endChar, 0) + 1);
          }

          while (hasPatChar(strFreq, patFreq)) {
            if (endIndex - startIndex > end - start) {
              startIndex = start;
              endIndex = end;
            }
            Character startChar = str.charAt(start);
            if (patFreq.containsKey(startChar)) {
              strFreq.put(startChar, strFreq.get(startChar) - 1);
              if (strFreq.get(startChar) == 0) {
                strFreq.remove(startChar);
              }
            }
            ++start;
          }

          ++end;
        }
        if(endIndex - startIndex > str.length()) return "";
        while (startIndex <= endIndex) {
          result.append(str.charAt(startIndex));
          ++startIndex;
        }

        return result.toString();
  }

  public static void main(String[] args) {
    String str = "aabdec", pattern = "abc";
    System.out.println(findSubstring(str, pattern));

    str = "abdabca"; pattern = "abc";
    System.out.println(findSubstring(str, pattern));

    str = "ADOBECODEBANC"; pattern = "ABC";
    System.out.println(findSubstring(str, pattern));
  }
}
