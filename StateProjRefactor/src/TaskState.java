public abstract class TaskState {
	protected static final TaskState TO_DO = new ToDo("TODO");
	protected static final TaskState IN_PROGRESS = new InProgress("IN_PROGRESS");
	protected static final TaskState IN_TEST = new InTest("IN_TEST");
	protected static final TaskState DONE = new Done("DONE");
	
    private final String name;

    public TaskState(String stateName) {
        this.name = stateName;
    }
    public void assigned(AgileTask task) {
      error();
    }

    public void moveToTest(AgileTask task) {
        error();
    }

    public void reOpen(AgileTask task) {
        error();
    }

    public void done(AgileTask task) {
        error();
    }

    private void error() {
        throw new IllegalStateException("Cannot make the transition from current state");
    }
}