package ZCWDelta.ZipTube.models;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "text")
    private String text;

    //@Column(name = "UserId")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;

    @Column
    private String username;

    //@Column(name = "VideoId")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "video_id", referencedColumnName = "id")
    private Video videoId;

    public Comment() {
        //default constructor
    }

    public Comment(String text, User userId, Video videoId) {
        this.text = text;
        this.userId = userId;
        this.username = userId.getUsername();
        this.videoId = videoId;
    }

    //For testing purposes
    public Comment(Integer id, String text, User userId, Video videoId) {
        this.id = id;
        this.text = text;
        this.userId = userId;
        this.username = userId.getUsername();
        this.videoId = videoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Video getVideoId() {
        return videoId;
    }

    public void setVideoId(Video videoId) {
        this.videoId = videoId;
    }
}
