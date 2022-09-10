import java.util.Map;

public class main {
    public static void main(String[] args) {
        Maps newMaps = new Maps();
        Map<Integer, String> map = newMaps.mapFunction();
        for (Map.Entry<Integer, String> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println(map.get(251));
        System.out.println(" ");
        Map<Integer, AggregatedClass> latestmap = newMaps.aggregatedMapFunction();
        for (Map.Entry<Integer, AggregatedClass> entry : latestmap.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue().getname() + " "+ entry.getValue().getsurname() + " "+ entry.getValue().getdob());
        }
        System.out.println(" ");
        for (Map.Entry<Integer, AggregatedClass> entry : latestmap.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue().variables()); //you can also add ID section to variables() function and get rid of entry.getKey()
        }
    }
}