package vn.iotstar.Model;

public class UserViewModel {
    private String username;
    private String password;
    private String lectureId;
    private String lectureName;
    private int deleted;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLectureId() {
        return lectureId;
    }

    public void setLectureId(String lectureId) {
        this.lectureId = lectureId;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}
