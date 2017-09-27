package a4mca.loginapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private static EditText username;
    private static EditText password;
    private static TextView attempt;
    private static ImageButton login_button,byeButton;
    int attempt_counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_button = (ImageButton) findViewById(R.id.button_login);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginButton();
            }
        });


        byeButton = (ImageButton) findViewById(R.id.byeButton);
        byeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Login.this,"See you again !!",Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }

    public void LoginButton(){
        username = (EditText)findViewById(R.id.editText_user);
        password = (EditText)findViewById(R.id.editText_password);
        attempt = (TextView)findViewById(R.id.textView_attempt);

        attempt.setText(Integer.toString(attempt_counter));

        if (username.getText().toString().equals("satyam") &&
                password.getText().toString().equals("admin"))
        {
            Toast.makeText(Login.this,"Username and password is correct",Toast.LENGTH_SHORT).show();
           // Intent declaration
            final Intent intent=new Intent(Login.this,User.class);
         // SPINNER
            final ProgressDialog progress;
            progress = new ProgressDialog(this);
            progress.setTitle("Please wait");
            progress.setMessage("logging In");
            progress.setCancelable(true);
            progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progress.show();

           Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    startActivity(intent); // Starting Intent
                    progress.dismiss();
                }
            }, 1500);



        }
        else {
            Toast.makeText(Login.this,"Username and password is NOT correct",
                    Toast.LENGTH_SHORT).show();
            attempt_counter--;
            attempt.setText(Integer.toString(attempt_counter));
            if(attempt_counter==0)
                login_button.setEnabled(false);
        }


    }

}
