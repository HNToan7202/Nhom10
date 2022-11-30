package vn.iotstar.Model;

public class GradeViewModel {
    private String studentId;
    private String studentName;
    private String subjectGroupId;
    private String subjectGroupName;
    private double middleGrade;
    private double finalGrade;
    private int deleted;
    private double totalGrade;

    public double getTotalGrade() {
        return totalGrade;
    }

    public void setTotalGrade(double totalGrade) {
        this.totalGrade = totalGrade;
    }
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubjectGroupName() {
        return subjectGroupName;
    }

    public void setSubjectGroupName(String subjectGroupName) {
        this.subjectGroupName = subjectGroupName;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSubjectGroupId() {
        return subjectGroupId;
    }

    public void setSubjectGroupId(String subjectGroupId) {
        this.subjectGroupId = subjectGroupId;
    }

    public double getMiddleGrade() {
        return middleGrade;
    }

    public void setMiddleGrade(double middleGrade) {
        this.middleGrade = middleGrade;
    }

    public double getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(double finalGrade) {
        this.finalGrade = finalGrade;
    }
}
