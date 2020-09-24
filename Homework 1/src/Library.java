

import java.util.Random;
import java.util.Scanner;
/*
class MyException_L extends Exception{
		String str1;
		MyException_L(String str2) {
			str1=str2;
		   }
	  public String toString(){ 
		return ("That is not a valid command!") ;
	   }
	}
	*/
public class Library extends Location implements Behaviour, Character{
	public Library()
	{super.room = "Library";}
	Scanner input = new Scanner(System.in);
	//Location functions
	public void look(){ System.out.println("Once the academic year starts, students spend a lot of their time in the school library. Amongst those students that you can talk to is Hermione.\nIn the library, you find a book you can read, and a quill you can write with.");}
	
	//Behavior functions
	public void hold(String a) {
		if(a.contains("book"))
		 {
			String[] list = {"The Standard Book of Spells Year 1 by Miranda Goshawk", "Gadding with Ghouls by Gilderoy Lockhart", "Home Life and Social Habits of British Muggles", "Advanced Potion-Making by Libatius Borage"};
	        Random rand = new Random(); 
	        int randomNumber=rand.nextInt(list.length); 
	        System.out.println("You pick up " + list[randomNumber] + " and read it."); 
		}
		else if (a.contains("quill"))
		{		System.out.println("You pick up the quill and write notes for your next class");}
		else 
		System.out.println("This item is not here!");
	}
	
	//Character functions	
	public void talk(String p) {
		if (p.contains("hermione")) {
		System.out.println("Welcome to the library, here you can read many books and write all the notes you need for your classes and always remeber, its leviOsa not leviosA!");}
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
		else if(test.contains("talk")) {
			talk(test);
			test = next_a();
			}
		else if(test.contains("read") || test.contains("hold") || test.contains("use")) {
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
			/*throw new MyException_L("That is not a valid command");
		}catch(MyException_L exp){
			System.out.println(exp) ;
			test = next_a();				
			}*/
	}
}
}