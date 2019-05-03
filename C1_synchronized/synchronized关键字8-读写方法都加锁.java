import java.util.concurrent.TimeUnit;

/**
 * 对业务写方法加锁
 * 对业务读方法不加锁
 * 容易产生脏读问题（dirtyRead）
 */

class Solution{
	String name;
	double balance;
	public synchronized void set(String name, double balance) {
		this.name = name;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.balance = balance;
	}
	public /*synchronized*/ double getBalance(String name) {
		return this.balance;
	}
	public static void main(String[] args) {
		Solution t = new Solution();
		new Thread(()->t.set("zrl", 100.0)).start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t.getBalance("zrl"));
		try {
			TimeUnit.SECONDS.sleep(2); //不加锁的话必须》set的休眠时间2s，加锁则不用
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t.getBalance("zrl"));
	}
}
