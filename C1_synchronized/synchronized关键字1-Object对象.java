/**
 * synchronized�ؼ���
 * ��ĳ���������
 * @author 16114
 *
 */

class Solution {
	private int count = 10;
	private Object o = new Object();
	public void m() {
		synchronized(o) {
			count--;
			System.out.println(Thread.currentThread().getName()
					+ " count = " + count);
		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.m();
	}
	//main count = 9
}