package com.gameschoolcode.passwordproject;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,View.OnFocusChangeListener{
    private EditText userNameEdt;
    private EditText passwordEdt;
    private Button sendBtn;
    private Button restBtn;
    private TextView informationTxt;

    private String userName;
    private String password;
    private String information;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //myCode
        init();
        setListeners();
    }

    void init(){
        userNameEdt=(EditText)findViewById(R.id.userNameId);
        passwordEdt=(EditText) findViewById(R.id.passwordId);
        sendBtn=(Button)findViewById(R.id.sendId);
        restBtn=(Button)findViewById(R.id.resetId) ;
        informationTxt=(TextView)findViewById(R.id.informationId);
    }

   private void setListeners(){
        sendBtn.setOnClickListener(this);
        restBtn.setOnClickListener(this);
        userNameEdt.setOnFocusChangeListener(this);
        passwordEdt.setOnFocusChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sendId:
                handleSend();
                break;
            case R.id.resetId:
                handleReset();
                break;
        }

    }
        private void handleSend(){
            userName=userNameEdt.getText().toString();
            password=passwordEdt.getText().toString();
            if(!(userName.isEmpty() || password.isEmpty())){
                information=String.format("Welcome %s ,%n Your password is %s ,Happy Day",userName,password);
                informationTxt.setText(information);
                passwordEdt.setBackgroundColor(Color.parseColor("#FFFFFF"));
                informationTxt.setBackgroundColor(Color.parseColor("#FFF5F779"));
                sendBtn.setClickable(false);
            }
        }

        private void handleReset(){
            userNameEdt.setText("");
            passwordEdt.setText("");
            informationTxt.setText("");
            userNameEdt.setBackgroundColor(Color.WHITE);
            passwordEdt.setBackgroundColor(Color.WHITE);
            informationTxt.setBackgroundColor(Color.WHITE);
            sendBtn.setClickable(true);
        }
    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        switch (view.getId())
        {
            case R.id.userNameId:
                handleUserName(hasFocus);
                break;
            case R.id.passwordId:
                handlePassWord(hasFocus);
                break;
        }
    }
    //handleUserName
    private void handleUserName(boolean hasFocus){
        if(hasFocus)
            userNameEdt.setBackgroundColor(Color.parseColor("#FFABD1FA"));
        else
            userNameEdt.setBackgroundColor(Color.parseColor("#FFFFFF"));
    }

    //handlePassword field
    private void handlePassWord(boolean hasFocus){
        if(hasFocus)
            passwordEdt.setBackgroundColor(Color.parseColor("#FFF48495"));
        else
            passwordEdt.setBackgroundColor(Color.parseColor("#FFFFFF"));
    }

}
