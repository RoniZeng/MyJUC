import java.util.concurrent.TimeUnit;

/**
 * * reentrantlock用于替代synchronized
 * 本例中由于m1锁定this,只有m1执行完毕的时候,m2才能执行
 * 这里是复习synchronized最原始的语义
*/
public class Solution {
	synchronized void m1() {
		for(int i = 0; i < 10; i++) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
	synchronized void m2() {
		System.out.println("m2...");
	}
	public static void main(String[] args) {
		Solution rl = new Solution();
		new Thread(rl::m1).start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(rl::m2).start();
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
m2...
*/