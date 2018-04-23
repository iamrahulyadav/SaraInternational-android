package com.example.codemaven3015.sarainternational;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Payment_page extends AppCompatActivity {
Button payNowBtn;
TextView changeAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_page);
        changeAddress=findViewById(R.id.changeAddress);
        changeAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setchangeAddress();
            }
        });
        payNowBtn=findViewById(R.id.payNowBtn);
        payNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setpayNowBtn();
            }
        });
    }

    private void setchangeAddress()
    {
        Intent i = new Intent(Payment_page.this,AddressList.class);
        startActivity(i);
    }

    private void setpayNowBtn()
    {
        Intent i = new Intent(Payment_page.this,Successfully_OrderPlaced.class);
        startActivity(i);
    }
}
