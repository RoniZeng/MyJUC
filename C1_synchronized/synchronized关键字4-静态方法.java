/**
 * synchronized�ؼ���
 * ��ĳ���������
 * @author 16114
 *
 */

class Solution {
	private static int count = 10;
	
	//�����ͬ��synchronized(Solution.class)
	public synchronized static void m() {  
			count--;
			System.out.println(Thread.currentThread().getName()
					+ " count1 = " + count);
	}
	
	public static void mm() {
		//����һ������дsynchronized(this)�Ƿ���ԣ�(����)
		//static�������෽��,�����κε�ʵ��(����)���ڡ���static�����������ʱ���Ѿ�������,
		//���Ƕ������ڴ���ʱ�����ڴ������ɡ���thisָ�����ǵ�ǰ�Ķ���
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