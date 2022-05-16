package cf.vandit.movie_app.retrofit;

import cf.vandit.movie_app.retrofit.dto.AccountInfo;
import cf.vandit.movie_app.retrofit.request.LoginRequest;
import cf.vandit.movie_app.retrofit.request.RegisterRequest;
import cf.vandit.movie_app.retrofit.response.LoginResponse;
import cf.vandit.movie_app.retrofit.response.RegisterResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AccountService {

    @POST("/api/auth/login")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);

    @POST("/api/auth/signup")
    Call<RegisterResponse> userRegister(@Body RegisterRequest registerRequest);

    @GET("/api/acc/getAccoutByUsername/{username}")
    Call<AccountInfo> getAccountInfo(@Path("username") String username);
}
