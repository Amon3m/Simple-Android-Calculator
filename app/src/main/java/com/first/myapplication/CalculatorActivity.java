package com.first.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import	java.lang.Math;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {
    TextView resultview;
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        resultview=findViewById(R.id.result_tv);

       }

    int equl_clicked=0;
    String operator="";
    String result="";

    public void onClickAC(View view){
     operator="";
     result="";
    resultview.setText("");
}

    public void onOpclick(View view){
        Button OpClick = ((Button) view);
        if (operator.isEmpty()){
            operator=OpClick.getText().toString();
            result=resultview.getText().toString();
             resultview.setText("");
        }
        else{
            String RHS=resultview.getText().toString();
            result=claculate(RHS,operator,result);
            operator=OpClick.getText().toString();
            resultview.setText("");
        }
    }

    public void onClickEqual(View view){
        if (operator.equals("")){
            resultview.setText(result);
            result="";
        }
        else{
            String RHS=resultview.getText().toString();
            result=claculate(RHS,operator,result);
            resultview.setText(result);
            result="";
            operator="";
        }

    }
    public void dotOnClick(View view){
        if (resultview.getText().toString().contains(".")){

            return;

        }
        else resultview.append(".");

    }


    private String claculate(String rhs, String operator, String LHS) {
        double resulte=0.0;
        equl_clicked=1;
        try {


        if (rhs.equals("")){
            double n2 = Double.parseDouble(LHS);
            if (operator.equals("√")){
                resulte = Math.sqrt(n2);
            }
            else if (operator.equals("SIN")){
                resulte = Math.sin(n2);
            }
            else if (operator.equals("COS")){
                resulte = Math.cos(n2);
            }
            else if(operator.equals("-")){
                    resulte = -n2;
            }
            else if(operator.equals("+")){
                resulte = n2;
            }
        }

        else if (LHS.equals("")){
            double n2 = Double.parseDouble(rhs);
            if (operator.equals("√")){
                resulte = Math.sqrt(n2);
            }
            else if (operator.equals("SIN")){
                resulte = Math.sin(n2);
            }
            else if (operator.equals("COS")){
                resulte = Math.cos(n2);
            }
            else if (operator.equals("-")){
                resulte = -n2;
        }
            else if(operator.equals("+")){
                resulte = n2;
            }
        }
        else {
        double n1 = Double.parseDouble(LHS);
        double n2 = Double.parseDouble(rhs);

            if (operator.equals("+") ) {
                resulte = n1 + n2;
            } else if (operator.equals("-") ) {
                resulte = n1 - n2;
            } else if (operator.equals("x") ) {
               resulte = n1 * n2;
            } else if (operator.equals("/") ) {
                if (n2==0.0){
                    Toast.makeText(CalculatorActivity.this, "can't divid by Zero", Toast.LENGTH_SHORT).show();
                }

                 resulte = n1 / n2;
            }
        }}catch (NumberFormatException exception){
            operator="";
        }

        return resulte+"";
    }


        public void onDigitClick(View view){
        if (equl_clicked==1)
        {
            resultview.setText("");
            equl_clicked=0;
        }

        Button clickedbtn=(Button)view;
        resultview.append(clickedbtn.getText().toString());

    }
}
