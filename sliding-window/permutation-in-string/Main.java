import java.util.HashMap;
import java.util.Map;

/***
 * Given a string and a pattern, find out if the string contains any permutation of the pattern.
 * Permutation is defined as the re-arranging of the characters of the string.
 * For example, "abc" has the following six permutations:
 * 
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * If a string has ‘n’ distinct characters it will have n!n! permutations.
 *
 * Example 1:
 *
 * Input: String="oidbcaf", Pattern="abc"
 * Output: true
 * Explanation: The string contains "bca" which is a permutation of the given pattern.
 * Example 2:
 *
 * Input: String="odicf", Pattern="dc"
 * Output: false
 * Explanation: No permutation of the pattern is present in the given string as a substring.
 * Example 3:
 *
 * Input: String="bcdxabcdy", Pattern="bcdyabcdx"
 * Output: true
 * Explanation: Both the string and the pattern are a permutation of each other.
 * Example 4:
 *
 * Input: String="aaacb", Pattern="abc"
 * Output: true
 * Explanation: The string contains "acb" which is a permutation of the given pattern.
 */
public class Main {

  public static boolean findPermuation(String str, String pattern) {
    Map<Character, Integer> patternFreq = new HashMap<>();

    for (int i = 0; i < pattern.length(); ++i) {
      Character patChar = pattern.charAt(i);
      patternFreq.put(patChar, patternFreq.getOrDefault(patChar, 0) + 1);
    }

    Map<Character, Integer> strFreq = new HashMap<>();
    int start = 0, end = 0;

    while (end < str.length()) {
      Character endChar = str.charAt(end);
      strFreq.put(endChar, strFreq.getOrDefault(endChar, 0) + 1);
      if (end >= pattern.length() - 1) {
        if (strFreq.equals(patternFreq)) {
          return true;
        }
        Character startChar = str.charAt(start);
        strFreq.put(startChar, strFreq.get(startChar) - 1);
        if (strFreq.get(startChar) == 0) {
          strFreq.remove(startChar);
        }
        ++start;
      }
      ++end;
    }

    return false;
  }

  public static void main(String[] args) {
    String str = "oidbcaf", pattern = "abc";
    System.out.println(findPermuation(str, pattern));

    str="odicf"; pattern="dc";
    System.out.println(findPermuation(str, pattern));

    str="bcdxabcdy"; pattern="bcdyabcdx";
    System.out.println(findPermuation(str, pattern));

    str="aaacb"; pattern="abc";
    System.out.println(findPermuation(str, pattern));
  }
}
