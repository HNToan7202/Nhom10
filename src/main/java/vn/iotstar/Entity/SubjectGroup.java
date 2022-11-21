package vn.iotstar.Entity;

public class SubjectGroup {
	 private String subjectGroupId;
	    private String subjectGroupName;
	    private String subjectId;
	    private String lectureId;
	    private int deleted;

	    public String getSubjectGroupId() {
	        return subjectGroupId;
	    }

	    public void setSubjectGroupId(String subjectGroupId) {
	        this.subjectGroupId = subjectGroupId;
	    }

	    public String getSubjectGroupName() {
	        return subjectGroupName;
	    }

	    public void setSubjectGroupName(String subjectGroupName) {
	        this.subjectGroupName = subjectGroupName;
	    }

	    public String getSubjectId() {
	        return subjectId;
	    }

	    public void setSubjectId(String subjectId) {
	        this.subjectId = subjectId;
	    }

	    public String getLectureId() {
	        return lectureId;
	    }

	    public void setLectureId(String lectureId) {
	        this.lectureId = lectureId;
	    }

	    public int getDeleted() {
	        return deleted;
	    }

	    public void setDeleted(int deleted) {
	        this.deleted = deleted;
	    }

}
