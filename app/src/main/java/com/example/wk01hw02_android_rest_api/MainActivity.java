package com.example.wk01hw02_android_rest_api;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    private TextView textViewResult;
    private EditText uEditText;
    private EditText pEditText;

    List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        textViewResult = findViewById(R.id.text_view_result1);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<User>> call = jsonPlaceHolderApi.getUsers();

        call.enqueue(new Callback<List<User>>(){
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response){
                if(!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                List<User> users = response.body();
                for(User user : users){
                    String content = "";
                    content += "User ID: " + user.getUserId() + "\n";
                    content += "Username: " + user.getUsername() + "\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t){
                textViewResult.setText(t.getMessage());
            }
        });
        */
        users = new ArrayList<User>();
        User user1 = new User(1, "Bob", "secret1");
        User user2 = new User(2, "Joe", "secret2");
        User user3 = new User(3, "Jen", "secret3");
        users.add(user1);
        users.add(user2);
        users.add(user3);

        View loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(this);

    }

//    // Factory method to get an Intent and switch to Landing Page
//    public void nextActivity(View view){
//        Intent intent = LandingPage.getIntent(getApplicationContext(), "Hello" );
//        startActivity(intent);
//    }


    public void onClick(View v){
        if(v.getId() == R.id.login_button){
            textViewResult = findViewById(R.id.text_view_result1);
            textViewResult.setText("");
            pEditText = findViewById(R.id.cinput_password);
            uEditText = findViewById(R.id.cinput_username);
            pEditText.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_ATOP);
            uEditText.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_ATOP);

            EditText cinput;
            String inputUsername;
            String inputPassword;
            boolean usernameError = true;
            boolean passwordError = false;

            cinput = findViewById(R.id.cinput_username);
            inputUsername = cinput.getText().toString();
            cinput = findViewById(R.id.cinput_password);
            inputPassword = cinput.getText().toString();
            for (User user : users) {
                if (inputUsername.equals(user.getUsername())) {
                    usernameError = false;
                    if(inputPassword.equals(user.getPassword())) {
                        Intent i = new Intent(this, LandingPage.class);
                        Bundle userIdUsername = new Bundle();
                        userIdUsername.putInt("userId", user.getUserId());
                        userIdUsername.putString("username", user.getUsername());
                        i.putExtras(userIdUsername);
                        startActivity(i);
                    }
                    else{
                       //Error if password wrong
                        textViewResult.setText("Error! Incorrect Password.");
                        passwordError = true;
                        pEditText.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                    }
                }
            }
            if(!passwordError && usernameError) {
                // Error if username not found
                textViewResult.setText("Error! Username not found.");
                uEditText.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
            }
        }
    }
}