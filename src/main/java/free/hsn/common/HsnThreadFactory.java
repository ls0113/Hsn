package free.hsn.common;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class HsnThreadFactory {
	
	public static ThreadFactory buildChannelSelectorFactory() {
		return new ChannelSelectorFactory();
	}

	/**
	 * 用于ChannelSelector使用的线程工厂类
	 */
	private static class ChannelSelectorFactory implements ThreadFactory {
		
		private static final String mark = "ChannelSelector-";
		
		private final AtomicInteger id = new AtomicInteger(0);

		@Override
		public Thread newThread(Runnable runnable) {
			Thread thread = new Thread(runnable);
			thread.setDaemon(true);
			thread.setPriority(Thread.MAX_PRIORITY);
			thread.setName(mark + id.incrementAndGet());
			
			return thread;
		}
	}
}