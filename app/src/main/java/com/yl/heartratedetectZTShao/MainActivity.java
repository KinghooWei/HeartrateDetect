package com.yl.heartratedetectZTShao;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView backGround;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button faceDetect = (Button) findViewById(R.id.face_detect);
       // backGround = (ImageView)findViewById(R.id.imageView);
       // backGround.setOnClickListener(this);
        faceDetect.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.face_detect:
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.CAMERA}, 1);
                } else {
                    startActivity(new Intent(this, DetectActivity.class));
                }
                break;
           // case R.id.imageView:
              //  if(backGround.getVisibility()==View.VISIBLE) backGround.setVisibility(View.INVISIBLE);
              //  else backGround.setVisibility(View.VISIBLE);
            default:
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    startActivity(new Intent(this, DetectActivity.class));
                }
                else {
                    Toast.makeText(this, "?????????????????????", Toast.LENGTH_SHORT).show();
                }
        }
    }
}
