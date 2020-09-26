import java.util.Scanner;
public class Main {
	public static void main(String[] args) 
    { 
		//Introductory message to the player
		System.out.println("Messrs Moony, Wormtail, Padfoot and Prongs Purveyors of Aids to\n" + 
				"magical Mischief-Makers are proud to present THE MARAUDER'S MAP\n" + 
				"\nSay the magic phrase to reveal the map.\n");
		
		// Read user input
		Scanner s = new Scanner(System.in);
		String magicPhrase = s.nextLine();
		
		//converting string to lower case to ensure that as long as the player inputed the correct words sentence case does not matter
		magicPhrase = magicPhrase.toLowerCase();
	    while(!magicPhrase.contains("i solemnly swear that i am up to no good")) {
	    	System.out.println("The map remains blank...");
	    	System.out.println("Say the magic phrase to reveal the map.\n");
			magicPhrase = s.nextLine();
	  	    }
	    //the player has reached the entrance and can now explore the specified locations
	    System.out.println("\nThe Entrance\nYou arrive at the doors of Hogwarts.\n"+
		"The door on the north wall leads to the dining hall, the door to the east leads to the Potions class, and the door to the west leads to the Library.");

	    //read where the player wants to go
	    String location = s.nextLine(); 
	    location = location.toLowerCase();
	    while(!location.contains("mischief managed")) {
	    //the player chooses to go to the dining hall
	    if (location.contains("walk north")){
	    	Dining_Hall student = new Dining_Hall();
	    	location = begin(student, location);
	    }
	    //the player chooses to go to the potions classroom
	    else if(location.contains("walk east")){
	    	Potions student_p = new Potions();
	    	location = begin(student_p, location);
	    	
	    }
	  //the player chooses to go to the library
	    else if (location.contains("walk west")){
	    Library student_l = new Library();
	    location = begin(student_l,location);
	    }
	    else 
	   {	//if the player chooses to go to an illegal location
	    	if(location.contains("walk")){
	    	System.out.println("You can not go there!");
	    	location = next_loc();
	    	}{
    		//if the player inputs an invalid command that does not begin with walk
	    	if(!location.contains("walk"))
	    	System.out.println("That is not a valid command!");
	    	location = next_loc();
	    	}	
	    }
	    //if the player chooses to input mischief managed the loop has ended and the game is over
	    }
	    System.out.println("Hiding map contents...end.");
        s.close();
	    }
	//function to take the player to the next location
	public static String next_loc()
	{	//open the scanner to receive input from the user
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in); 
    	System.out.println("You have arrived back at the Entrance" + 
		"\nThe door on the north wall leads to the dining hall, the door to the east leads to the Potions class, and the door to the west leads to the Library.");
    	//reads the next location from the player
    	String loc = s.nextLine();
    	//return the updated location
    	return loc;
	}
	//function to take the player to the location they choose
	public static String begin(Location l,String location) {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in); 
    	l.greeting();
		System.out.println("What would you like to do?");
		String act = s.nextLine();
    	l.activity(act);
    	location = next_loc();
    	return location;
	}
	
}
