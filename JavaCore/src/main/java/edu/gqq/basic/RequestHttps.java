package edu.gqq.basic;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class RequestHttps {
	private static String url = "https://istheapplestoredown.com/api/v1/status/worldwide";

	public static void main(String[] args) {
		// Create an instance of HttpClient.
		HttpClient client = HttpClientBuilder.create().build();

		HttpGet request = new HttpGet(url);

		try {

			HttpResponse response = client.execute(request);
			String contents = EntityUtils.toString(response.getEntity(), "UTF-8");
			Gson gson = new Gson();
			JsonParser parser = new JsonParser();
			JsonObject jo = parser.parse(contents).getAsJsonObject();
			Map<String, Info> map = new HashMap<>();
			for (Map.Entry<String, JsonElement> entry : jo.entrySet()) {
				map.put(entry.getKey(), gson.fromJson(entry.getValue(), Info.class));
			}

			map.forEach((k, v) -> {
				System.out.println(k + "--->" + v);
			});

		} catch (IOException e) {
			System.err.println("Fatal transport error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}

class Info {
	String name;
	String status;

	@Override
	public String toString() {
		return name + " " + status;
	}
}