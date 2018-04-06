public class InProgress extends TaskState {
    public InProgress(String in_progress) {
        super(in_progress);
    }
    
    @Override
    public void assigned(AgileTask task) {
        task.setState(TaskState.IN_PROGRESS);
    }
    
    @Override
    public void moveToTest(AgileTask task) {
        task.setState(TaskState.IN_TEST);
    }
    
    @Override
    public void done(AgileTask task) {
        task.setState(TaskState.DONE);
    }
}