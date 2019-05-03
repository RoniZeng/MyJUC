import java.util.concurrent.TimeUnit;

/**
һ��ͬ���������Ե�������һ��ͬ��������һ���߳��Ѿ�ӵ��ĳ������������ٴ������ʱ����Ȼ��õ��ö������.
 * Ҳ����˵synchronized��õ����ǿ������
 * �����Ǽ̳����п��ܷ��������Σ�������ø����ͬ������
 */
public class Solution{
	synchronized void m() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("m end");
	}
	public static void main(String[] args) {
		new TT().m();
	}
}

class TT extends Solution{

	@Override
	synchronized void m() {
		System.out.println("child m start");
		super.m();
		System.out.println("child m end");
	}
	
}
/*
child m start
m end
child m end
*/