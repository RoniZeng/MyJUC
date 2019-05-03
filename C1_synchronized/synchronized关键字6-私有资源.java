/**
 * synchronized关键字
 * 对某个对象加锁
 * @author 16114
 *
 */

class Solution implements Runnable{
	private  int count = 10;
	@Override
	public synchronized void run() {
		count--;
		System.out.println(Thread.currentThread().getName() + " count = " + count);
	}
	public static void main(String[] args) {
		
		for (int i = 0; i < 5; i++) {
			Solution t = new Solution();
			new Thread(t,"Thread" + i).start();
		}
	}
}
/*
Thread0 count = 9
Thread1 count = 9
Thread2 count = 9
Thread3 count = 9
Thread4 count = 9
*/