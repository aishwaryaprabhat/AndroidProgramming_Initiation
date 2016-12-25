package sutd.apptravel;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import java.net.URI;
import java.util.jar.Manifest;

public class Vlog extends AppCompatActivity {
    private int ACTIVITY_START_CAMERA_APP = 0;
    VideoView watchvid;
    private final static int REQUEST_TO_READ_STORAGE = 1;
    private Uri uri;
    Button sharebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vlog);
        Button recordvideo = (Button) findViewById(R.id.Vlogbutton);
        Button playvideo = (Button) findViewById(R.id.PlayButton);
        sharebutton = (Button)findViewById(R.id.sharebutton);
        watchvid = (VideoView) findViewById(R.id.videoView);



        recordvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callvideoapp = new Intent();
                callvideoapp.setAction(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(callvideoapp, ACTIVITY_START_CAMERA_APP);

            }
        });

        playvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                watchvid.start();

            }
        });


    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode==ACTIVITY_START_CAMERA_APP && resultCode == RESULT_OK){
            uri = data.getData();
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)
                        == PackageManager.PERMISSION_GRANTED){
                    watchvid.setVideoURI(uri);
                }else{
                    if(shouldShowRequestPermissionRationale(android.Manifest.permission.READ_EXTERNAL_STORAGE)){
                        Toast.makeText(this, "Need access to play video", Toast.LENGTH_SHORT).show();
                    }requestPermissions(new String[] {android.Manifest.permission.READ_EXTERNAL_STORAGE},REQUEST_TO_READ_STORAGE);
                }
            }else{watchvid.setVideoURI(uri);}

        }
        sharebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("video/mp4");
                sharingIntent.putExtra(Intent.EXTRA_STREAM, uri);
                startActivity(Intent.createChooser(sharingIntent, "Share vlog using"));

            }
        });
    }

}
