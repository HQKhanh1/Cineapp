package cf.vandit.movie_app.retrofit.dto;


import java.io.Serializable;
import java.util.List;

public class MovieDetailDTO implements Serializable {
    private int id;
    private String title;
    private String poster;
    private String detail;
    private Boolean movieStatus;
    private String linkTrailer;
    private String linkMovie;
    private List<Integer> releaseDate;
    private String movieDuration;
    private int viewNumber;

    public MovieDetailDTO() {
    }

    public MovieDetailDTO(int id, String title, String poster, String detail, Boolean movieStatus, String linkTrailer, String linkMovie, List<Integer> releaseDate, String movieDuration, int viewNumber) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.detail = detail;
        this.movieStatus = movieStatus;
        this.linkTrailer = linkTrailer;
        this.linkMovie = linkMovie;
        this.releaseDate = releaseDate;
        this.movieDuration = movieDuration;
        this.viewNumber = viewNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Boolean getMovieStatus() {
        return movieStatus;
    }

    public void setMovieStatus(Boolean movieStatus) {
        this.movieStatus = movieStatus;
    }

    public String getLinkTrailer() {
        return linkTrailer;
    }

    public void setLinkTrailer(String linkTrailer) {
        this.linkTrailer = linkTrailer;
    }

    public String getLinkMovie() {
        return linkMovie;
    }

    public void setLinkMovie(String linkMovie) {
        this.linkMovie = linkMovie;
    }

    public List<Integer> getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(List<Integer> releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(String movieDuration) {
        this.movieDuration = movieDuration;
    }

    public int getViewNumber() {
        return viewNumber;
    }

    public void setViewNumber(int viewNumber) {
        this.viewNumber = viewNumber;
    }

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
