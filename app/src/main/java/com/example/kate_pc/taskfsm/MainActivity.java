package com.example.kate_pc.taskfsm;

import android.view.View;
import android.view.View.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import fsm.Action;
import fsm.ActionLock;
import fsm.ActionLock2;
import fsm.ActionUnlock;
import fsm.ActionUnlock2;
import fsm.Car;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    private Car startState = new Car();
    private Action aLock = new ActionLock();
    private Action aLock2 = new ActionLock2();
    private Action aUnlock = new ActionUnlock();
    private Action aUnlock2 = new ActionUnlock2();
    private TextView textView;
    private Button lock;
    private Button lock2;
    private Button unLock;
    private Button unLock2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialization our startState, i decided take the point when our car are closed with armed
        //alarm
        startState.setCurrentState("AlarmArmed_AllLock");
        textView = (TextView) findViewById(R.id.textView1);
        textView.setText(startState.getCurrentState());
        textView.setBackgroundResource(R.color.tvBackgroundG);
        //init buttons
        lock = (Button) findViewById(R.id.button5);
        lock2 = (Button) findViewById(R.id.button7);
        unLock = (Button) findViewById(R.id.button8);
        unLock2 = (Button) findViewById(R.id.button9);

        //treatment clicking

        lock.setOnClickListener(this);
        lock2.setOnClickListener(this);
        unLock.setOnClickListener(this);
        unLock2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {//in each case we have a logic to change our textview
        switch (v.getId()){
            case R.id.button5:
                if(aLock.transition(startState).toString().
                        equalsIgnoreCase("AlarmArmed_AllLock")){}
                else{
                    startState.setCurrentState(aLock.transition(startState).toString());
                    textView.setText(startState.getCurrentState());
                    textView.setBackgroundResource(R.color.tvBackgroundR);
                }//AlarmDisarmed_AllLocked
                break;
            case R.id.button7:
                    startState.setCurrentState(aLock2.transition(startState).toString());
                    textView.setText(startState.getCurrentState());
                    textView.setBackgroundResource(R.color.tvBackgroundG);
                break;//AlarmArmed_AllLock
            case R.id.button8:
                if(aUnlock.transition(startState).toString().
                        equalsIgnoreCase("AlarmDisarmed_AllUnlock")){}
                else {
                    startState.setCurrentState(aUnlock.transition(startState).toString());
                    textView.setText(startState.getCurrentState());
                    textView.setBackgroundResource(R.color.tvBackgroundR);
                }
                break;//AlarmDisarmed_DriverUnlock
            case R.id.button9:
                if(aUnlock2.transition(startState).toString().
                        equalsIgnoreCase("AlarmDisarmed_DriverUnlock")){}
                else {
                    startState.setCurrentState(aUnlock2.transition(startState).toString());
                    textView.setText(startState.getCurrentState());
                    textView.setBackgroundResource(R.color.tvBackgroundR);
                }
                break;//AlarmDisarmed_AllUnlock
        }
    }

}
