package ZCWDelta.ZipTube.models;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

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

    @Column(name = "year")
    private Integer year;

    @Column(name = "URL")
    private String URL;

    @Column(name = "user_library_id")
    private Integer user_Library_id;

    @Column(name = "comment_id")
    private Integer commentId;

    public Video() {
        //default constructor
    }

    public Video(Integer videoId, String videoName, String query, Boolean favorite, Integer year, String URL, Integer user_Library_id, Integer commentId) {
        this.videoId = videoId;
        this.videoName = videoName;
        this.query = query;
        this.favorite = favorite;
        this.year = year;
        this.URL = URL;
        this.user_Library_id = user_Library_id;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Integer getUser_Library_id() {
        return user_Library_id;
    }

    public void setUser_Library_id(Integer user_Library_id) {
        this.user_Library_id = user_Library_id;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
}
