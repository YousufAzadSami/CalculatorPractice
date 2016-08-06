package com.example.sami.calculatorpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


import org.mariuszgromada.math.mxparser.Expression;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView mMainDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainDisplay = (TextView) findViewById(R.id.mainDisplay);
        List<Button> buttonList = new ArrayList<Button>();

        // TODO faild attempt, try it later
//        List<String> _numberButtonIdList = new ArrayList<String>();
//        for(int i=0; i<=9; i++)
//        {
//            _numberButtonIdList.add("B0" + i);
//            String _id = "R.id.B0" + i;
//
//            buttonList.add(findViewById(_id));
//        }
        buttonList.add((Button) findViewById(R.id.B00));
        buttonList.add((Button) findViewById(R.id.B01));
        buttonList.add((Button) findViewById(R.id.B02));
        buttonList.add((Button) findViewById(R.id.B03));
        buttonList.add((Button) findViewById(R.id.B04));
        buttonList.add((Button) findViewById(R.id.B05));
        buttonList.add((Button) findViewById(R.id.B06));
        buttonList.add((Button) findViewById(R.id.B07));
        buttonList.add((Button) findViewById(R.id.B08));
        buttonList.add((Button) findViewById(R.id.B09));
        buttonList.add((Button) findViewById(R.id.BDot));

        buttonList.add((Button) findViewById(R.id.BPlus));
        buttonList.add((Button) findViewById(R.id.BMinus));
        buttonList.add((Button) findViewById(R.id.BMultiply));
        buttonList.add((Button) findViewById(R.id.BDivide));

        for (Button _button : buttonList) {
            _button.setOnClickListener(new customEventListener(mMainDisplay));
        }

        Button _equalButton = (Button) findViewById(R.id.BEqual);
        _equalButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        // do something
                        Expression _expression = new Expression(mMainDisplay.getText().toString());
                        mMainDisplay.setText(String.valueOf(_expression.calculate()));
                    }
                }
        );

        Button _zeroButton = (Button) findViewById(R.id.BCE);
        _zeroButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        mMainDisplay.setText("");
                    }
                }
        );

        Button _deleteButton = (Button) findViewById(R.id.BDel);
        _deleteButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        String _text = mMainDisplay.getText().toString();
                        _text = _text.substring(0, _text.length() - 1);
                        mMainDisplay.setText(_text);
                    }
                }
        );
    }
}

class customEventListener implements Button.OnClickListener {

    TextView mTextView;

    customEventListener(TextView inTextView) {
        mTextView = inTextView;
    }

    @Override
    public void onClick(View view) {
        Button _clickedButton = (Button) view;
        mTextView.setText(mTextView.getText().toString() + _clickedButton.getText().toString());
    }
}

