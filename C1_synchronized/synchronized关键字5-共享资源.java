/**
 * synchronized�ؼ���
 * ��ĳ���������
 * @author 16114
 *
 */

class Solution implements Runnable{
	private  int count = 10;
	public static void main(String[] args) {
		Solution t = new Solution();
		for (int i = 0; i < 10; i++) {
			new Thread(t,"Thread" + i).start();
		}
	}
	@Override
	public /*synchronized*/ void run() {
		count--;
		System.out.println(Thread.currentThread().getName()
				+ " count1 = " + count);
	}
}