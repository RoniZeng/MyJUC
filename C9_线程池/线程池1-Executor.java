import java.util.concurrent.Executor;

/**
 * ÈÏÊ¶Executor
*/
public class Solution implements Executor{

	public static void main(String[] args) {
		new Solution().execute(() -> System.out.println("hello executor"));
	}
	
	@Override
	public void execute(Runnable command) {
		command.run();
	}
	
}

