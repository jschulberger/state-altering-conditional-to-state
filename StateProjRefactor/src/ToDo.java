public class ToDo extends TaskState {

  public ToDo(String todo) {
      super(todo);
  }
  
  @Override
  public void assigned(AgileTask task) {
      task.setState(TaskState.IN_PROGRESS);
  }
}