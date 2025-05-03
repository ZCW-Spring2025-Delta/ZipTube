package ZCWDelta.ZipTube.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user_library")
public class UserLibrary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer Id;

    @Column(name = "favorites")
    private List<String> favorites;

    @Column(name = "uploads")
    private List<String> uploads;

    @Column(name = "User_id")
    private Integer UserId;

    @Column(name = "Video_id")
    private Integer VideoId;

    public UserLibrary(){
        //default constructor
    }

    public UserLibrary (Integer id, List<String> favorites, List<String> uploads, Integer userId, Integer videoId) {
            this.Id = id;
            this.favorites = favorites;
            this.uploads = uploads;
            this.UserId = userId;
            this.VideoId = videoId;
        }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public List<String> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<String> favorites) {
        this.favorites = favorites;
    }

    public List<String> getUploads() {
        return uploads;
    }

    public void setUpload(List<String> uploads) {
        this.uploads = uploads;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public Integer getVideoId() {
        return VideoId;
    }

    public void setVideoId(Integer videoId) {
        VideoId = videoId;
    }
}
