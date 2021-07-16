package randomProjects;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileHandling {
	ProjectAttributes projectAtt = new ProjectAttributes();
	Path filePath = FileSystems.getDefault().getPath("T:\\Randomize Practice Projects\\projects.txt");
	File projectsFile = new File("projects.txt");
	String[] projectsArray;
	String fileString = "";
	int count = 0;


	public void CreateFile() {
		try {
			if(!projectsFile.exists())
				projectsFile.createNewFile();
		} catch (IOException e) {
			System.out.println("There's been an error creating the file.");
		}
	}

	public void WriteFile(String writeName, String writeCatagory, String writeSkills) throws IOException {
		FileWriter writer = new FileWriter("projects.txt", true);
		BufferedWriter buffWriter = new BufferedWriter(writer);

		buffWriter.write(String.format(">" + writeName + ";" + writeCatagory + ";" + writeSkills + ";\n"));
		buffWriter.close();
	}

	public String ReadFile(){
		BufferedReader buffReader = null;
		try {
			buffReader = new BufferedReader(new FileReader(new File("projects.txt")));
		} catch (FileNotFoundException e) {
			System.out.println("The file couldn't be found.");
		}
		fileString = buffReader.lines().collect(Collectors.joining());

		return fileString;
	} 

	public void PrintFile() {
		fileString = ReadFile();
		projectsArray = fileString.split(";");

		for(int i = 0; i < projectsArray.length; i++) {
			if (count >= projectsArray.length || count + 1 >= projectsArray.length || count + 2 >= projectsArray.length) {
				break;
			} else {
				String projectName = String.format("\n" + "Project Name: ");
				System.out.println(projectName + projectsArray[count].replace(">", "") + "\nCatagory: " + projectsArray[count+1]
						+ "\nSkills: " + projectsArray[count+2]);
			}
			if(count >= projectsArray.length) {
				break;
			} else {
				count = count + 3;
			}
		}
		count = 0;
	}

	public void DeleteFile(String projectName) throws IOException {
		boolean isReadyToWrite = false;
		List<String> newProjectsArray = new ArrayList<String>(Arrays.asList(projectsArray));

		for(int i = 0; i < projectsArray.length - 1; i++) {
			if(Arrays.asList(projectsArray[i]).contains(">" + projectName)) {
				isReadyToWrite = true;

				if(isReadyToWrite) {
					projectsArray[i] = String.format("");
					projectsArray[i+1] = String.format("");
					projectsArray[i+2] = String.format("");
					isReadyToWrite = false;
					
					newProjectsArray.remove(i);
					newProjectsArray.remove(i+1);
					newProjectsArray.remove(newProjectsArray.size() - 1);
				}
			}
		}

		int loopCounter = 0;

		BufferedWriter newBuffWriter;
		try {
			newBuffWriter = new BufferedWriter(new FileWriter("projects.txt", false));
			for (String writeToFile : newProjectsArray) {
				if(loopCounter == 0) {
					newBuffWriter.write(writeToFile + ";");
					loopCounter++;
				} else if (loopCounter == 2){
					newBuffWriter.write(writeToFile + ";\n");
					loopCounter = 0;
				} else {
					newBuffWriter.write(writeToFile + ";");
					loopCounter++;
				}
			}
			newBuffWriter.close();
		} catch (IOException e) {
			System.out.println("Could not write to file.");
		}
	} 
}
