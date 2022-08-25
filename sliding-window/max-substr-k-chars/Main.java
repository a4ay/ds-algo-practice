import java.util.HashMap;
import java.util.Map;

/***
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 *
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 *
 * Input: String="araaci", K=1
 * Output: 2
 * Explanation: The longest substring with no more than '1' distinct characters is "aa".
 *
 * Input: String="cbbebi", K=3
 * Output: 5
 * Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
 *
 */
public class Main {

  public static int longestSubstr(String str, int k) {
    Map<Character, Integer> map = new HashMap<>();
    int start = 0, end = 0, longest = 0, distChars = 0;

    while (end < str.length()) {
      char currChar = str.charAt(end);
      if (!map.containsKey(currChar) || map.get(currChar) == 0) {
        distChars++;
        map.put(currChar, 1);
      }
      while (distChars > k) {
        char startChar = str.charAt(start);
        int freq = map.get(startChar);
        distChars = freq == 1 ? distChars - 1 : distChars;
        map.put(startChar, freq - 1);
        start++;
      }
      longest = Math.max(longest, distChars);
      end++;
    }

    return longest;
  }

  public static void main(String[] args) {
    String str = "araaci";
    int k = 2;
    System.out.println(longestSubstr(str, k));

    str = "araaci";
    k = 1;
    System.out.println(longestSubstr(str, k));

    str = "cbbebi";
    k = 3;
    System.out.println(longestSubstr(str, k));
  }
}
