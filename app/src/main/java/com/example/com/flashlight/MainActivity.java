package com.example.com.flashlight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButton;
    private Camera camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toggleButton=findViewById(R.id.toggleButton_id);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked)
                {
                    toggleButton.setBackgroundResource(R.drawable.ic_flashlight_icon);

                    camera= Camera.open();
                    Camera.Parameters parameters=camera.getParameters();
                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    camera.setParameters(parameters);
                    camera.startPreview();
                    Toast.makeText(MainActivity.this, "Flash is On", Toast.LENGTH_SHORT).show();


                }else
                {
                    toggleButton.setBackgroundResource(R.drawable.off);
                    camera.stopPreview();
                    camera.release();
                    Toast.makeText(MainActivity.this, "Flash is off", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()==R.id.share_id){
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String subject="Share This Apps";
            String body="This is very Useful to Android Phone.This is a Flash Light Apps.\n com.example.com.flashlight";

            intent.putExtra(Intent.EXTRA_SUBJECT,subject);
            intent.putExtra(Intent.EXTRA_TEXT,body);

            startActivity(Intent.createChooser(intent,"Share with"));

        }
        else

        if (item.getItemId()==R.id.feedback_id)
        {

            Intent intent=new Intent(getApplicationContext(),FeedBack_Activity.class);
            startActivity(intent);



        }

        else

        if (item.getItemId()==R.id.AboutUs_id)
        {

            Intent intent=new Intent(getApplicationContext(),AboutActivity.class);
            startActivity(intent);



        }




        return super.onOptionsItemSelected(item);


    }

}
