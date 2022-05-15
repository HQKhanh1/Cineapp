package cf.vandit.movie_app.retrofit;

import java.util.List;

import cf.vandit.movie_app.retrofit.dto.MovieDetailDTO;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieService {

    @GET("/api/movieDetail/getMovieDetailAll")
    Call<List<MovieDetailDTO>> getListMovie();
}
