import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/***
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter,
 * find the length of the longest substring having the same letters after replacement.
 *
 * Input: String="aabccbb", k=2
 * Output: 5
 * Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
 *
 * Input: String="abbcb", k=1
 * Output: 4
 * Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
 *
 * Input: String="abccde", k=1
 * Output: 3
 * Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
 */
public class Main {

    /***
     * Sliding Window
     * @param str
     * @param k
     * @return
     * Worst Case => O(N) time O(1) space;
     */
  public static int findLength(String str, int k) {
    Map<Character, Integer> map = new HashMap<>();
    int start = 0, end = 0, longest = 0, replacedChar = 0;

    while (end < str.length()) {
      Character endChar = str.charAt(end);
      Character startChar = str.charAt(start);

      if (endChar != startChar) {
        replacedChar++;
        map.put(endChar, end);

        if (replacedChar > k) {
          start = map.get(startChar) + 1;
          map.remove(startChar);
          replacedChar = 0;
          for (Entry<Character, Integer> entry : map.entrySet()) { // MAX iter will be 26
            if (entry.getKey() != str.charAt(start)) {
              replacedChar += entry.getValue();
            }
          }
        }
      } else {
        map.put(startChar, end);
      }

      ++end;

      longest = Math.max(longest, end - start);
    }

    return longest;
  }

  public static void main(String[] args) {
    String str = "aabccbb";
    int k = 2;
    System.out.println(findLength(str, k));

    str = "abbcb";
    k = 1;
    System.out.println(findLength(str, k));

    str="abccde";
    k=1;
    System.out.println(findLength(str, k));
  }
}
