package cf.vandit.movie_app.activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.List;

import cf.vandit.movie_app.R;
import cf.vandit.movie_app.fragments.FavouritesFragment;
import cf.vandit.movie_app.fragments.MovieFragment;
import cf.vandit.movie_app.fragments.SearchFragment;
import cf.vandit.movie_app.fragments.SeriesFragment;
import cf.vandit.movie_app.retrofit.RetrofitService;
import cf.vandit.movie_app.retrofit.dto.MovieDetailDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getListMovie();
        bottomNavigationView = findViewById(R.id.bottom_nav);
        toolbar = findViewById(R.id.toolbar_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MovieFragment()).commit();
        toolbar.setTitle("Movies");

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_movie:
                        if (!getSupportFragmentManager().findFragmentById(R.id.fragment_container).getClass().getSimpleName().equals("MovieFragment")) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MovieFragment()).commit();
                            toolbar.setTitle("Movies");
                        }
                        break;
                    case R.id.nav_series:
                        if (!getSupportFragmentManager().findFragmentById(R.id.fragment_container).getClass().getSimpleName().equals("SeriesFragment")) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SeriesFragment()).commit();
                            toolbar.setTitle("Series");
                        }
                        break;
                    case R.id.nav_search:
                        if (!getSupportFragmentManager().findFragmentById(R.id.fragment_container).getClass().getSimpleName().equals("SearchFragment")) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SearchFragment()).commit();
                            toolbar.setTitle("Search");
                        }
                        break;
                    case R.id.nav_favourites:
                        if (!getSupportFragmentManager().findFragmentById(R.id.fragment_container).getClass().getSimpleName().equals("FavouritesFragment")) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FavouritesFragment()).commit();
                            toolbar.setTitle("Favourites");
                        }
                        break;
                }
                return true;
            }
        });
    }

    private void getListMovie() {
        Call<List<MovieDetailDTO>> listCall= RetrofitService.getMovieService().getListMovie();
        listCall.enqueue(new Callback<List<MovieDetailDTO>>() {
            @Override
            public void onResponse(Call<List<MovieDetailDTO>> call, Response<List<MovieDetailDTO>> response) {
                if (response.isSuccessful()){
                    List<MovieDetailDTO> movieDetailDTO= response.body();
                    System.out.println("body= "+response.body());
                    System.out.println(movieDetailDTO);
                } else {
                    Toast.makeText(MainActivity.this,"Load Failed", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<MovieDetailDTO>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Throwable "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}