package com.naver.choch92.mongdb;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;

public class MongoMain {

	public static void main(String[] args) {
		String ip = null;
		int port = -1;
		String dbName = null;
		
		// 문자를 파일에서 읽기 위한 스트림을 생성
		// close()하지 않기 위해서 try 안에서 생성
		try(BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream("./db.txt")))) {
			// 한 줄 읽기
			String line = br.readLine();
			System.out.printf("%s\n", line);
			// ,(콤마) 로 구분된 문자열을 배열에 저장하기
			String [] ar = line.split(",");
			ip = ar[0];
			port = Integer.parseInt(ar[1]);
			dbName = ar[2];
			/** 확인용도
			System.out.printf("ip : %s\n", ip);
			System.out.printf("port : %d\n", port);
			System.out.printf("dbName : %s\n", dbName);
			**/
			
			// MongoDB 연결
			MongoClient mc = new MongoClient(ip,port);
			// 데이터베이스 연결
			MongoDatabase db = mc.getDatabase("mymongo");
			// 데이터베이스 모든 컬렉션 가져오기
			MongoIterable<String> collections = db.listCollectionNames();
			// 빠른열거를 이용해서 접근
			for(String collection : collections) {
				System.out.printf("%s\n", collection);
			}
			
			// 데이터를 삽입하거나 삭제 및 수정 또는 조회를 할 컬렉션을 가져오기
			MongoCollection<Document> users = db.getCollection("users");
			// 쓰기권한을 가져오기
			users.getWriteConcern();
			// 데이터 읽기
			FindIterable<Document> documents = users.find(Filters.eq("id","user02"));
			for(Document document : documents) {
				System.out.printf("%s\n", document);
			}
			
			/**
			// 기록할 데이터 만들기
			Document document = new Document();
			document.put("id", "ggangpae1");
			document.put("password", "root");
			// 데이터 삽입
			users.insertOne(document);
			// 수정할 데이터 만들기
			document = new Document();
			document.put("password", "tjoeun");
			document.put("name", "군계");
			// 데이터 수정
			users.updateMany(Filters.eq("id", "ggangpae1"), new Document("$set", document));
			**/			
			mc.close();
		}catch(Exception e) {
			System.out.printf("파일 읽기 예외 : %s\n", e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}
	}
}
