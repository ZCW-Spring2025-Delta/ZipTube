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

    @Column(name = "UserId")
    private Integer userId;

    @Column(name = "VideoId")
    private Integer videoId;

    public Comment() {
        //default constructor
    }

    public Comment(String text, Integer userId, Integer videoId) {
        this.text = text;
        this.userId = userId;
        this.videoId = videoId;
    }

    //For testing purposes
    public Comment(Integer id, String text, Integer userId, Integer videoId) {
        this.id = id;
        this.text = text;
        this.userId = userId;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }
}
