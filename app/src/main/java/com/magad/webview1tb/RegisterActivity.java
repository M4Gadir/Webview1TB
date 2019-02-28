package com.magad.webview1tb;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    TextInputEditText emet, uset, fnet, lnet, pset, retps, phnet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emet = findViewById(R.id.emailet);
        uset = findViewById(R.id.useret);
        fnet = findViewById(R.id.Fnev);
        lnet = findViewById(R.id.Lnet);
        pset = findViewById(R.id.passet);
        retps = findViewById(R.id.retpasset);
        phnet = findViewById(R.id.phoneet);



    }

    public void btnsignup(View view) {
        if(fnet.getText().length() == 0){
            fnet.setError("entah ana gak tau apa apa");
        }
        if(lnet.getText().length() == 0){
            lnet.setError("entah ana gak tau apa apa");
        }
        if(uset.getText().length() == 0){
            uset.setError("entah ana gak tau apa apa");
        }
        if(emet.getText().length() == 0){
            emet.setError("entah ana gak tau apa apa");
        }
        if(phnet.getText().length() == 0){
            phnet.setError("entah ana gak tau apa apa");
        }
        if(pset.getText().length() == 0){
            pset.setError("entah ana gak tau apa apa");
        }
        if(retps.getText().length() == 0){
            retps.setError("entah ana gak tau apa apa");
        }
        if(fnet.getText().toString().trim().length() != 0 &&
        lnet.getText().toString().trim().length() != 0 &&
        uset.getText().toString().trim().length() != 0 &&
        emet.getText().toString().trim().length() != 0 &&
        phnet.getText().toString().trim().length() != 0 &&
        pset.getText().toString().trim().length() != 0 &&
        retps.getText().toString().trim().length() != 0){
            startActivity(new Intent(this,HomeActivity.class)
                    .putExtra("user", uset.getText().toString())
            .putExtra("phone", phnet.getText().toString())
            .putExtra("email", emet.getText().toString()));
        }

    }
}
