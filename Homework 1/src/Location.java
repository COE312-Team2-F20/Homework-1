import java.util.Scanner;

public abstract class Location{
	
	public String room = "room";
	Location(){
		room = "Nowhere";
	}
	Location(String n){
		room = n;
	}
	void look() {System.out.println("You look around the " + room);}
	void walk() {System.out.println("You leave the " + room + "...");}
	void greeting() {System.out.println("You entered the " + room + "\n");}
	//function that asks the player for the next input
	public String next_a() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("What would you like to do next?");
		String next = input.nextLine();
		next = next.toLowerCase();
		return next;
	}
	abstract void activity(String test);
	void end() {System.out.println("Hiding map contents...end."); System.exit(0);}
}
