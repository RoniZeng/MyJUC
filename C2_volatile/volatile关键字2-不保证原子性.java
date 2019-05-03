import java.util.ArrayList;
import java.util.List;
/*
 * volatile�����ܱ�֤����̹߳�ͬ�޸�running����ʱ�������Ĳ�һ�����⣬Ҳ����˵volatile�������synchronized
 * ��������ĳ��򣬲��������

*/
public class Solution{
	volatile int count = 0;
	void m() {
		for(int i = 0; i < 10000; i++) count++;
	}
	public static void main(String[] args) {
		Solution t = new Solution();
		List<Thread> threads = new ArrayList<Thread>();
		for (int i = 0; i < 10; i++) {
			threads.add(new Thread(t::m,"thread-" + i));
		}
		threads.forEach((o)->o.start());
		threads.forEach((o)->{
			try {
				o.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		System.out.println(t.count);
	}
}
