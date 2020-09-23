import java.util.Scanner;
class MyException extends Exception{
	String str1;
	MyException(String str2) {
		str1=str2;
	   }
   public String toString(){ 
	return ("You can not go there!") ;
   }
}
public class Main {
	public static void main(String[] args) 
    { 
		//Introduction
		System.out.println("Messrs Moony, Wormtail, Padfoot and Prongs Purveyors of Aids to\n" + 
				"magical Mischief-Makers are proud to present THE MARAUDER'S MAP\n" + 
				"\nSay the magic phrase to reveal the map.\n");
		Scanner s = new Scanner(System.in);  // Read user input
		String magicPhrase = s.nextLine();
		magicPhrase = magicPhrase.toLowerCase();
	    while(!magicPhrase.contains("i solemnly swear that i am up to no good")) {
	    	System.out.println("The map remains blank...");
	    	System.out.println("Say the magic phrase to reveal the map.\n");
			magicPhrase = s.nextLine();
	  	    }
	    System.out.println("\nThe Entrance\n" + 
	    		"You arrive at the doors of Hogwarts. \n"+
	    			"The door on the north wall leads to the dining hall, the door to the east leads to the Potions class, "+
	    		"and the door to the west leads to the Library.");

	    String location = s.nextLine();  // Read user input	
	    location = location.toLowerCase();
	    while(!location.contains("mischief managed")) {
	    	try {
	    if (location.contains("walk north")){
	    	Dining_Hall student = new Dining_Hall();
	    	student.greeting();
			System.out.println("What would you like to do?");
			String act = s.nextLine();
	    	student.activity(act);
	    	location = next_loc();
	    }
	    else if(location.contains("walk east")){
	    	Potions student_p = new Potions();
	    	student_p.greeting();
			System.out.println("What would you like to do?");
			String act_p = s.nextLine();
	    	student_p.activity(act_p);
	    	location = next_loc();
	    }
	    else if (location.contains("walk west")){
	    Library student_l = new Library();
    	student_l.greeting();
		System.out.println("What would you like to do?");
		String act_l = s.nextLine();
    	student_l.activity(act_l);
    	location = next_loc();
	    }
	    else
	    	throw new MyException("You can not go there!");
		}catch(MyException exp){
			System.out.println(exp) ;
			location = next_loc();				
			}	
	    }
	    System.out.println("Hiding map contents...end.");
        s.close();
    }
	public static String next_loc()
	{	
		Scanner s = new Scanner(System.in);  // Read user input
    	System.out.println("You have arrived back at the Entrance" + 
		"\nThe door on the north wall leads to the dining hall, the door to the east leads to the Potions class, and the door to the west leads to the Library.");
    	String loc = s.nextLine();
    	s.close();
    	return loc;

	}
}
