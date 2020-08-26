package com.example.itocheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.itocheck.databinding.ActivityLoginBinding;

public class Login extends AppCompatActivity {
    private ActivityLoginBinding mBinding;
    private int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               checkPass(mBinding.etPass.getText().toString());
                Toast.makeText(Login.this, "Llevas "+count+" Intentos. Con mas de 3 no podras entrar", Toast.LENGTH_SHORT).show();
                if (count>3) mBinding.btLogin.setVisibility(View.INVISIBLE);
            }
        });

        mBinding.btCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });

    }

 public void checkPass (String pass){
       if (pass.equals("123Pass") && count <4 )
        next();
        count++;
 }

 public void next(){
             Intent intent = new Intent(Login.this, MainActivity.class);
                count=0;
             startActivity(intent);
         }
}