package com.test.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongodbTest {

	private MongoDatabase mongoDatabase;
	
	@Before
	public void setUp(){
		try {
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			mongoDatabase = mongoClient.getDatabase("test");
			System.out.println("Connect to database successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
	}
	
	
	// 查找集合全部元素
	@Test
	public void findCollection() {
		
		MongoCollection<Document> collection = mongoDatabase.getCollection("cainiao");
		
		FindIterable<Document> iterable = collection.find();
		
		MongoCursor<Document> iterator = iterable.iterator();
		while (iterator.hasNext()) {
			Document doc = iterator.next();
			System.err.println(doc.get("x"));
		}
	}
	
	
	// 根据条件查出全部元素
	@Test
	public void findCollectionByCondition() {
		
		MongoCollection<Document> collection = mongoDatabase.getCollection("cainiao");
		
		Bson gt = Filters.gt("x", 103);
		
		FindIterable<Document> iterable = collection.find(gt);
		
		for (Document document : iterable) {
			System.err.println(document.toJson());
		}
		
	}
	
	// 插入文档
	@Test
	public void insertDoc(){
		MongoCollection<Document> collection = mongoDatabase.getCollection("cainiao");
		
		List<Document> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Document doc = new Document();
			doc.append("x", 200+i);
			list.add(doc);
		}
		collection.insertMany(list);
	}
	
	// 以JSON格式插入文档
	@Test
	public void insertJson(){
		MongoCollection<Document> collection = mongoDatabase.getCollection("student");
		
		List<Document> list = new ArrayList<>();
		String stu_a = "{'name':'赵云','sex':'M','address':'广州荔湾'}";
		String stu_b = "{'name':'刘备','sex':'M','address':'广州荔湾2'}";
		list.add(Document.parse(stu_a));
		list.add(Document.parse(stu_b));
		
		collection.insertMany(list);
		
		FindIterable<Document> table = collection.find();
		
		for (Document document : table) {
			System.err.println(document.toJson());
		}
	}
	
	
	
	// 删除文档
	@Test
	public void delDoc() {
		MongoCollection<Document> collection = mongoDatabase.getCollection("cainiao");

		// 删除符合条件的第一个文档
		//collection.deleteOne(Filters.eq("x", 10.0));
		// 删除所有符合条件的文档
		collection.deleteMany(Filters.gt("x", 200));

	}
	
}
