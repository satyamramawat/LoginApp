package a4mca.loginapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class User extends AppCompatActivity {
ImageButton signOut,instaButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        signOut =(ImageButton)findViewById(R.id.signOut);//ON-OFF SWITCH BUTTON
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(User.this, "I Hope U liked it !! ", 50000).show(); //Toast.LENGTH_LONG //
                finish();
            }
        });

        instaButton=(ImageButton)findViewById(R.id.instaButton);
        instaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewIntent = new Intent("android.intent.action.VIEW",Uri.parse("http://www.instagram.com/satyam3001"));
                startActivity(viewIntent);
            }
        });

    }
}
