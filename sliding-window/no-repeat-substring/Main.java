import java.util.HashMap;
import java.util.Map;

/***
 * Given a string, find the length of the longest substring which has no repeating characters.
 *
 * Input: String="aabccbb"
 * Output: 3
 * Explanation: The longest substring without any repeating characters is "abc".
 *
 * Input: String="abbbb"
 * Output: 2
 * Explanation: The longest substring without any repeating characters is "ab".
 *
 * Input: String="abccde"
 * Output: 3
 * Explanation: Longest substrings without any repeating characters are "abc" & "cde".
 */
public class Main {

  /***
   * Sliding Window
   * @param str
   * @return
   * Worst => O(N) time O(1) space
   */
  public static int findLength(String str) {
    int start = 0, end = 0, longest = 0;
    Map<Character, Integer> map = new HashMap<>();

    while (end < str.length()) {
      Character endChar = str.charAt(end);

      map.put(endChar, map.getOrDefault(endChar, 0) + 1);

      while (map.get(endChar) > 1) {
        Character startChar = str.charAt(start);
        map.put(startChar, map.get(startChar) - 1);
        ++start;
      }
      ++end;

      longest = Math.max(longest, end - start);
    }

    return longest;
  }

  /***
   * Sliding Window more efficient
   * @param str
   * @return
   * Worst => O(N) time O(1) space
   */
  public static int findLength1(String str) {
    int start = 0, end = 0, longest = 0;
    Map<Character, Integer> map = new HashMap<>();

    while (end < str.length()) {
      Character endChar = str.charAt(end);

      if (map.containsKey(endChar) && map.get(endChar) >= start) {
        start = map.get(endChar) + 1;
      }
      map.put(endChar, end);
      ++end;
      longest = Math.max(longest, end - start);
    }

    return longest;
  }

  public static void main(String[] args) {
    String str = "aabccbb";
    System.out.println(findLength1(str));
    System.out.println(findLength(str));

    str = "abbbb";
    System.out.println(findLength1(str));
    System.out.println(findLength(str));

    str = "abccde";
    System.out.println(findLength1(str));
    System.out.println(findLength(str));

    str = "abcxdzdxpqrst";
    System.out.println(findLength1(str));
    System.out.println(findLength(str));
  }
}
