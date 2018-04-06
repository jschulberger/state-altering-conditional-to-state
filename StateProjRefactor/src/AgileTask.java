public class AgileTask {
    private TaskState state;
    public AgileTask() {
        this.state = TaskState.TO_DO;
    }
    
    public void assigned() {
        state.assigned(this);
    }
    
    public void moveToTest() {
        state.moveToTest(this);
    }
    
    public void reOpen(){
        state.reOpen(this);
    }
    
    public void done(){
       state.done(this);
    }
    
    public TaskState getState() {
        return state;
    }
    
    public void setState(TaskState state) {
        this.state = state;
    }
}