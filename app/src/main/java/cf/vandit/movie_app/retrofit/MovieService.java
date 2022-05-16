package cf.vandit.movie_app.retrofit;

import java.util.List;

import cf.vandit.movie_app.retrofit.dto.MovieCastDTO;
import cf.vandit.movie_app.retrofit.dto.MovieDetailDTO;
import cf.vandit.movie_app.retrofit.dto.MovieGenreDTO;
import cf.vandit.movie_app.retrofit.dto.MovieRate;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MovieService {

    @GET("/api/movieDetail/getMovieDetailAll")
    Call<List<MovieDetailDTO>> getListMovie();

    @GET("/api/movieDetail/getMovieDetail/{id}")
    Call<MovieDetailDTO> getMovieDetailById(@Path("id") int id);

    @GET("/api/movieDetail/getMovieRates")
    Call<List<MovieRate>> getMoveRates();

    @GET("/api/movieDetail/getMovieRate/{id}")
    Call<MovieRate> getMoveRate(@Path("id") int id);

    @GET("/api/movieDetail/getGenreByMovieId/{id}")
    Call<List<MovieGenreDTO>> getGenReByMovie(@Path("id") int id);

    @GET("/api/movieDetail/getCastByMovieId/{id}")
    Call<List<MovieCastDTO>> getCastByMovie(@Path("id") int id);


}
