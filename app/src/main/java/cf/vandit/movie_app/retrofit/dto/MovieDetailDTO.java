package cf.vandit.movie_app.retrofit.dto;


import java.sql.Time;
import java.time.LocalDate;

public class MovieDetailDTO {
    private int id;
    private String title;
    private String poster;
    private String detail;
    private Boolean movieStatus;
    private String linkTrailer;
    private String linkMovie;
    private LocalDate releaseDate;
    private Time movieDuration;
    private int viewNumber;

    @Override
    public String toString() {
        return "MovieDetailDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", poster='" + poster + '\'' +
                ", detail='" + detail + '\'' +
                ", movieStatus=" + movieStatus +
                ", linkTrailer='" + linkTrailer + '\'' +
                ", linkMovie='" + linkMovie + '\'' +
                ", releaseDate=" + releaseDate +
                ", movieDuration=" + movieDuration +
                ", viewNumber=" + viewNumber +
                '}';
    }
}
