package ZCWDelta.ZipTube;

import ZCWDelta.ZipTube.models.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class VideoDTO {
//    private Integer videoId;

    private String videoName;

    private String query;

    private Boolean favorite;

    private Boolean uploaded;

    private String year;

    private String url;

    private Integer commentId;


    public String getVideoName() {
        return videoName;
    }

    public String getQuery() {
        return query;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public Boolean getUploaded() {
        return uploaded;
    }

    public String getYear() {
        return year;
    }

    public String getURL() {
        return url;
    }

    public Integer getCommentId() {
        return commentId;
    }
}
