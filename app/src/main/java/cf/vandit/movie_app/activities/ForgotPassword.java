package cf.vandit.movie_app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cf.vandit.movie_app.R;
import retrofit2.Call;

public class ForgotPassword extends AppCompatActivity {
    EditText email;
    Button btnSendMail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btnSendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void setControl() {
        email= findViewById(R.id.inputEmail);
        btnSendMail= findViewById(R.id.btnSendMail);
    }
}