package com.example.codemaven3015.sarainternational;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Successfully_OrderPlaced extends AppCompatActivity {

    TextView viewDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successfully__order_placed);
        viewDetails=findViewById(R.id.viewDetails);
        viewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setviewDetails();
            }
        });
    }

    private void setviewDetails()
    {
        Intent i = new Intent(Successfully_OrderPlaced.this,My_Order_Details.class);
        startActivity(i);
    }
}
