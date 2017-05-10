package fsm;

public class ActionLock2 implements Action {

    @Override
    public Car transition(Car startState) {
            startState.setCurrentState("AlarmArmed_AllLock");
            return startState;
    }
}
