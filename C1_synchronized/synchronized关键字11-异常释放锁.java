import java.util.concurrent.TimeUnit;

/**
* ������ִ�й����У���������쳣��Ĭ��������ᱻ�ͷ�
 * ���ԣ��ڲ�������Ĺ����У����쳣Ҫ���С�ģ���Ȼ���ܻᷢ����һ�µ������
 * ���磬��һ��web app��������У����servlet�̹߳�ͬ����ͬһ����Դ����ʱ����쳣�������ʣ�
 * �ڵ�һ���߳����׳��쳣�������߳̾ͻ����ͬ�����������п��ܻ���ʵ��쳣����ʱ�����ݡ�
 * ���Ҫ�ǳ�С�ĵĴ���ͬ��ҵ���߼��е��쳣
 */
public class Solution{
	int count = 0;
	synchronized void m() {
		System.out.println(Thread.currentThread().getName()+" start");
		while(true) {
			count++;
			System.out.println(Thread.currentThread().getName() + " count = " + count);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(count == 5) {
			//�˴��׳��쳣,�������ͷ�,Ҫ�벻���ͷţ��������������catch����ѭ������
				int i = 1 / 0;
				System.out.println(i);
			}
		}
	}
	public static void main(String[] args) {
		Solution t = new Solution();
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				t.m();
			}
		};
		new Thread(r,"t1").start();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(r,"t2").start();
	}
}

/*
t1 start
t1 count = 1
t1 count = 2
t1 count = 3
t1 count = 4
t1 count = 5
t2 start
t2 count = 6
Exception in thread "t1" java.lang.ArithmeticException: / by zero
	at Solution.m(Solution.java:25)
	at Solution$1.run(Solution.java:36)
	at java.lang.Thread.run(Thread.java:748)
t2 count = 7
t2 count = 8
...
*/