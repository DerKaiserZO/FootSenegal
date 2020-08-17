package com.example.footsenegal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.footsenegal.models.equipe;
import com.example.footsenegal.models.user;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    private EditText mUsername;
    private EditText mPassword;
    private Button   mLoginBtn;
    ApiInterface apiInterface;
    private static final String TAG = "Connexion";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mUsername = findViewById(R.id.user_name);
        mPassword = findViewById(R.id.user_pass);

        mLoginBtn = findViewById(R.id.btn_login);

        Retrofit retrofit = ApiClient.getClient();

        apiInterface = retrofit.create(ApiInterface.class);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Call<com.example.footsenegal.models.status> call = apiInterface.getConnexion(mUsername.getText().toString(), mPassword.getText().toString());
                    call.enqueue(new Callback<com.example.footsenegal.models.status>() {
                        @Override
                        public void onResponse(Call<com.example.footsenegal.models.status> call, Response<com.example.footsenegal.models.status> response) {
                            String result = response.body().getStatus();
                            Log.d(TAG, "result " + result);
                            if (result.contentEquals("OK")){
                                Intent i = new Intent(LoginActivity.this, AdminActivity.class);
                                startActivity(i);
                            }else {
                                Toast.makeText(LoginActivity.this, "LOGIN OU MOT DE PASSE INCORRECT",Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<com.example.footsenegal.models.status> call, Throwable t) {
                            Log.d(TAG, "onFailure " + t.getLocalizedMessage());
                        }

                    });
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
