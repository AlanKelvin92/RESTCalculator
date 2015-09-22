package co.edu.eafit.data;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
public class MemoryCRUD {


	
	public MemoryCRUD() {
	
	}
	
	MongoClient mongoClient;
	MongoDatabase db;
	
	public void setMemory(float m){
		openConnection();
		db.getCollection("Memory").insertOne(new Document().append("value", m));
		mongoClient.close();
	}
	
	public FindIterable<Document> getMemory(){
		openConnection();
		FindIterable<Document> iterable = db.getCollection("Memory").find(new Document());
		return iterable;
	}
	
	public void openConnection(){
		mongoClient = new MongoClient( "localhost" , 27017 );
		db = mongoClient.getDatabase("CalculatorData");
	}
}
