package com.aishwaryaprabhat.cam_aish;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class MainActivity extends Activity {
    public static final int ACTIVITY_START_CAMERA_APP = 0;
    private ImageView mPhotoCapturedImageView;
    private String mImageFileLocation;
    File photoFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPhotoCapturedImageView = (ImageView)findViewById(R.id.imageView);
    }

    protected void takePhoto(View v){
        Intent callCameraAppIntent = new Intent();
        callCameraAppIntent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);


        try {
            photoFile = createImageFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Uri uri  = Uri.parse("file:///sdcard/photo.jpg");

        callCameraAppIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult(callCameraAppIntent,ACTIVITY_START_CAMERA_APP);
    }
    protected void onActivityResult (int reqcode, int intresultcode, Intent data){
        if(reqcode==ACTIVITY_START_CAMERA_APP && intresultcode == RESULT_OK){
//            Toast.makeText(this, "Yay!",Toast.LENGTH_SHORT).show();
//            Bundle extras = data.getExtras();
//            Bitmap photo = (Bitmap)extras.get("data");

            Bitmap photocapturedbitmap = BitmapFactory.decodeFile(mImageFileLocation);
            mPhotoCapturedImageView.setImageBitmap(photocapturedbitmap);
        }

    }
    File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHssMM").format(new Date());
        System.out.println(timeStamp);
        String imagefilename = "IMAGE"+timeStamp;
        File storageDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imagefilename,".jpg",storageDirectory);
        mImageFileLocation = image.getAbsolutePath();
        System.out.println(image.toString());
        return image;

    }



}
