package ZCWDelta.ZipTube.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "favorites")
    private String favorites;

    @Column(name = "upload")
    private String Upload;

    @Column(name = "comment_id")
    private Integer commentId;

    @Column(name = "user_library_id")
    private UserLibrary userLibraryId;

    public User(){
        //default constructor
    }

    public User (Integer id, String username, String firstName, String lastName, String email, String password, String favorites, String upload, Integer commentId, UserLibrary userLibraryId) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.favorites = favorites;
        this.Upload = upload;
        this.commentId = commentId;
        this.userLibraryId = userLibraryId;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFavorites() {
        return favorites;
    }

    public void setFavorites(String favorites) {
        this.favorites = favorites;
    }

    public String getUpload() {
        return Upload;
    }

    public void setUpload(String upload) {
        Upload = upload;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public UserLibrary getUserLibraryId() {
        return userLibraryId;
    }

    public void setUserLibraryId(UserLibrary userLibraryId) {
        this.userLibraryId = userLibraryId;
    }
}
