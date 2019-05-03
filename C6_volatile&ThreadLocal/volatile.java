import java.security.acl.Permission;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 ThreadLocal�ֲ߳̾�����
*/
public class Solution{
	volatile static Person p = new Person();
	
	public static void main(String[] args) {
		new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(p.name);
		}).start();
		
		new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			p.name = "lisi"; //volatile�Թ�����Դ�пɼ��ԣ��޸ĳɹ�
		}).start();
		
	}
}

class Person{
	String name = "zhangsan";
}
//lisi
