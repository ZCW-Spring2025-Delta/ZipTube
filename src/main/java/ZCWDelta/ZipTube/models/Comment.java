package ZCWDelta.ZipTube.models;

import jakarta.persistence.*;
import ZCWDelta.ZipTube.services.UserService;
import ZCWDelta.ZipTube.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "comments")
public class Comment {

//    private VideoService vidService;
//    private UserService userService;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "text")
    private String text;

    @Column(name = "UserId")
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Integer userId;

    @Column
    private String username;

    @Column(name = "VideoId")
    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "video_id", referencedColumnName = "id")
    private Integer videoId;

    public Comment() {
        //default constructor
    }

    public Comment(String text, Integer userId, String username, Integer videoId) {
        this.text = text;
        //this.userId = userId;
        this.username = username;
        this.videoId = videoId;
    }

//    public Comment(String text, Integer userId, Integer videoId) {
//        this.text = text;
//        this.userId = userService.findById(userId).get();
//        this.username = this.userId.getUsername();
//        this.videoId = vidService.getVideoById(videoId).get();
//    }

    //For testing purposes
    public Comment(Integer id, String text, Integer userId, String username, Integer videoId) {
        this.id = id;
        this.text = text;
        //this.userId = userId;
        this.username = username;
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

//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }
}
