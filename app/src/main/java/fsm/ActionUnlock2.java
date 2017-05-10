package fsm;



public class ActionUnlock2 implements Action {

    @Override
    public Car transition(Car startState) {
        if (startState.getCurrentState().equalsIgnoreCase("AlarmDisarmed_DriverUnlock")){}
        else
            startState.setCurrentState("AlarmDisarmed_AllUnlock");
        return startState;
    }

}
