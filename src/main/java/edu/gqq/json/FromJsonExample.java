package edu.gqq.json;

import com.google.gson.Gson;

public class FromJsonExample {
	public static void main(String[] args) {
		// all data
		String jsonString = "{'data1':10,'data2':'hello2','list':['String 1','String 2','String 3', 'String 4']}";
		Gson gson=new Gson();
		DataObject obj = gson.fromJson(jsonString, DataObject.class);
		System.out.println(obj);
		
		//some data
		String jsonString2 = "{'list':['String 1','String 2','String 3', 'String 4']}";
		DataObject obj2 = gson.fromJson(jsonString2, DataObject.class);
		System.out.println(obj2);
		
	}
}
