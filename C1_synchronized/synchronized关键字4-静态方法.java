/**
 * synchronized关键字
 * 对某个对象加锁
 * @author 16114
 *
 */

class Solution {
	private static int count = 10;
	
	//这里等同于synchronized(Solution.class)
	public synchronized static void m() {  
			count--;
			System.out.println(Thread.currentThread().getName()
					+ " count1 = " + count);
	}
	
	public static void mm() {
		//考虑一下这里写synchronized(this)是否可以？(不行)
		//static方法是类方法,先于任何的实例(对象)存在。即static方法在类加载时就已经存在了,
		//但是对象是在创建时才在内存中生成。而this指代的是当前的对象。
		synchronized (Solution.class) {
			count--;
			System.out.println(Thread.currentThread().getName()
					+ " count2 = " + count);
		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.m();
		solution.mm();
	}
	/**
	 * main count1 = 9
	   main count2 = 8
	 */
}