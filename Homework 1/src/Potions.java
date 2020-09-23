import java.util.Random;
import java.util.Scanner;
/*class MyException_P extends Exception{
		String str1;
		MyException_P(String str2) {
			str1=str2;
		   }
	   public String toString(){ 
		return ("That is not a valid command!") ;
	   }
	}
	*/
public class Potions extends Location implements Behaviour, Character{
	public Potions()
	{super.room = "Potions Classroom";}
	Scanner input = new Scanner(System.in);
	//Location functions
	@Override
	public void look(){ System.out.println("Potions is one of the core subjects that first year students are required to study. In the potions class there is Professor Snape who teaches the subject.\nThe Potions Classroom is full of equipment and material that you can use including a cauldron to make potions, and a potion to drink that casts a magical spell.");}

	//Behavior function
	public void hold(String a) {
		String[] list = {"Amortentia", "Polyjuice", "Felix Felicis", "Draught of Peace"};
        Random rand = new Random(); 
        int randomNumber=rand.nextInt(list.length);
        String potion = list[randomNumber];
		if(a.contains("cauldron"))
		 {
	        System.out.println("You stir the ingredients in the caldron together and create " + potion + " potion."); 
		}
		else if (a.contains("potion"))
		{		System.out.println("You take a sip of the " + potion + " potion");}
		else 
		System.out.println("This item is not here!");
	}
	
	//Character function	
	public void talk(String p) {
		if (p.contains("snape")) {
		System.out.println("Welcome to the Potions classroom, My name is Professor Snape and I don't tolerate laziness in my classroom.");
	}
		else
			System.out.println("This person is not here!");
	}
	
	public void activity(String test) {
	
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
		else if(test.contains("talk") ) {
			talk(test);
			test = next_a();
			}
		else if(test.contains("use") || test.contains("hold")) {
			hold(test);
			test = next_a(); 
			}
		else if(test.contains("drink") || test.contains("eat")) {
			hold(test);
			test = next_a();
		}
		else if(test.contains("mischief managed")) {
			end();
		}
		else
		{
			System.out.println("That is not a valid command");
			test = next_a();
		}
		}
		/*	throw new MyException_P("That is not a valid command");
		}catch(MyException_P exp){
			System.out.println(exp) ;
			test = next_a();				
			}*/
	}
}