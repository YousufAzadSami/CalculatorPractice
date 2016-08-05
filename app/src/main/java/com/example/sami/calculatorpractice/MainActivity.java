package com.example.sami.calculatorpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView mMainDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainDisplay = (TextView)findViewById(R.id.mainDisplay);
        List<Button> _numberButtonList = new ArrayList<Button>();

        // TODO faild attempt, try it later
//        List<String> _numberButtonIdList = new ArrayList<String>();
//        for(int i=0; i<=9; i++)
//        {
//            _numberButtonIdList.add("B0" + i);
//            String _id = "R.id.B0" + i;
//
//            _numberButtonList.add(findViewById(_id));
//        }
        _numberButtonList.add((Button) findViewById(R.id.B00));
        _numberButtonList.add((Button) findViewById(R.id.B01));
        _numberButtonList.add((Button) findViewById(R.id.B02));
        _numberButtonList.add((Button) findViewById(R.id.B03));
        _numberButtonList.add((Button) findViewById(R.id.B04));
        _numberButtonList.add((Button) findViewById(R.id.B05));
        _numberButtonList.add((Button) findViewById(R.id.B06));
        _numberButtonList.add((Button) findViewById(R.id.B07));
        _numberButtonList.add((Button) findViewById(R.id.B08));
        _numberButtonList.add((Button) findViewById(R.id.B09));

        _numberButtonList.add((Button) findViewById(R.id.BPlus));
        _numberButtonList.add((Button) findViewById(R.id.BMinus));
        _numberButtonList.add((Button) findViewById(R.id.BMultiply));
        _numberButtonList.add((Button) findViewById(R.id.BDivide));

        for (Button _button : _numberButtonList) {
            _button.setOnClickListener(new customEventListener(mMainDisplay));
        }
    }
}

class customEventListener implements OnClickListener {

    TextView mTextView;

    customEventListener(TextView inTextView){
        mTextView = inTextView;
    }
    @Override
    public void onClick(View view) {
        Button _clickedButton = (Button)view;
        mTextView.setText(mTextView.getText().toString() + _clickedButton.getText().toString());
    }
}

