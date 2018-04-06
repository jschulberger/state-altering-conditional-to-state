
public class InTest extends TaskState {
	public InTest(String in_test) {
        super(in_test);
    }
	
	@Override
	public void done(AgileTask task) {
        task.setState(DONE);
    }
}
