package ZCWDelta.ZipTube.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Videos")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer videoId;

    @Column(name = "video_name")
    private String videoName;

    @Column(name = "query")
    private String query;

    @Column(name = "favorite")
    private Boolean favorite;

    @Column(name = "uploaded")
    private Boolean uploaded;

    @Column(name = "video_year")
    private String year;

    @Column(name = "URL")
    private String url;

    @Column(name = "comment_id")
    private Integer commentId;

    //Uploaded by (many-to-one)
    @ManyToOne
    @JoinColumn(name = "uploader")
    private User uploader;


    public Video() {
        //default constructor
    }


    public Video(Integer videoId, String videoName, String query, Boolean favorite, Boolean uploaded, String year, String url, User user, Integer commentId) {
        this.videoId = videoId;
        this.videoName = videoName;
        this.query = query;
        this.favorite = favorite;
        this.uploaded = uploaded;
        this.year = year;
        this.url = url;
        this.uploader = user;
        this.commentId = commentId;
    }



    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getURL() {
        return url;
    }

    public void setURL(String URL) {
        this.url = url;
    }

    public User getUser() {
        return this.uploader;
    }

    public void setUser(User user) {
        this.uploader = user;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Boolean getUploaded() {
        return uploaded;
    }

    public void setUploaded(Boolean uploaded) {
        this.uploaded = uploaded;
    }

}
