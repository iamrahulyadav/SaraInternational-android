package com.example.codemaven3015.sarainternational;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AddressList extends AppCompatActivity {
    RecyclerView recyclerView;
    private RecyclerView.LayoutManager rvLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.address_recycler_view);
        rvLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rvLayoutManager);
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing);
        recyclerView.addItemDecoration(new SpacesItemDecoration(spacingInPixels,"Address"));
        AddressAdapter addressAdapter = new AddressAdapter(this);
        recyclerView.setAdapter(addressAdapter);

    }


    public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {
        private Context context;
        int currentSelectedPosition = -1;
        boolean flagHide = false;


        public AddressAdapter(Context context) {
            this.context = context;
        }

        private String[] address = {"Chapter One",
                "Chapter Two",
                "Chapter Three",
                "Chapter Four",
                "Chapter Five",
        };


        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView address_textView;
            public RadioButton radioButton;
            public RelativeLayout relativeLayout;

            public ViewHolder(View itemView) {
                super(itemView);
                address_textView = (TextView) itemView.findViewById(R.id.address1);
                radioButton = itemView.findViewById(R.id.radioButton);
                relativeLayout = itemView.findViewById(R.id.relativeLayout);
                relativeLayout.setVisibility(View.GONE);
                radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        final int position = getAdapterPosition();
                        if(isChecked){
                            currentSelectedPosition = position;
                            notifyDataSetChanged();
                            flagHide = true;
                        }else{
                            currentSelectedPosition = position;
                            notifyDataSetChanged();
                            flagHide = false;
                        }
                    }
                });

            }
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.address_cart, null, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            viewHolder.address_textView.setText(address[i]);
            if(currentSelectedPosition == i){
                if(flagHide) {
                    viewHolder.relativeLayout.setVisibility(View.VISIBLE);
                    currentSelectedPosition = -1;
                    flagHide = false;
                }
                else {
                    viewHolder.relativeLayout.setVisibility(View.GONE);
                }
            }

        }
        @Override
        public int getItemCount() {
            return address.length;
        }
    }

}
