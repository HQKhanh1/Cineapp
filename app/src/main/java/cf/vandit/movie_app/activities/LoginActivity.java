package cf.vandit.movie_app.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cf.vandit.movie_app.R;
import cf.vandit.movie_app.retrofit.RetrofitService;
import cf.vandit.movie_app.retrofit.request.LoginRequest;
import cf.vandit.movie_app.retrofit.response.LoginResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setControl();
        setEvent();
        TextView btn=findViewById(R.id.textViewSignUp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }

    private void setEvent() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(LoginActivity.this, "Username / Password Required", Toast.LENGTH_LONG);
                }else {
                    //process to login
                    login();
                }
            }
        });
    }

    public void login(){
        LoginRequest loginRequest= new LoginRequest();
        loginRequest.setUsername(username.getText().toString());
        loginRequest.setPassword(password.getText().toString());

        Call<LoginResponse> loginResponseCall= RetrofitService.getAccountService().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                System.out.println("response.body() = " + response.body().getUsername());
                if(response.isSuccessful() && response.body().getUsername() != null){

                    Toast.makeText(LoginActivity.this,"Login Successful", Toast.LENGTH_LONG).show();
                    LoginResponse loginResponse= response.body();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(loginResponse);
                            Intent intent= new Intent(LoginActivity.this, MainActivity.class);
                            Bundle bundle= new Bundle();
                            bundle.putString("username",loginResponse.getUsername());
                            bundle.putString("password",loginResponse.getPassword());
                            bundle.putString("firstname",loginResponse.getFirstname());
                            bundle.putString("lastname",loginResponse.getLastname());
                            bundle.putString("email",loginResponse.getEmail());
                            bundle.putString("birthday",loginResponse.getBirthday());
                            bundle.putBoolean("gender", loginResponse.isGender());
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    }, 700);
                }else {
                    Toast.makeText(LoginActivity.this,"Login Failed", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"Throwable "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setControl() {
        btnLogin= findViewById(R.id.btnlogin);
        username= findViewById(R.id.inputUsername);
        password= findViewById(R.id.inputPassword);
    }
}