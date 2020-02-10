package com.example.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText input1;
    EditText input2;

    Button addition;
    Button subtraction;
    Button multiplication;
    Button division;


    TextView tvResult;

    String oper = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = (EditText) findViewById(R.id.etNum1);
        input2 = (EditText) findViewById(R.id.etNum2);


        addition = (Button) findViewById(R.id.btnAdd);
        subtraction = (Button) findViewById(R.id.btnSub);
        multiplication = (Button) findViewById(R.id.btnMult);
        division = (Button) findViewById(R.id.btnDiv);


        tvResult = (TextView) findViewById(R.id.tvResult);

    }
    public void getData(){
        Intent intent = new Intent();
    }

    public void onClick(View v) {
        float num1 = 0;
        float num2 = 0;
        float result = 0;

        // check if the fields are empty
        if (TextUtils.isEmpty(input1.getText().toString()) || TextUtils.isEmpty(input2.getText().toString())) {
            return;
        }
        num1 = Float.parseFloat(input1.getText().toString());
        num2 = Float.parseFloat(input2.getText().toString());


        switch (v.getId()) {
            case R.id.btnAdd:
                oper = "+";
                result = num1 + num2;
                break;


            case R.id.btnSub:
                oper = "-";
                result = num1 - num2;
                break;

            case R.id.btnMult:
                oper = "*";
                result = num1 * num2;
                break;

            case R.id.btnDiv:
                oper = "/";
                result = num1 / num2;
                if(num1 == 1 && num2 == 0 || num1 == 0 && num2 == 1){
                    Context context = getApplicationContext();
                    CharSequence text = "DIVISION NOT POSSIBLE!!";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context,text,duration);
                    toast.show();
                    toast.setGravity(Gravity.BOTTOM | Gravity.CENTER,1,1);
                }
                break;
            default:
                break;

        }
        tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
    }

}
