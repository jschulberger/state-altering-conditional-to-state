
public class Done extends TaskState {
	public Done(String done) {
        super(done);
    }
	
	@Override
	public void reOpen(AgileTask task) {
        task.setState(TaskState.TO_DO);
    }
}
