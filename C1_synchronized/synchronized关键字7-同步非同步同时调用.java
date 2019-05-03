/**
  * ͬ���ͷ�ͬ�������Ƿ����ͬʱ���ã�
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
���Կ���t1��ִ�У��������ͬʱ������ôt2�ǲ���ִ�еģ�
�����t1�������ͷ�������ܵ��ã�������t2ȷ��ִ���ˣ������ǿ���ͬʱ���õġ�
ͬһ����Դ��ͬ���ͷ�ͬ���ķ�������ͬʱ����
*/