import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    Map<String, Integer> contacts = new HashMap<>();
    public void addContact(String key, Integer value){
        contacts.put(key, value);
    }

    public void deleteContact(String key){
        contacts.remove("key");
    }
}
