package org.apache.tomcat.dbcp.dbcp;

import java.util.Stack;

public class RecoverThread extends Thread {
	static RecoverThread instance;

	public synchronized static RecoverThread getInstance() {
		if (instance == null) {
			instance = new RecoverThread();
			instance.setName("RecoverThread");
			instance.setDaemon(true);
			instance.start();
		}
		return instance;
	}

	Stack<Runnable> queue = new Stack<Runnable>();

	public void add(Runnable r) {
		if (queue.size() < 100) {
			queue.add(r);
		}
	}

	@Override
	public void run() {
		while (true) {
			if (queue.size() == 0) {
				sleeping(2000);
			} else {
				try {
					Runnable r = queue.pop();
					if (r != null) {
						r.run();
					}
				} catch (Throwable t) {
				}
			}
		}
	}

	private static void sleeping(long tm) {
		try {
			Thread.sleep(tm);
		} catch (Exception e) {
		}
	}
}
