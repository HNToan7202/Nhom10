package vn.iotstar.Model;

public class StudentClassViewModel {
    private String studentClassId;
    private String studentClassName;
    private String facultyId;
    private String facultyName;
    private int deleted;

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getStudentClassId() {
        return studentClassId;
    }

    public void setStudentClassId(String studentClassId) {
        this.studentClassId = studentClassId;
    }

    public String getStudentClassName() {
        return studentClassName;
    }

    public void setStudentClassName(String studentClassName) {
        this.studentClassName = studentClassName;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}
