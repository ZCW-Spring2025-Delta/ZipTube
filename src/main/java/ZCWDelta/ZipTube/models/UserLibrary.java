package ZCWDelta.ZipTube.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user_library")
public class UserLibrary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer Id;

    @Column(name = "favorites")
    private String favorites;

    @Column(name = "upload")
    private String upload;

    @Column(name = "User_id")
    private Integer UserId;

    @Column(name = "Video_id")
    private Integer VideoId;

    public UserLibrary(){
        //default constructor
    }

    public UserLibrary (Integer id, String favorites, String upload, Integer userId, Integer videoId) {
            this.Id = id;
            this.favorites = favorites;
            this.upload = upload;
            this.UserId = userId;
            this.VideoId = videoId;
        }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getFavorites() {
        return favorites;
    }

    public void setFavorites(String favorites) {
        this.favorites = favorites;
    }

    public String getUpload() {
        return upload;
    }

    public void setUpload(String upload) {
        this.upload = upload;
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
