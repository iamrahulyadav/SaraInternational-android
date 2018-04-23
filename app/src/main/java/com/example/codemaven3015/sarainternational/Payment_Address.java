package com.example.codemaven3015.sarainternational;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Payment_Address extends AppCompatActivity {
Button continueBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment__address);
        continueBtn=findViewById(R.id.continueBtn);
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContinueBtn();
            }
        });
    }

    private void setContinueBtn() {
        Intent i = new Intent(Payment_Address.this,Payment_page.class);
        startActivity(i);
    }
}
