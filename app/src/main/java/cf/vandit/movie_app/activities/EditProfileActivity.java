package cf.vandit.movie_app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import cf.vandit.movie_app.R;
import cf.vandit.movie_app.retrofit.RetrofitService;
import cf.vandit.movie_app.retrofit.dto.AccountInfo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfileActivity extends AppCompatActivity {
    TextView dob, btnBack;
    EditText username, email, password, confirmPassword, firstName, lastName;
    RadioButton rdbMale, rdbFemale;
    ImageView imgCalendar;
    String birthday, gender;
    Button btnEdit;
    public static AccountInfo accountInfoDefault;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        accountInfoDefault= MainActivity.accountInfo;
        setControl();
        setEvent();
    }

    private void setEvent() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        imgCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(EditProfileActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        dob.setText(String.format("%d/%d/%d", i2, i1 + 1, i));
                    }
                }, year, month, day);
                System.out.println("dob= "+dob.getText().toString());
                if (month < 10) {
                    birthday = year + "-0" + month + "-" + day;
                } else {
                    birthday = year + "-" + month + "-" + day;
                }
                System.out.println(birthday);
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AccountInfo accountInfoEdit= new AccountInfo();
                accountInfoEdit.setUsername(accountInfoDefault.getUsername());
                accountInfoEdit.setEmail(email.getText().toString());
                accountInfoEdit.setFirstname(firstName.getText().toString());
                accountInfoEdit.setLastname(lastName.getText().toString());
                accountInfoEdit.setPassword(accountInfoDefault.getPassword());
                if (rdbMale.isChecked()){
                    accountInfoEdit.setGender(true);
                } else {
                    accountInfoEdit.setGender(false);
                }
                accountInfoEdit.setBirthday(birthday);
                System.out.println(accountInfoEdit);
                Call<Boolean> accountInfoCall= RetrofitService.getAccountService().updateAccount(accountInfoEdit);
                accountInfoCall.enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        Toast.makeText(EditProfileActivity.this,"Change Successfully", Toast.LENGTH_LONG ).show();
                        startActivity(new Intent(EditProfileActivity.this, MainActivity.class));
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        Toast.makeText(EditProfileActivity.this, "Edit fail", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EditProfileActivity.this, MainActivity.class));
            }
        });
    }

    private void setControl() {
        btnEdit = findViewById(R.id.btnConfirmEdit);
        btnBack = findViewById(R.id.btnBack);
        username = findViewById(R.id.inputUsername);
        email = findViewById(R.id.inputEmail);
        firstName = findViewById(R.id.inputFirstName);
        lastName = findViewById(R.id.inputLastName);
        password = findViewById(R.id.inputPassword);
        confirmPassword = findViewById(R.id.inputConformPassword);
        rdbMale = findViewById(R.id.rdbMale);
        rdbFemale = findViewById(R.id.rdbFemale);
        imgCalendar = findViewById(R.id.imgCalendar);
        dob = findViewById(R.id.inputDateOfBirth);
    }
}