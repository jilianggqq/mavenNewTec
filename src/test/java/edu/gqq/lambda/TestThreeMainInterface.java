package edu.gqq.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.apache.log4j.Logger;

import edu.gqq.util.Log4jUtil;
import junit.framework.TestCase;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestThreeMainInterface extends TestCase {
	
	Logger logger = Log4jUtil.getLogger(TestThreeMainInterface.class);
	public void testConsume() {
		logger.debug("testConsume begins");
		//anonymous
		Consumer<String> consumer1 = new Consumer<String>() {

			@Override
			public void accept(String t) {
				logger.debug("consumer1:"+t);
			}
		};
		
		//lambda
		Consumer<String> consumer2 = x->logger.debug("consumer2:"+x);
		
		// traditional
		Consumer<Object> consumer3 = new ObjCls();
		
		//return (T t) -> { accept(t); after.accept(t); };
		//accept(t)调用它的是consumer1, 而after.appcept的类型是<? super T>，t的类型是T，所以可以向上转型。
		consumer1.andThen(consumer2).andThen(consumer3).accept("peter");
		
		//因为consumer3规定了T为object,所以除非consumer1是super object的，否则编译不能通过。
//		consumer3.andThen(consumer1);
		List<String> names = Arrays.asList("zhangsan","lisi","wangwu");
		
		names.forEach(consumer2);
		
		names.stream().mapToInt(x->x.length()).sorted().forEach(logger::info);
		
	}
	
	class ObjCls implements Consumer<Object>{

		@Override
		public void accept(Object t) {
			// TODO Auto-generated method stub
			logger.debug("consumer3:"+t);
		}
		
	}
}
