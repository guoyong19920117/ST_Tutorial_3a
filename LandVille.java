package LandVille;

import java.util.Scanner;

// import whatever packages are needed here
// Programming note: this class does NOT need to do any input
// at all. All the input should occur in LandVilleMain.java
// If you find yourself needing to do input here rethink your solution.

public class LandVille {
	// create Scanner object which is used to get user input
	Scanner scanner = new Scanner(System.in);
	
	// create 2D array
	private int[][] land;
	
	// create variable 'hasHouse' which is used to check house building
	private boolean hasHouse;
	
	// Constructor...
	// no parameters constructor method
	public LandVille() {};
	
	// parameters constructor method
	public LandVille(int maxRows, int maxColumns) 
	{
		// Create the array that the land variable above will reference (using the 'new' operator)
		land = new int[maxRows][maxColumns];
		
		// Initialise the land so that each cell is set to the character '0' (hint: use one of your// methods!)
		for(int i = 0; i < land.length; i++) {
			for(int j = 0; j < land[i].length; j++) {
				land[i][j] = 0;
			}
		}
		
		// Initialise hasHouse value to false
		hasHouse = false;
	};
	
	// Use get/set method to help get value of hasHouse
	public boolean isHasHouse() 
	{
		return hasHouse;
	}

	public void setHasHouse(boolean hasHouse) 
	{
		this.hasHouse = hasHouse;
	}

	// Display the land grid
	public void displayLand()
	{
		for(int i = 0; i < land.length; i++) {
			for(int j = 0; j < land[i].length; j++) {
				System.out.print(land[i][j]+" ");
			};
			System.out.println();
		};
	};
	
	// Clear out the land. This involves setting each cell to be the character '0'
	public void clearLand()
	{
		for(int i = 0; i < land.length; i++) {
			for(int j = 0; j < land[i].length; j++) {
				land[i][j] = 0;
			};
		};
		hasHouse = false;
		System.out.println("Land cleared");
		displayLand();
	};
	
	// Build a house
	// Validate the inputs to ensure they make sense for the size of the land
	// - display an error message and return if they don't.
	// Ensure none of the other rules are violated
	// - again display an error message and return if they are violated
	// If all is ok "build" the house on the land (using the character '8') surrounded by a pretty little fence of '1' characters.
	// Finally update 'hasHouse' and call on displayLand().
	public void buildHouse(int rows, int columns) 
	{
		if(land.length-rows < 2) {
			System.out.println("Invalid input. Rows of house needs to less than or equal to " + (land.length-2) + ". " + "No house is built.");
		}else if(land[0].length-columns < 2) {
			System.out.println("Invalid input. Columns of house needs to less than or equal to " + (land[0].length-2) + ". " + "No house is built.");
		}else {
			for(int i = 0; i < land.length; i++) {
				for(int j = 0; j < land[i].length; j++) {
					if(i > 0 && i <= rows && j > 0 && j <= columns) {
						land[i][j] = 8;
					}else if(i < rows+2 && j < columns+2) {
						land[i][j] = 1;
					}else {
						land[i][j] = 0;
					};
				};
			};
			hasHouse = true;
			displayLand();
		};
		
	};
	
	// the methods below this line are used to reduce the number of code line in the main method
	// check row's value, make sure the value large than 0 and less than 10
	public boolean checkRows(int rows) 
	{
		if(rows <= 0 || rows >= 10) {
			System.out.println("The value of rows must geater than 0 and less or equal 10, Please enter again.");
			return true;
		}else {
			return false;
		}
	}
	
	// get eligible row number from user input
	public int getRows() 
	{
		int maxRows = 0;
		do {
			System.out.print("Please enter land rows: ");
			maxRows = scanner.nextInt();
		}while(checkRows(maxRows));
		return maxRows;
	}
	
	// check column's value, make sure the value large than 0 and less than 10
	public boolean checkColumns(int columns) 
	{
		if(columns <= 0 || columns >= 10) {
			System.out.println("The value of rows must geater than 0 and less or equal 10, Please enter again.");
			return true;
		}else {
			return false;
		}
	}
	
	// get eligible column number from user input
	public int getColumns() 
	{
		int maxColumns = 0;
		do {
			System.out.print("Please enter land columns: ");
			maxColumns = scanner.nextInt();
		}while(checkColumns(maxColumns));
		return maxColumns;
	}
	
	// get house row and house column from user input, if the land doesn'e have house
	public void createHouse() 
	{
		if(hasHouse == true) {
			System.out.println("Here already had a house. Please use clearLand method before building.");
		}else {
			System.out.print("Please enter house rows: ");
			int rows = scanner.nextInt();
			System.out.print("Please enter house columns: ");
			int columns =scanner.nextInt();
			buildHouse(rows, columns);
		};
		
	}
	
	// this method is used to build the program menu. use loop to control the program flow
	public void Menu() 
	{
		// Create variable cycleMark which is the parameter of while loop
		boolean cycleMark = true;
		
		while(cycleMark) {
			System.out.println("---------------Menu---------------");
			System.out.println("\t1. Bulid a house");
			System.out.println("\t2. Display land");
			System.out.println("\t3. Clear land");
			System.out.println("\t4. Quite");
			System.out.println("----------------------------------");
			System.out.println("Please enter number to choose funciton: ");
			int number = scanner.nextInt();
			if(number == 1) {
				createHouse();
				continue;
			}else if(number == 2) {
				displayLand();
				continue;
			}else if(number == 3) {
				clearLand();
				continue;
			}else if(number == 4) {
				cycleMark = false;
				break;
			}else {
				System.out.println("The number is wrong. Please enter again.");
				continue;
			}
			
		};
	}
	
	// close the scanner input stream
	public void closeScanner() 
	{
		scanner.close();
	}
	
	public static void main(String[] args) 
	{
		//create a LandVille object
		LandVille lv = new LandVille();
		
		// Create an object of class LandVille using the 'new' operator, calling on the LandVille constructor.
		lv = new LandVille(lv.getRows(), lv.getColumns());
		
		// Build a loop to display the menu, prompt for input and process it as per requirements.
		lv.Menu();
		
		// use close() method to close scanner input stream and exit the program
		lv.closeScanner();
		System.exit(0);
		
	}
	
}
