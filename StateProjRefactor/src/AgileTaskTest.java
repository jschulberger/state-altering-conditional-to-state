import org.junit.Rule;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

public class AgileTaskTest {

private AgileTask myTask;
	
	@BeforeEach
	public void renewMyTask() {
		this.myTask = new AgileTask();
	}
	
	//-----------------------------------------------
    // To Do
    @Test
    public void fromToDoAssigned() throws Exception {
    	this.myTask.setState(TaskState.TO_DO);
    	this.myTask.assigned();
    	assertEquals(this.myTask.getState(), TaskState.IN_PROGRESS);
    }
    
    @Test
    public void fromToDoMoveToTest() throws Exception {
    	this.myTask.setState(TaskState.TO_DO);
    	IllegalStateException isexep = assertThrows(IllegalStateException.class, () -> {
        	this.myTask.moveToTest();
        });
        assertEquals("Cannot make the transition from current state", isexep.getMessage());
    }
    
    @Test
    public void fromToDoReOpen() throws Exception {
    	this.myTask.setState(TaskState.TO_DO);
    	IllegalStateException isexep = assertThrows(IllegalStateException.class, () -> {
        	this.myTask.reOpen();
        });
        assertEquals("Cannot make the transition from current state", isexep.getMessage());
    }
    
    @Test
    public void fromToDoDone() throws Exception {
    	this.myTask.setState(TaskState.TO_DO);
    	IllegalStateException isexep = assertThrows(IllegalStateException.class, () -> {
        	this.myTask.done();
        });
        assertEquals("Cannot make the transition from current state", isexep.getMessage());
    }
    
    //-----------------------------------------------
    // In Progress
    @Test
    public void fromInProgressAssigned() throws Exception {
    	this.myTask.setState(TaskState.IN_PROGRESS);
    	this.myTask.assigned();
    	assertEquals(this.myTask.getState(), TaskState.IN_PROGRESS);
    }
    
    @Test
    public void fromInProgressMoveToTest() throws Exception {
    	this.myTask.setState(TaskState.IN_PROGRESS);
    	this.myTask.moveToTest();
    	assertEquals(this.myTask.getState(), TaskState.IN_TEST);
    }
    
    @Test
    public void fromInProgressReOpen() throws Exception {
    	this.myTask.setState(TaskState.IN_PROGRESS);
    	IllegalStateException isexep = assertThrows(IllegalStateException.class, () -> {
        	this.myTask.reOpen();
        });
        assertEquals("Cannot make the transition from current state", isexep.getMessage());
    }
    
    @Test
    public void fromInProgressDone() throws Exception {
    	this.myTask.setState(TaskState.IN_PROGRESS);
    	this.myTask.done();
    	assertEquals(this.myTask.getState(), TaskState.DONE);
    }
    
    //-----------------------------------------------
    // In Test
    @Test
    public void fromInTestAssigned() throws Exception {
    	this.myTask.setState(TaskState.IN_TEST);
    	IllegalStateException isexep = assertThrows(IllegalStateException.class, () -> {
    		this.myTask.assigned();
        });
        assertEquals("Cannot make the transition from current state", isexep.getMessage());
    }
    
    @Test
    public void fromInTestMoveToTest() throws Exception {
    	this.myTask.setState(TaskState.IN_TEST);
    	IllegalStateException isexep = assertThrows(IllegalStateException.class, () -> {
    		this.myTask.moveToTest();
        });
    	assertEquals("Cannot make the transition from current state", isexep.getMessage());
    }
    
    @Test
    public void fromInTestReOpen() throws Exception {
    	this.myTask.setState(TaskState.IN_TEST);
    	IllegalStateException isexep = assertThrows(IllegalStateException.class, () -> {
    		this.myTask.reOpen();
        });
    	assertEquals("Cannot make the transition from current state", isexep.getMessage());
    }
    
    @Test
    public void fromInTestDone() throws Exception {
    	this.myTask.setState(TaskState.IN_TEST);
    	this.myTask.done();
    	assertEquals(this.myTask.getState(), TaskState.DONE);
    }
    
    //-----------------------------------------------
    // Done
    @Test
    public void fromDoneAssigned() throws Exception {
    	this.myTask.setState(TaskState.DONE);
    	IllegalStateException isexep = assertThrows(IllegalStateException.class, () -> {
    		this.myTask.assigned();
        });
        assertEquals("Cannot make the transition from current state", isexep.getMessage());
    }
    
    @Test
    public void fromDoneMoveToTest() throws Exception {
    	this.myTask.setState(TaskState.DONE);
    	IllegalStateException isexep = assertThrows(IllegalStateException.class, () -> {
    		this.myTask.moveToTest();
        });
    	assertEquals("Cannot make the transition from current state", isexep.getMessage());
    }
    
    @Test
    public void fromDoneReOpen() throws Exception {
    	this.myTask.setState(TaskState.DONE);
    	this.myTask.reOpen();
        assertEquals(this.myTask.getState(), TaskState.TO_DO);
    }
    
    @Test
    public void fromDoneDone() throws Exception {
    	this.myTask.setState(TaskState.DONE);
    	IllegalStateException isexep = assertThrows(IllegalStateException.class, () -> {
    		this.myTask.done();
        });
    	assertEquals("Cannot make the transition from current state", isexep.getMessage());
    }
}