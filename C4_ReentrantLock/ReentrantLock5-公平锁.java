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
 * 
 * 
 * ʹ��ReentrantLock�����Ե���lockInterruptibly���������Զ��߳�interrupt����������Ӧ��
 * ��һ���̵߳ȴ����Ĺ����У����Ա����
 * 
 * 
 * ReentrantLock������ָ��Ϊ��ƽ��
*/
public class Solution extends Thread{
	private static ReentrantLock lock = 
			new ReentrantLock(true); //����Ϊtrue��ʾΪ��ƽ������Ա�������
	public void run() {
        for(int i=0; i<10; i++) {
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+"�����");
            }finally{
                lock.unlock();
            }
        }
    }
	public static void main(String[] args) {
		Solution r1 = new Solution();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r1);
		t1.start();
		t2.start();
	}
}

/*
Thread-1�����
Thread-1�����
Thread-1�����
Thread-1�����
Thread-1�����
Thread-1�����
Thread-1�����
Thread-1�����
Thread-1�����
Thread-1�����
Thread-2�����
Thread-2�����
Thread-2�����
Thread-2�����
Thread-2�����
Thread-2�����
Thread-2�����
Thread-2�����
Thread-2�����
Thread-2�����
*/