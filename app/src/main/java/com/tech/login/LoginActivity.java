package com.tech.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    EditText edtUsername;
    EditText edtPassword;

   private static final String SHARED_PREF_NAME = "pref";
   private static final String SHARED_USER_NAME = "name";
   private static final String SHARED_PASS = "pass";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);


      SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
      String name = sharedPreferences.getString(SHARED_USER_NAME,null);
//
//      if (name!=null){
//          startActivity(new Intent(LoginActivity.this,MainActivity.class));
//          finish();
//      }


      btnLogin.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
          if (!(edtUsername == null) && !(edtPassword == null)){
              SharedPreferences.Editor editor = sharedPreferences.edit();
              editor.putString(SHARED_USER_NAME,edtUsername.getText().toString());
              editor.putString(SHARED_PASS,edtPassword.getText().toString());
              editor.apply();
              startActivity(new Intent(LoginActivity.this,MainActivity.class));
              finish();
          }else{
              Toast.makeText(LoginActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
          }
          }
      });





    }
}