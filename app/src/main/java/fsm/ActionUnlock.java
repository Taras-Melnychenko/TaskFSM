package fsm;



public class ActionUnlock implements Action {

    @Override
    public Car transition(Car startState) {
        if (startState.getCurrentState().equalsIgnoreCase("AlarmDisarmed_AllUnlock")){}
        else
            startState.setCurrentState("AlarmDisarmed_DriverUnlock");
        return startState;
    }

}
