package com.example.com.flashlight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FeedBack_Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameEditText,messegeEditText;
    private Button sentButton,clearButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back_);
        nameEditText=findViewById(R.id.nameedittxet_id);
        messegeEditText=findViewById(R.id.messageedittxet_id);
        sentButton=findViewById(R.id.sent_id);
        clearButton=findViewById(R.id.clear_id);


        sentButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Override
    public void onClick(View v) {

        try {

            String name=nameEditText.getText().toString();
            String message =messegeEditText.getText().toString();


            if (v.getId()==R.id.sent_id){

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("Text/email");

                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"sajony9191@gmail.com","jony94755094@gmail.com"});

                intent.putExtra(Intent.EXTRA_SUBJECT,"Feedback From apps");
                intent.putExtra(Intent.EXTRA_TEXT,"Name :"+ name +"Message :"+ message);
                startActivity(Intent.createChooser(intent,"Feedback with"));


                Toast.makeText(getApplicationContext(), "sent button is working", Toast.LENGTH_SHORT).show();

            }
            if (v.getId()==R.id.clear_id){

                nameEditText.setText("");
                messegeEditText.setText("");

            }


        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Exception :" +e, Toast.LENGTH_SHORT).show();

        }

    }
}
/*
<resources>
<string name="app_name">Multiple Apps</string>

<string-array name="apps_name">

<item>Facebook</item>
<item>WhatsApp</item>
<item>Messenger</item>
<item>Twitter</item>
<item>YouTube</item>
<item>Skype</item>
<item>Viber</item>
<item>imo beta</item>
<item>imo HD</item>
<item>Instagram</item>
<item>TikTok</item>
<item>Likee</item>
<item>Snapchat</item>
<item>SHAREit</item>



<item>Messenger Lite</item>
<item>Facebook Lite</item>
<item>Twitter Lite</item>
<item>Skype Lite</item>
<item>Instagram Lite</item>
<item>Likee Lite</item>
<item>TikTok Lite</item>
<item>Gmail</item>





</string-array>

<string name="jont_text">

        Assalamualaikum.\n\nMy Name is Md.Samiul Alim Jony.My Hometown is chapai-Nawabganj,Rajshahi,Bagnladesh.
        \n\nThis app any objection so you can inform myself. Go Menu option Then click Feedback Option then type your name
        and Message Then Click sent Button.

        Thanks for using this Apps.\n\n

        Allah Hafiz..\n\n

        ℙ𝕠𝕨𝕖𝕣 𝔹𝕪 𝕭𝛼𝖇𝖚𝖑𝖌𝛼𝖒

</string>
</resources>
*/
