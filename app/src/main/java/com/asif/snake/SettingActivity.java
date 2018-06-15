package com.asif.snake;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class SettingActivity extends Activity {


    //Control
    private AppConstants.Control m_Control = AppConstants.Control.DUAL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        final Button newGameButton = (Button) findViewById(R.id.newGameButton);
        newGameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                newGameButtonClicked();
            }
        });


        final Button controlButton = (Button) findViewById(R.id.controlButton);
        controlButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                controlButtonClicked();
            }
        });

        final RadioButton povButton = (RadioButton) findViewById(R.id.povRadio);
        povButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                povControlRadioClicked();
            }
        });



        final RadioButton dualButton = (RadioButton) findViewById(R.id.dualRadio);
        dualButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dualControlRadioClicked();
            }
        });


    }


    public void newGameButtonClicked()
    {
//        Intent myIntent = new Intent(CurrentActivity.this, NextActivity.class);
//        myIntent.putExtra("key", value); //Optional parameters
//        CurrentActivity.this.startActivity(myIntent);

        Intent myIntent = new Intent(SettingActivity.this, SnakeActivity.class);
        myIntent.putExtra(AppConstants.CONTROL_KEY,m_Control);
        SettingActivity.this.startActivity(myIntent);
    }


    public void controlButtonClicked()
    {
        if(m_Control == AppConstants.Control.DUAL)
        {
            m_Control = AppConstants.Control.POV;
        }
        else
        {
            m_Control = AppConstants.Control.DUAL;
        }

    }


    public void povControlRadioClicked()
    {
        m_Control = AppConstants.Control.POV;

    }


    public void dualControlRadioClicked()
    {
        m_Control = AppConstants.Control.DUAL;

    }

}
