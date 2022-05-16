package cf.vandit.movie_app.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import cf.vandit.movie_app.R;
import cf.vandit.movie_app.activities.ChangePasswordActivity;

public class ProfileFragment extends Fragment {
    TextView firstname,lastname, birthday, gender, email, changePassword;
    Button btnEditProfile;
    String query;

    public ProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        String username;
        String password;
        String email;
        String firstname;
        String lastname;
        String birthday;
        boolean gender;
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        firstname= view.findViewById(R.id.firstname);
        lastname= view.findViewById(R.id.lastname);
        birthday= view.findViewById(R.id.birthday);
        gender= view.findViewById(R.id.gender);
        email= view.findViewById(R.id.email);
        changePassword= view.findViewById(R.id.changePassword);

        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ChangePasswordActivity.class));
            }
        });
    }
}
