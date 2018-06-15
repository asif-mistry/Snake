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

    Button soundButton;
    RadioButton soundOnButton;
    RadioButton soundOffButton;

    Boolean isSoundEnabled = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        m_Control = AppConstants.Control.DUAL;
        newGameButton = (Button) findViewById(R.id.newGameButton);
        controlButton = (Button) findViewById(R.id.controlButton);
        povButton = (RadioButton) findViewById(R.id.povRadio);
        dualButton = (RadioButton) findViewById(R.id.dualRadio);

        soundButton = (Button) findViewById(com.asif.snake.R.id.soundButton);
        soundOnButton = (RadioButton) findViewById(com.asif.snake.R.id.soundOnRadio);
        soundOffButton = (RadioButton) findViewById(com.asif.snake.R.id.soundOffRadio);

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


        soundButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                soundButtonClicked();
            }
        });
        soundOnButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                soundOnRadioClicked();
            }
        });
        soundOffButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                soundOffRadioClicked();
            }
        });
        soundOnButton.toggle();
    }


    public void newGameButtonClicked()
    {
//        Intent myIntent = new Intent(CurrentActivity.this, NextActivity.class);
//        myIntent.putExtra("key", value); //Optional parameters
//        CurrentActivity.this.startActivity(myIntent);

        Intent myIntent = new Intent(SettingActivity.this, SnakeActivity.class);
        myIntent.putExtra(AppConstants.CONTROL_KEY,m_Control);
        myIntent.putExtra(com.asif.snake.AppConstants.SOUND_KEY,isSoundEnabled);
        SettingActivity.this.startActivity(myIntent);
    }


    //region control
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
    //endregion


    //region control
    public void soundButtonClicked()
    {
        if(isSoundEnabled == false)
        {
            soundOnRadioClicked();
        }
        else
        {
            soundOffRadioClicked();
        }

    }


    public void soundOnRadioClicked()
    {
        isSoundEnabled = true;
        soundOnButton.setChecked(true);
        soundOffButton.setChecked(false);
    }


    public void soundOffRadioClicked()
    {
        isSoundEnabled = false;
        soundOffButton.setChecked(true);
        soundOnButton.setChecked(false);
    }
    //endregion
}
