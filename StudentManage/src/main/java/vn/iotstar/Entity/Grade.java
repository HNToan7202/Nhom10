package vn.iotstar.Entity;

public class Grade {
    private String studentId;
    private String subjectId;
    private double middleGrade;
    private double finalGrade;
    private int deleted;
    private double totalGrade;

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

	public double getTotalGrade() {
		return totalGrade;
	}

	public void setTotalGrade(double totalGrade) {
		this.totalGrade = totalGrade;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
}
