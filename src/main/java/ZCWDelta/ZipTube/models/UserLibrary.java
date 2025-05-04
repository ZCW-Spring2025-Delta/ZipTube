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
    @ManyToMany
    @JoinTable(
            name = "user_favorite_videos",
            joinColumns = @JoinColumn(name = "userLibrary"),
            inverseJoinColumns = @JoinColumn(name = "video_id")
    )
    private List<Video> favorites;

//    @Column(name = "uploads")
    @OneToMany(mappedBy = "userLibrary", cascade = CascadeType.ALL)
    private List<Video> uploads;

    @Column(name = "User_id")
    private Integer UserId;

    @Column(name = "Video_id")
    private Integer VideoId;

    public UserLibrary(){
        //default constructor
    }

    public UserLibrary (Integer id, List<Video> favorites, List<Video> uploads, Integer userId, Integer videoId) {
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

    public List<Video> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Video> favorites) {
        this.favorites = favorites;
    }

    public List<Video> getUploads() {
        return uploads;
    }

    public void setUpload(List<Video> uploads) {
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
