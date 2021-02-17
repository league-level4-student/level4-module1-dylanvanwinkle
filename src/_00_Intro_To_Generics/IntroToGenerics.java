package _00_Intro_To_Generics;

import java.util.Random;

// Generics in Java are a way to define one variable that can act as different types.
// Generics can be used in methods and classes. 
// The syntax for generics are the angle brackets <>


public class IntroToGenerics {
	public static void main(String[] args) {
		IntroToGenerics i = new IntroToGenerics();
		
		String s = "taco";
		//Here we are calling calcStuff and passing in a String
		i.calcStuff(s, 5);
		
		Random r = new Random();
		//Here we are calling calcStuff and passing in a Random object
		i.calcStuff(r, 6);
		
		//Here we create two object of the SomeClass class and 
		//define its generic variable to be two different types, String and Integer
		SomeClass<String> scObj = new SomeClass<String>("sodapop");
		SomeClass<Integer> scObj2 = new SomeClass<Integer>(412);
	}
	
	//Here a generic called Template is created as part of the calcStuff method
	//The variable t can be any type: String, Object, Robot... whatever
	public <Template> Template calcStuff(Template t, int r) {
		for (int i = 0; i < r; i++) {
			System.out.println(t);
		}
		
		return t;
	}
}

//Here a class is created that has a generic called AotherTemplate
//Class generics must be a class, not a primitive data type: int, float, double, boolean, long, short, byte
class SomeClass<AnotherTemplate>{
	//Here the t variable can be any object type
	AnotherTemplate t;
	
	//Here the t2t variable can be any object type
	SomeClass(AnotherTemplate t2){
		this.t = t2;
	}
}


