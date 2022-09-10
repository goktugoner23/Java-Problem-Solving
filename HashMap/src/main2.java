import java.util.Map;

public class main2 {
    public static void main(String[] args) {
        String input = "göktuğ öner";
        OccurrenceClass occurMaps = new OccurrenceClass();
        for (Map.Entry<Character, Integer> entry : occurMaps.mapFunction(input).entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
