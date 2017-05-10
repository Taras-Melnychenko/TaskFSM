package fsm;



public class Car {
    private String currentState;

    public Car(){
        this.currentState = currentState;
    }

    public String getCurrentState(){
        return currentState;
    }

    public void setCurrentState(String currentState){
        this.currentState = currentState;
    }

    @Override
    public String toString() {
        return currentState;

    }
}
