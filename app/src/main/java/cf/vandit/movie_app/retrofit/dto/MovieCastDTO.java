package cf.vandit.movie_app.retrofit.dto;

import java.io.Serializable;

public class MovieCastDTO implements Serializable {
    private int id;
    private String avatar;
    private String name;
    private String story;
    private String birthday;

    public MovieCastDTO() {
    }

    public MovieCastDTO(int id, String avatar, String name, String story, String birthday) {
        this.id = id;
        this.avatar = avatar;
        this.name = name;
        this.story = story;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
