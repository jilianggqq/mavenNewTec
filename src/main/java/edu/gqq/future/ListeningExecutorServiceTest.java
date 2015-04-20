package edu.gqq.future;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import static java.lang.System.out;

public class ListeningExecutorServiceTest {
	public static void main(String[] args) {
		ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
		ListenableFuture<Explosion> explosion = service.submit(new Callable<Explosion>() {
			public Explosion call() {
				return pushBigRedButton();
			}

		});
		Futures.addCallback(explosion, new FutureCallback<Explosion>() {
			// we want this handler to run immediately after we push the big red
			// button!
			public void onSuccess(Explosion exp) {
				walkAwayFrom(exp);
			}

			public void onFailure(Throwable thrown) {
				battleArchNemesis(); // escaped the explosion!
			}

		});
	}

	private static void battleArchNemesis() {
		// TODO Auto-generated method stub
		out.println("Thread Name:" + Thread.currentThread().getName());
		out.println("battleArchNemesis");
	}

	private static void walkAwayFrom(Explosion explosion) {
		// TODO Auto-generated method stub
		out.println("Thread Name:" + Thread.currentThread().getName());
		out.println("walkAwayFrom");
		explosion.getResults().forEach(x -> out.println("result is " + x));
	}

	private static Explosion pushBigRedButton() {
		// TODO Auto-generated method stub
		out.println("Thread Name:" + Thread.currentThread().getName());
		out.println("Big Red Button is pushed.");
		// add some info to list
		Explosion ep = new Explosion();
		ep.addList();
		return ep;
	}

}
