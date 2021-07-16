package randomProjects;
import java.util.*;
import java.io.*;

public class Actions implements InterfaceActions {
	Scanner input = new Scanner(System.in);
	FileHandling file = new FileHandling();
	String[] projectsArray;
	ProjectAttributes project = new ProjectAttributes();
	String name = "";
	String catagory = "";
	String skills = "";
	
	public void Add() throws IOException {	
		boolean isAddAnother = false;
		
		do {	
			System.out.println("Input the name of the project: ");
			name = input.nextLine();
			System.out.println("Input the catagory of the project: ");
			catagory = input.nextLine();
			project.setCatagory(catagory);
			System.out.println("Input the skills needed, seperated by commas: ");
			skills = input.nextLine();
			file.WriteFile(name, catagory, skills);
		
			System.out.println("Project added. Would you like to add another?");
			String YorN = input.nextLine().toLowerCase();
		
			if (YorN.contains("y")) {
				continue;
			} else if (YorN.contains("n")) {
				isAddAnother = true;
			}
		} while (!isAddAnother);
	}

	public void Delete() throws IOException {
		Print();
		
		System.out.println("--------------------------");
		System.out.println("Type the name of the project you'd like to delete: ");
		String projectName = input.nextLine();
		
		file.DeleteFile(projectName);
		
		Print();
	}

	public void Print() {
		file.PrintFile();
	}
	
	public void Randomize() throws IOException {
		Random random = new Random();
		String tempProjectsString = file.ReadFile();
		boolean isRandom = false;
		
		List<String> randomList = Arrays.asList(tempProjectsString.split(";"));
		
		while(!isRandom) {
			int randomProject = random.nextInt(randomList.size());
			if(randomList.get(randomProject).contains(">")) {
				System.out.println("Tackle this project next! " + randomList.get(randomProject).toString().replace(">", ""));
				isRandom = true;
			}
		}
	}
}

