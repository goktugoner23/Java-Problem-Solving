import java.util.HashMap;
import java.util.Map;

public class OccurrenceClass {
    public Map<Character, Integer> mapFunction(String input)
    {
        if (input == null)
        {
            throw new IllegalArgumentException("map is empty");
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<input.length(); i++)
        {
            if (input.charAt(i) == ' ')
            {
                continue; //çok robust, güzel
            }

            if(map.get(input.charAt(i)) != null)
            {
                int occurrence = map.get(input.charAt(i)) + 1;
                map.put(input.charAt(i), occurrence);
            }else
            {
                map.put(input.charAt(i), 1);
            }
        }
        return map;
    }
}
