import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();
        book.addContact("goktug", 123);
        book.addContact("pulur", 214);
        book.addContact("sila", 153);
        book.deleteContact("goktug"); //doesnt remove
        System.out.println(book.contacts.get("goktug"));
        System.out.println(book.contacts.get("pulur"));
        System.out.println(book.contacts.get("sila"));
    }
}
