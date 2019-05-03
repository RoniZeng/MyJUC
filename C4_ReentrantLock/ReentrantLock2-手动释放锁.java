import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * reentrantlock�������synchronized
 * ����������m1����this,ֻ��m1ִ����ϵ�ʱ��,m2����ִ��
 * �����Ǹ�ϰsynchronized��ԭʼ������
 * 
 * 
 * 
 * ʹ��reentrantlock�������ͬ���Ĺ���
 * ��Ҫע����ǣ�����Ҫ����Ҫ����Ҫ�ֶ��ͷ�������Ҫ������˵���飩
 * ʹ��syn�����Ļ���������쳣��jvm���Զ��ͷ�����
 * ����lock�����ֶ��ͷ���,��˾�����finally�н��������ͷ�
*/
public class Solution {
	Lock lock = new ReentrantLock();
	
	void m1() {
		lock.lock();
		try {
			for(int i=0; i<10; i++) {
				TimeUnit.SECONDS.sleep(1);
				System.out.println(i);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	void m2() {
		lock.lock();
		System.out.println("m2...");
		lock.unlock();
	}
	
	public static void main(String[] args) {
		Solution r1 = new Solution();
		new Thread(r1::m1).start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(r1::m2).start();
	}
	
}

/*
m2...
*/