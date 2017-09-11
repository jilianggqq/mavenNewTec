package edu.gqq.future;

import java.util.concurrent.CountDownLatch;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.Result;
import org.eclipse.jetty.client.util.BufferingResponseListener;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.util.ssl.SslContextFactory;

public class JettyHttpClientTest {
	public static void main(String[] args) throws Exception {
		HttpClient httpClient = new HttpClient(new SslContextFactory());
		// Configure HttpClient here
		// httpClient.doStart();
		httpClient.start();
		// httpClient.newRequest("http://www.eclipse.org/jetty/").send(new Response.CompleteListener() {
		// @Override
		// public void onComplete(Result result) {
		// // Your logic here
		// System.out.println(result.getResponse().getStatus());
		// System.out.println(result.getResponse().toString());
		// System.out.println(result.isSucceeded());
		// System.out.println(result.toString());
		// }
		// });
		// httpClient.newRequest("https://www.scientificamerican.com/podcast/60-second-science/").send(new
		// Response.Listener.Adapter() {
		// @Override
		// public void onContent(Response response, ByteBuffer buffer) {
		// // Your logic here
		//// response.get
		// System.out.println(response.getStatus());
		//// response.getHeaders().get
		// String s = StandardCharsets.UTF_8.decode(buffer).toString();
		// System.out.println(s);
		// }
		// });
		 final CountDownLatch latch = new CountDownLatch(1);
		httpClient.newRequest("https://www.mkyong.com/").onResponseHeaders(response -> {
			HttpFields headers = response.getHeaders();
			for (String name : headers.getFieldNamesCollection()) {
				for (String value : headers.getValuesList(name)) {
					// headers.add(name, value);
					System.out.println(name + "->" + value);
				}
			}
		}).send(new BufferingResponseListener() {

			@Override
			public void onComplete(Result result) {
				System.out.println("********************complete******************************");
				// TODO Auto-generated method stub
				String res = getContentAsString();
//				System.out.println(res);
				System.out.println(Thread.currentThread().getName());
				latch.countDown();
			}

		});

		System.out.println(Thread.currentThread().getName());
		latch.await();
		System.out.println("an example of http request");
		// httpClient.stop();
	}
}
