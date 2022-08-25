import java.util.HashMap;
import java.util.Map;

/***
 * Given an array of characters where each character represents a fruit tree, 
 * you are given two baskets and your goal is to put maximum number of fruits in each basket. 
 * The only restriction is that each basket can have only one type of fruit.
 * 
 * Input: Fruit=['A', 'B', 'C', 'A', 'C']
 * Output: 3
 * Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
 * 
 * Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
 * Output: 5
 * Explanation: We can put 3 'B' in one basket and two 'C' in the other basket. 
 * This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
 */
public class Main {

    public static boolean isBasketEmpty(Map<Character, Integer> map, Character basket) {
        if (basket == null) return true;
        return  !(map.containsKey(basket) && map.get(basket) > 0);
    }

    /***
     * Sliding Window
     * @param fruits
     * @return
     * Worst => O(N) time O(1) space
     */
    public static int fruitBasket(char[] fruits) {

        Map<Character, Integer> map = new HashMap<>();
        Character basket1 = null, basket2 = null;
        int maxFruit = 0, start = 0, end = 0;

        while (end < fruits.length) {
            char curFruit = fruits[end];
            if(basket1 != null && basket1 == curFruit) {
                map.put(basket1, map.get(basket1) + 1);
            } else if(basket2 != null && basket2 == curFruit) {
                map.put(basket2, map.get(basket2) + 1);
            } else if(isBasketEmpty(map, basket1)) {
                basket1 = curFruit;
                map.put(basket1, 1);
            } else if(isBasketEmpty(map, basket2)) {
                basket2 = curFruit;
                map.put(basket2, 1);
            } else {
                //empty a basket
                while(!isBasketEmpty(map, basket1) && !isBasketEmpty(map, basket2)) {
                    Character startFruit = fruits[start];
                    if(!map.containsKey(startFruit)) {
                        System.out.println(startFruit);
                        System.out.println(basket1);
                        System.out.println(basket2);
                    }
                    int count = map.get(startFruit) - 1;
                    map.put(startFruit, count);
                    start++;
                }
            }

            maxFruit = Math.max(maxFruit, end - start + 1);
            end++;
        }

        return maxFruit;

    }

    public static void main(String[] args) {
        char[] fruits = {'A', 'B', 'C', 'B', 'B', 'C'};
        System.out.println(fruitBasket(fruits));
    }
    
}
