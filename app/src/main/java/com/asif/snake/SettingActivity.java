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
    private AppConstants.Control m_Control;
    Button newGameButton;
    Button controlButton;
    RadioButton povButton;
    RadioButton dualButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        m_Control = AppConstants.Control.DUAL;
        newGameButton = (Button) findViewById(R.id.newGameButton);
        controlButton = (Button) findViewById(R.id.controlButton);
        povButton = (RadioButton) findViewById(R.id.povRadio);
        dualButton = (RadioButton) findViewById(R.id.dualRadio);

        newGameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                newGameButtonClicked();
            }
        });


        controlButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                controlButtonClicked();
            }
        });

        povButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                povControlRadioClicked();
            }
        });



        dualButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dualControlRadioClicked();
            }
        });
        dualButton.toggle();


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
            povControlRadioClicked();
        }
        else
        {
            dualControlRadioClicked();
        }

    }


    public void povControlRadioClicked()
    {
        m_Control = AppConstants.Control.POV;
        povButton.setChecked(true);
        dualButton.setChecked(false);

    }


    public void dualControlRadioClicked()
    {
        m_Control = AppConstants.Control.DUAL;
        dualButton.setChecked(true);
        povButton.setChecked(false);

    }

}
