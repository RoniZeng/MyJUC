/**
 * synchronized�ؼ���
 * ��ĳ���������
 * @author 16114
 *
 */

class Solution {
	private int count = 10;
	public void m() {
		synchronized(this) {
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