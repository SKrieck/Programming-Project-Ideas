package randomProjects;

public class ProjectAttributes {
	String name;
	String catagory;
	String skills;
	
	public void project(String projectName, String projectCatagory, String projectSkills) {
		
		this.name = projectName;
		this.catagory = projectCatagory;
		this.skills = projectSkills;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String projectName) {
		this.name = projectName;
	}
	
	public String getCatagory() {
		return catagory;
	}
	
	public void setCatagory(String projectCatagory) {
		this.catagory = projectCatagory;
	}
	
	public String getSkills() {
		return skills;
	}
	
	public void setSkills(String projectSkills) {
		this.skills = projectSkills;
	}
}
