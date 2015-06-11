package edu.gqq.json;

import com.google.gson.Gson;

public class ToGsonExample {
	public static void main(String[] args) {
		Gson gson=new Gson();
		DataObject dataObject = new DataObject();
		String json = gson.toJson(dataObject);
		System.out.println(json);
	}
}
