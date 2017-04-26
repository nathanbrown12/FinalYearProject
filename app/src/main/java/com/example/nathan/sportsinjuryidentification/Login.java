package com.example.nathan.sportsinjuryidentification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button btnSignIn;
    TextView btnSignUp;
    LoginDataBaseAdapter loginDataBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // create a instance of SQLite Database
        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();

        // Get The Refference Of Buttons
        btnSignIn = (Button) findViewById(R.id.buttonSignIN);
        btnSignUp = (TextView) findViewById(R.id.buttonCreateAccount);


        // get the Refferences of views
        final EditText editTextUserName = (EditText) findViewById(R.id.editTextUserNameToLogin);
        final EditText editTextPassword = (EditText) findViewById(R.id.editTextPasswordToLogin);

        // Set OnClick Listener on SignIn button
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub

                // get The User name and Password
                String userName = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();

                // fetch the Password form database for respective user name
                String storedPassword = loginDataBaseAdapter.getSinlgeEntry(userName);

                // check if the Stored password matches with Password entered by user
                if (password.equals(storedPassword)) {
                    Toast.makeText(Login.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    intent.putExtra("fullname", userName);
                    startActivity(intent);
                } else {
                    Toast.makeText(Login.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
        /* Set OnClick Listener on SignUp button
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /// Create Intent for SignUpActivity abd Start The Activity
                Intent intentSignUP = new Intent(MainActivity.this,signUP.class);
                startActivity(intentSignUP);
            }
        });
        */

    public void signIn(View view)
    {
        Intent intentSignUP = new Intent(Login.this,signUP.class);
        startActivity(intentSignUP);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close The Database
        loginDataBaseAdapter.close();
    }
}