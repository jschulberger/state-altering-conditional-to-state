
public class AgileTask {
	private static final String TO_DO = "TO_DO";
    private static final String IN_PROGRESS = "IN_PROGRESS";
    private static final String IN_TEST = "IN_TEST";
    private static final String DONE = "DONE";
    private String state;

    public AgileTask() {
        this.state = TO_DO;
    }

    public void assigned() {
        if (state.equals(TO_DO) || state.equals(IN_PROGRESS)) {
            this.state = IN_PROGRESS;
            System.out.println("Task moved to " + IN_PROGRESS);
        }
        else {
            error();
        }
    }

    public void moveToTest(){
        if (state.equals(IN_PROGRESS)) {
            state = IN_TEST;
            System.out.println("Task moved to " + IN_TEST);
        }
        else {
            error();
        }
    }

    public void reOpen(){
        if (state.equals(DONE)) {
            state = TO_DO;
            System.out.println("Task has been reopened");
        }
        else {
            error();
        }
    }

    public void done(){
        if (state.equals(IN_PROGRESS) || state.equals(IN_TEST)) {
            state=DONE;
            System.out.println("Task has been completed");
        }
        else {
            error();
        }
    }

    private void error() {
        throw new IllegalStateException("Cannot make the transition from current state");
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state=state;
    }
}
