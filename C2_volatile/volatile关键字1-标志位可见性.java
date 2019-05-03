import java.util.concurrent.TimeUnit;
/*

*/
public class Solution{
	volatile boolean running = true;
	void m() {
		System.out.println("m start");
		while(running) {
			try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("m end!");
	}
	public static void main(String[] args) {
		Solution t = new Solution();
		new Thread(t::m,"t1").start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t.running = false;
	}
}
