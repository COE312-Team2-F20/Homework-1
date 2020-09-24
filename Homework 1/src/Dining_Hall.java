
import java.util.Random;
import java.util.Scanner;
/*class MyException_d extends Exception{
	String str1;
	MyException_d(String str2) {
		str1=str2;
	   }
   public String toString(){ 
	return ("That is not a valid command!") ;
   }
}*/
public class Dining_Hall extends Location implements Behaviour, Character {
	//default constructor
	public Dining_Hall()
	{super.room = "Dining Hall";}
	Scanner input = new Scanner(System.in);
	//Location functions
	@Override
	public void look(){ System.out.println("The dining hall is the biggest open area inside Hogwarts. In the dining hall, you find Professor Dumbledore.\nYou can use the sorting hat to get sorted into your house, and hold food to eat.");}

	//Behavior function
	public void hold(String a) {
		if(a.contains("sorting hat"))
		 {
			String[] list = {"Gryffindor!", "Hufflepuff!", "Slytherin!", "Ravenclaw!"};
	        Random rand = new Random(); 
	        int randomNumber=rand.nextInt(list.length); 
	        System.out.println(list[randomNumber]); 
		}
		else if (a.contains("food"))
		{		System.out.println("You gobble up some yummy chocolate frogs");}
		else 
		System.out.println("This item is not here!");
	}
	
	//Character function	
	public void talk(String p) {
		if (p.contains("dumbledore")) {
		System.out.println("Welcome to the dining hall! Interact with the sorting hat to be sorted into a house, then enjoy the food served in the hall.");
	}
		else
			System.out.println("This person is not here!");
	}
	//overwriting the activity function
	public void activity(String test) {
		//changing all input to lowercase 
		test = test.toLowerCase();
	while(test != null) {
		//try {
		if(test.contains("walk") || test.contains("leave")) {
			walk();
			break;
			}
		else if(test.contains("look")) {
			look();
			test = next_a();
			}
		else if(test.contains("talk")) {
			talk(test);
			test = next_a();
			}
		else if(test.contains("hold") || test.contains("use")) {
			hold(test);
			test = next_a();
			}
		else if(test.contains("mischief managed")) {
			end();
		}
		else
			{System.out.println("That is not a valid command");
			test = next_a();}
			//throw new MyException_d("That is not a valid command");
		//}catch(MyException_d exp){
		//	System.out.println(exp) ;
		//	test = next_a();				
			//}		
	}
	}
}
