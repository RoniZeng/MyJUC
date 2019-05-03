import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/*
����ĳ����o�����o�����Է����ı䣬��Ӱ������ʹ��
 * �������o�������һ�������������Ķ������ı�
 * Ӧ�ñ��⽫������������ñ������Ķ���
*/
public class Solution{
	Object o = new Object();
	void m() {
		synchronized (o) {
			while (true) {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			}
		}
	}
	public static void main(String[] args) {
		Solution t = new Solution();
		//������һ���߳�
		new Thread(t::m,"t1").start();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//�����ڶ����߳�
		Thread t2 = new Thread(t::m,"t2");
		t.o = new Object();//���������ı䣬����t2�̵߳���ִ�У����ע�͵���仰���߳�2����Զ�ò���ִ�л���
		t2.start();
	}
}
