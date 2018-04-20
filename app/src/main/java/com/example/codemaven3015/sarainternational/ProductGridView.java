package com.example.codemaven3015.sarainternational;

/**
 * Created by Admin on 3/14/2018.
 */import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ProductGridView extends BaseAdapter {

    private final String fromWhere;
    private Context mContext;
    private final String[] gridViewString;
    private final int[] gridViewImageId;

    public ProductGridView(Context context, String[] gridViewString, int[] gridViewImageId,String fromWhere) {
        mContext = context;
        this.gridViewImageId = gridViewImageId;
        this.gridViewString = gridViewString;
        this.fromWhere = fromWhere;
    }


    @Override
    public int getCount() {
        return gridViewString.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View gridViewAndroid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            gridViewAndroid = new View(mContext);
            gridViewAndroid = inflater.inflate(R.layout.grid_layout, null);
           Button textViewAndroid = (Button) gridViewAndroid.findViewById(R.id.grid_btn);
           ImageView imageViewAndroid = (ImageView) gridViewAndroid.findViewById(R.id.grid_img);
           RelativeLayout relative_productDetails=gridViewAndroid.findViewById(R.id.relative_productDetails);
            textViewAndroid.setText(gridViewString[i]);
            imageViewAndroid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(fromWhere.equals("Product")){
                        Intent intent=new Intent(mContext,ProductCategorieDetails.class);
                        mContext.startActivity(intent);
                    }else{
                        Intent intent=new Intent(mContext,Customize_Product.class);
                        mContext.startActivity(intent);
                    }

                }
            });
            imageViewAndroid.setBackgroundResource(gridViewImageId[i]);
            if(fromWhere.equals("Product")){
                relative_productDetails.setVisibility(View.GONE);
            }else{
                relative_productDetails.setVisibility(View.VISIBLE);
            }

        } else {
            gridViewAndroid = (View) convertView;
        }

        return gridViewAndroid;
    }
}