package com.aasa.android.mygatetestapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.aasa.android.mygatetestapp.model.ItemDetails;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<ItemDetails> itemList;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    Bitmap imageBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemList = new ArrayList<>();
        setData();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        adapter = new UserAdapter(itemList, MainActivity.this, new OnButtonClick() {
            @Override
            public void onButtonClickListner(UserAdapter.MyViewHolder myViewHolder, int position) {
                dispatchTakePictureIntent();
                myViewHolder.image.setImageBitmap(imageBitmap);
            }

        });
        recyclerView.setAdapter(adapter);


    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
             imageBitmap = (Bitmap) extras.get("data");
//            mImageView.setImageBitmap(imageBitmap);
        }
    }

    public void setData(){
        ItemDetails itemDetails = new ItemDetails();
        itemDetails.setName("Amrita");
        itemDetails.setPasscode(343);
        itemList.add(itemDetails);

        itemDetails.setName("Amrita");
        itemDetails.setPasscode(343);
        itemList.add(itemDetails);

        itemDetails.setName("Amrita");
        itemDetails.setPasscode(343);
        itemList.add(itemDetails);

        itemDetails.setName("Amrita");
        itemDetails.setPasscode(343);
        itemList.add(itemDetails);
    }
}
