package com.example.sami.calculatorpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import org.mariuszgromada.math.mxparser.Expression;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView mMainDisplay;
    boolean mIsEqualPressed = false;

    Button mEqualButton;
    Button mZeroButton;
    Button mDeleteButton;
    Button mPercentageButton;

    List<Button> mButtonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonList = new ArrayList<Button>();

//        TODO failed attempt, try it later
//        List<String> _numberButtonIdList = new ArrayList<String>();
//        for(int i=0; i<=9; i++)
//        {
//            _numberButtonIdList.add("B0" + i);
//            String _id = "R.id.B0" + i;
//
//            mButtonList.add(findViewById(_id));
//        }

        // initialize mButtonList
        findGenericButtons();
        // set click listener for generic buttons
        setGenericButtonsClickListener();
        // set click listener for other buttons
        findOtherButtons();

        mEqualButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        // do something
                        Expression _expression = new Expression(mMainDisplay.getText().toString());
                        mMainDisplay.setText(String.valueOf(_expression.calculate()));
                        mIsEqualPressed = true;
                    }
                }
        );

        mZeroButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        mMainDisplay.setText("");
                    }
                }
        );

        mDeleteButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        String _text = mMainDisplay.getText().toString();
                        _text = _text.substring(0, _text.length() - 1);
                        mMainDisplay.setText(_text);
                    }
                }
        );

        mPercentageButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent _intent = new Intent(MainActivity.this, AbirViaErActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("Mayesha", "jhogra");
                        _intent.putExtras(bundle);
                        startActivity(_intent);
                    }
                }
        );
    }

    private void findOtherButtons() {
        mMainDisplay = (TextView) findViewById(R.id.mainDisplay);
        mEqualButton =  (Button) findViewById(R.id.BEqual);
        mZeroButton = (Button) findViewById(R.id.BCE);
        mDeleteButton = (Button) findViewById(R.id.BDel);
        mPercentageButton = (Button) findViewById(R.id.BPercentage);
    }

    private void setGenericButtonsClickListener() {
        for (Button _button : mButtonList) {
            _button.setOnClickListener(new customEventListener());
        }
    }

    private void findGenericButtons() {
        mButtonList.add((Button) findViewById(R.id.B00));
        mButtonList.add((Button) findViewById(R.id.B01));
        mButtonList.add((Button) findViewById(R.id.B02));
        mButtonList.add((Button) findViewById(R.id.B03));
        mButtonList.add((Button) findViewById(R.id.B04));
        mButtonList.add((Button) findViewById(R.id.B05));
        mButtonList.add((Button) findViewById(R.id.B06));
        mButtonList.add((Button) findViewById(R.id.B07));
        mButtonList.add((Button) findViewById(R.id.B08));
        mButtonList.add((Button) findViewById(R.id.B09));
        mButtonList.add((Button) findViewById(R.id.BDot));

        mButtonList.add((Button) findViewById(R.id.BPlus));
        mButtonList.add((Button) findViewById(R.id.BMinus));
        mButtonList.add((Button) findViewById(R.id.BMultiply));
        mButtonList.add((Button) findViewById(R.id.BDivide));
    }

    class customEventListener implements Button.OnClickListener {
        @Override
        public void onClick(View view) {
            Button _clickedButton = (Button) view;
            if (mIsEqualPressed) {
                mMainDisplay.setText("");
                mIsEqualPressed = false;
            }
            mMainDisplay.setText(
                    mMainDisplay.getText().toString() + _clickedButton.getText().toString());
        }
    }
}



