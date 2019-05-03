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
 * 
 * 
 * ʹ��reentrantlock���Խ��С�����������tryLock��
 * �����޷�������������ָ��ʱ�����޷��������߳̿��Ծ����Ƿ�����ȴ�
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
	
	/**
	 * ʹ��tryLock���г�������������������񣬷�����������ִ��
	 * ���Ը���tryLock�ķ���ֵ���ж��Ƿ�����
	 * Ҳ����ָ��tryLock��ʱ�䣬
	 * ����tryLock(time)�׳��쳣��
	 * ����Ҫע��unclock�Ĵ�������ŵ�finally��
	 */
	void m2() {
		boolean locked = false;
		try {
			locked = lock.tryLock(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if(locked)
				lock.unlock();
		}
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
0
1
2
3
4
5
6
7
8
9
*/