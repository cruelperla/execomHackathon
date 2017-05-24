package com.rza.exhackathonapp.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rza.exhackathonapp.R;
import com.rza.exhackathonapp.model.Item;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class AddNewItemActivity extends AppCompatActivity {
    ImageView imageViewImport;
    ImageView imageViewShowPic;
    ImageView imageViewRaiseCamera;
    EditText editName;
    EditText editDesc;
    EditText editPrice;
    private static final int REQUEST_CODE_IMPORT = 1;
    private static final int REQUEST_CODE_CAMERA = 2;
    Bitmap bitmap;
    Button btnAdd;
    Uri selectedImage;
    String photoUrl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_item);
        imageViewImport = (ImageView) findViewById(R.id.importPic);
        imageViewShowPic = (ImageView) findViewById(R.id.showPic);
        imageViewRaiseCamera = (ImageView) findViewById(R.id.openCamera);
        btnAdd = (Button) findViewById(R.id.itemAddButton);
        editDesc = (EditText) findViewById(R.id.item_desc);
        editName = (EditText) findViewById(R.id.item_name);
        editPrice = (EditText) findViewById(R.id.item_price);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Item item = new Item(editName.getText().toString(), editDesc.getText().toString(),
                      photoUrl, Double.parseDouble(editPrice.getText().toString()), "email");
                item.save();
                */
                Toast.makeText(AddNewItemActivity.this, "Ovde ide logika za dodavanje novog itema", Toast.LENGTH_SHORT).show();
            }
        });

        imageViewImport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, REQUEST_CODE_IMPORT);
            }
        });

        imageViewRaiseCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePicture.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePicture, REQUEST_CODE_CAMERA);
                }
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_IMPORT && resultCode == RESULT_OK && data != null) {
            selectedImage = data.getData();
            Log.i("image", selectedImage.toString());

            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                imageViewShowPic.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        else if (requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            bitmap = (Bitmap) extras.get("data");
            photoUrl = extras.get("data").toString();
            imageViewShowPic.setImageBitmap(bitmap);

        }

    }



}
