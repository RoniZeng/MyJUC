import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/*
 * synchronized�Ż�
 * ͬ��������е����Խ��Խ��
 * �Ƚ�m1��m2
*/
public class Solution{
	int count = 0;
	
	synchronized void m1() {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		count++;
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	void m2() {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//ҵ���߼���ֻ�����������Ҫsync����ʱ��Ӧ�ø�������������
		//����ϸ���ȵ���������ʹ�߳�����ʱ���̣��Ӷ����Ч��
		synchronized (this) {
			count++;
		}
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
