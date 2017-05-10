package fsm;


public class ActionLock implements Action {


    @Override
    public Car transition(Car startState) {
        if (startState.getCurrentState().equalsIgnoreCase("AlarmArmed_AllLock")){}
        else{
            startState.setCurrentState("AlarmDisarmed_AllLocked");
        }
           return startState;
    }
}
