/**
  * 同步和非同步方法是否可以同时调用？
 * @author 16114
 *
 */

class Solution{


	public synchronized void m1() {
		System.out.println(Thread.currentThread().getName() + "m1 start...");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "m1 end!");
	}
	
	public /*synchronized*/ void m2() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " m2");
	}
	
	public static void main(String[] args) {
		Solution t = new Solution();
		new Thread(()->t.m1(),"t1 ").start();
		new Thread(()->t.m2(),"t2 ").start();
	}
}
/**
t1 m1 start...
t2  m2
t1 m1 end!
 */

/*
可以看到t1先执行，如果不能同时调用那么t2是不能执行的，
必须等t1结束，释放锁后才能调用，但这里t2确先执行了，所以是可以同时调用的。
同一个资源，同步和非同步的方法可以同时调用
*/