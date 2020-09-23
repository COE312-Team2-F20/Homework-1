

public abstract class Location{
	public String room = "room";
	public void look() {System.out.println("You look around the " + room);}
	public void walk() {System.out.println("You leave the " + room + "...");}
	public void greeting() {System.out.println("You enter the " + room + "\n");}
	public void end() {System.out.println("Hiding map contents...end."); System.exit(0);}
}
