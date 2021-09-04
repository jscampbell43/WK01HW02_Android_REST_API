package com.example.wk01hw02_android_rest_api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LandingPage extends AppCompatActivity {
    //public static final String ACTIVITY_LABEL = "SECOND_ACTIVITY_COM_EXAMPLE";

    private TextView textViewResult;
    int passedUserId = 0;
    String passedUsername = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        Bundle userIdUsername = getIntent().getExtras();

        if(userIdUsername != null){
            passedUserId = userIdUsername.getInt("userId");
            passedUsername = userIdUsername.getString("username");
        }

        textViewResult = findViewById(R.id.text_view_result);
        String content = "Welcome ";
        content += passedUsername + "!\n";
        content += "Your User Id is: " + passedUserId + "\n\n";
        textViewResult.append(content);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Post>>(){
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response){
                if(!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                List<Post> posts = response.body();
                for(Post post : posts){
                    if(post.getUserId() == passedUserId) {
                        String content = "";
                        content += "ID: " + post.getId() + "\n";
                        content += "User ID: " + post.getUserId() + "\n";
                        content += "Title: " + post.getTitle() + "\n";
                        content += "Text: " + post.getText() + "\n\n";

                        textViewResult.append(content);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t){
                textViewResult.setText(t.getMessage());
            }
        });
    }

    // Factory method to get an Intent and switch to Landing Page
    public static Intent nextActivity(Context context){
        Intent intent = new Intent(context, LandingPage.class);
        return intent;
    }
}