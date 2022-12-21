import java.util.*;

//TC is O(h)
//SC is O(h)
class Solution {
    public String customSortString(String order, String s) {

        if (s == null || s.length() == 0)
            return "";

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            if (map.containsKey(order.charAt(i))) {
                int times = map.get(order.charAt(i));

                for (int j = 0; j < times; j++) {
                    sb.append(order.charAt(i));
                }

                map.remove(order.charAt(i));

            }
        }

        for (char key : map.keySet()) {
            int cnt = map.get(key);

            while (cnt > 0) {
                cnt--;
                sb.append(key);
            }
        }

        return sb.toString();
    }
}