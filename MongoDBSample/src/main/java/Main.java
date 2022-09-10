import com.mongodb.client.*;
import org.bson.Document;

public class Main {
    public static void main(String[] args) {
        //create the client for connection
        MongoClient client = MongoClients.create("mongodb+srv://goktugoner:goktugoner123@cluster0.h0zwq.mongodb.net/?retryWrites=true&w=majority");

        MongoDatabase db = client.getDatabase("BioData");
        MongoCollection<Document> col = db.getCollection("bios");
        System.out.println(col.countDocuments());

        //insert a document to the collection
        Document sampleDoc = new Document("_id", "1").append("name", "goktug oner");
        //col.insertOne(sampleDoc);
        //col.deleteOne(sampleDoc);

        //get the list of databases
        MongoIterable<String> list = client.listDatabaseNames();
        for(String dbName: list){
            System.out.println(dbName);
        }
    }

}
