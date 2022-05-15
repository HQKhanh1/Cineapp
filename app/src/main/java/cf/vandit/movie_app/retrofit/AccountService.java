package cf.vandit.movie_app.retrofit;

import cf.vandit.movie_app.retrofit.request.LoginRequest;
import cf.vandit.movie_app.retrofit.request.RegisterRequest;
import cf.vandit.movie_app.retrofit.response.LoginResponse;
import cf.vandit.movie_app.retrofit.response.RegisterResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AccountService {

    @POST("/api/auth/login")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);

    @POST("/api/auth/signup")
    Call<RegisterResponse> userRegister(@Body RegisterRequest registerRequest);
}
