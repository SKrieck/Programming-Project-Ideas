package randomProjects;
import java.io.IOException;
import java.util.Scanner;

public class RandomProjects {

	public static void main(String[] args) throws IOException {
		int end = 0;
		Actions action = new Actions();
		Scanner input = new Scanner(System.in);
		FileHandling file = new FileHandling();
		
		file.CreateFile();
		
		// program loop
		do {
			
			System.out.println("--------------------");
			System.out.println("Random Projects Menu");
			System.out.println("--------------------");
			System.out.println("1) Add Project\n"
					+ "2) Delete Project\n"
					+ "3) Randomize\n"
					+ "4) Print List\n"
					+ "5) End");
			
			int selection = input.nextInt();	
			
			switch(selection) {
			case 1:
				action.Add();	
				break;
			case 2:
				action.Delete();
				break;
			case 3:
				action.Randomize();
				break;
			case 4:
				action.Print();
				break;
			case 5:
				end = 1;
				break;
			}
		} while (end != 1);
		input.close();
	}

}
