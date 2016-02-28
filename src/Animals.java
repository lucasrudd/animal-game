import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

class Inventory{
	Inventory()
	{
		this.Money = 100;
		this.Food = 60;
	}
	
	void IncreaseMoney(int Income)
	{
		this.Money = this.Money + Income;
	}
	
	void addAnimal(Animal newAnimal)
	{
		AllAnimalVector.addElement(newAnimal);
	}

	Animal accessPet(String animalName)
	{
		for(int i =0; i < AllAnimalVector.size(); i++)
		{
			if(AllAnimalVector.get(i).getname().equals(animalName))
				{
					return AllAnimalVector.get(i);
				}
			else if(i == AllAnimalVector.size()-1)
			{
				System.out.println("You have no animal named " + animalName + ".");
				return null;
			}
		}
		return null;
	}
	
	String allAnimals(int i)
	{
		String animalName = AllAnimalVector.get(i).getname();
		return animalName;
	}
	
	int getNumOfAnimals()
	{
		return this.AllAnimalVector.size();
	}
	
	int getMoney()
	{
		return this.Money;
	}
	
	int getfood()
	{
		return this.Food;
	}
	
	void SetPlayerName(String PlayerName)
	{
		this.Name = PlayerName;
	}
	
	String getPlayerName()
	{
		return this.Name;
	}
	Vector<Animal> AllAnimalVector = new Vector<Animal>();
	protected int Money;
	protected int Food;
	protected String Name;
}




class Store{
	Store()
	{
		
	}
	
	void buyMeat(Inventory i)
	{
		
		while(true)
		{
			Scanner input = new Scanner(System.in);
			System.out.println("How much meat do you want to buy?...");
			int AmountToBuy = input.nextInt();
			if(i.Money >= (AmountToBuy)*PriceMeat)
			{
				i.Money = i.Money - (AmountToBuy)*PriceMeat;
				i.Food = i.Food + (AmountToBuy)*10;
			}
			else if(i.Money < (AmountToBuy)*PriceMeat)
			{
				System.out.println("You do not have enough Money to buy " + AmountToBuy + " bundles of meat.");
			}
		}
	}
	
	
	int buyToy(Inventory i)
	{
		
		while(true)
		{
			Scanner input = new Scanner(System.in);
			System.out.println("How many toys would you like to buy?");
			int AmountToBuy = input.nextInt();
			if(i.Money >= (AmountToBuy)*PriceToy)
			{
				i.Money = i.Money - (AmountToBuy)*PriceToy;
				return AmountToBuy;
			}
			else if(i.Money < (AmountToBuy)*PriceToy)
			{
				System.out.println("You do not have enought Money to buy " + AmountToBuy + " toys.");
			}
		}
	}
	
	
	
	private int PriceMeat = 30;
	private int PriceToy = 100;
	private int PriceCat = 2000;
	private int PriceDog = 2500;
	
}




class Animal {
	private String Name;
	protected String AnimalType;
	protected String Pet;
	protected int CaptureChance = 90;
	protected String MakeHappyNoise()
	{
		return "";
	}
	protected String MakeAngryNoise()
	{
		return "";
	}
	protected String MakeHungryNoise()
	{
		return "";
	}
	
	
	//Maybe make different animals easier/harder to catch
	//Like, dog easy, cat slightly harder, elephant super hard, etc.
    public boolean Capture(int Charm)
    {
    	Random rand = new Random();
    	int n = rand.nextInt(101);
    	this.CaptureChance = this.CaptureChance - Charm;
    	if(n >= CaptureChance)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
    
    public String getname()
    {
    	return this.Name;
    }
    public void setname(String names)
    {
    	this.Name = names;
    }
    protected void setanimal(String animal)
    {
    	this.AnimalType = animal;
    }
    protected String getanimaltype()
    {
    	return "";
    }
}

//END ANIMAL

	class Dog extends Animal{
		Dog()
		{
			Random RandName = new Random();
			int RandomNameIterator = RandName.nextInt(12);
			this.setname(Names[RandomNameIterator]);
			this.setanimal("dog");
		}
		
		private String[] Names = {"Fido", "Spike", "Henry", "Coco", "Dilly", "Rango", "Satan", "Bowser", "Lulu", "Sasha", "Spark Plug", "Worm"};
		private String[] HappyBarks = {"woof woof!", "bark", "*wags tail*", "arf arf", "*licks face*"};
		private String[] AngryBarks = {"Grrr!", "Grawrr", "RRRRRRR", "*snarlns*", "gnashes teeth and foams at the mouth*"};
		
		public String MakeHappyNoise(){
    		Random RandHappyBarks = new Random();
    		int RandomHappyBarksIterator = RandHappyBarks.nextInt(5);
    		return HappyBarks[RandomHappyBarksIterator];
    	}
    	
    	public String MakeAngryNoise(){
    		Random RandAngryBarks = new Random();
    		int RandomAngryBarksIterator = RandAngryBarks.nextInt(5);
    		return AngryBarks[RandomAngryBarksIterator];
    	}
    	public String getanimaltype()
    	{
    		return AnimalType;
    	}
	}
	//END DOG


    class Cat extends Animal{
    	Cat()
    	{
    		Random RandName = new Random();
    		int RandomNameIterator = RandName.nextInt(12);
    		this.setname(Names[RandomNameIterator]);
    		this.setanimal("cat");
    	}
    	
    	private String[] Names = {"BitchAss", "Jackson", "Shadow", "Alexander", "Muffin", "Buffy", "Erikson", "Tiger", "Fluffy", "Marshmallow", "He Ran Away", "Peteson"}; 
    	private String[] HappyMeows = {"Meow", "Mwr", ":3", "Mwrawrrr!", "Purrrrrrr", "Meowwow"}; 
    	private String[] AngryMeows = {"Hisssss", "Gwrawrn!", "Grorwwwrrrrwrr", "NNNNAAAAWWRRR!",};
    	
    	public String MakeHappyNoise(){
    		Random RandHappyMeows = new Random();
    		int RandomHappyMeowsIterator = RandHappyMeows.nextInt(6);
    		return HappyMeows[RandomHappyMeowsIterator];
    	}
    	
    	public String MakeAngryNoise(){
    		Random RandAngryMeows = new Random();
    		int RandomAngryMeowsIterator = RandAngryMeows.nextInt(4);
    		return AngryMeows[RandomAngryMeowsIterator];
    	}
    	
    	public String getanimaltype()
    	{
    		return AnimalType;
    	}
    
    }
    
    //END CAT
    
//BEGIN MAIN
public class Animals {
	
	//main function
	//try to keep as little as possible here, use objects and functions, mainly only game loop and start up checks
    public static void main(String[] args){
    	
    	Inventory i = new Inventory();	//inventory initialization: CAUTION
    									//Inventory() causes Money and Food to be set to predetermined values which loading the game will override
    	
    	Store general = new Store();	//store initialization
    									//not sure what to do with the store yet...
    	
    	boolean gameEnd = false;	//gameEnd check
    
    	String gameFile = "C:\\Users\\Lucas\\Java Programs\\AnimalGame\\src\\gameInfo.txt";	//save file
    																						//MAYBE THINK OF SAVING THE GAME ELSEWHERE
    	Scanner input = new Scanner(System.in);
    	
    	if(HasPlayedBefore(gameFile, i) == false)	//check if there is a save file
    	{
    		Introduction(i);
    	}
    	
    	else	//if so, welcome the user and start the game as normal
    	{
    		WelcomeBack(i);
    	}
    	
    	while(!gameEnd)	//Main game loop
    					//KEEP EVERYTHING HERE EXCEPT SAVING AND LOADING
    	{
    		System.out.println("Now you're ready to rangle some animals! Type 'catch' to get in the action!");
    		System.out.println("Or type 'home' to go home and play with your animals!");
    		System.out.println("Or, if you're out of money type 'work'.");
    		if(input.next().equals("catch"))
    		{
    			CatchAnimal(i);
    		}
    		if(input.next().equals("home"))
    		{
    			Home(i);
    		}
    		if(input.next().equals("exit"))
    		{
    			gameEnd = true;
    		}
    		else
    		{
    			System.out.println("Type 'exit' to exit the game.")
    		}
    	}
    	
    	SaveGame(gameFile, i);	
    	input.close();
    	System.out.println("game end");	//get rid of this later
    }

    //Does nothing but outputs a welcome back line
    //FIISHED
    static void WelcomeBack(Inventory i)
    {
    	System.out.println("Oh, " + i.getPlayerName() + ", welcome back to Inuko!!");
    }
    
    //Checks to see if there is a save file, if so then the user has played before (returns true), if not returns false
    //FINISHED
    static boolean HasPlayedBefore(String file, Inventory i)
    {
    	if(ReadFile(file, i) == true)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
    //Saves userName, food, money, animal types and animal names
    //FINISHED
    //NEED TO SAVE...
    //AMOUNT OF FOOD
    //AMOUNT OF Money
    //ALL ANIMAL NAMES/TYPES/AND DISPOSITION
    //STORE INVENTORY MAYBE
    static boolean SaveGame(String file, Inventory i)
    {
    	String Food = String.valueOf(i.getfood());
    	String Money = String.valueOf(i.getMoney());
    	String PlayerName = i.getPlayerName();
    	try {
    		String animalName;
    		System.out.println("Saving... Please wait.");
    		File Savefile = new File(file);
			BufferedWriter output = new BufferedWriter(new FileWriter(Savefile));
			Animal tempAnimal;
			output.write(PlayerName);
			output.write(":");
			output.write(Food);
			output.write(":");
			output.write(Money);
			
			for(int j = 0; j < i.getNumOfAnimals(); j++)
			{
				animalName = i.allAnimals(j);
				tempAnimal = i.accessPet(animalName);
				output.write(":" + tempAnimal.getanimaltype() + ":" + animalName);
			}
			
    		//output.write(i.getfood());
			//output.write(i.getMoney());
			//output.write(i.allAnimals());
			output.close();
		} catch (IOException e) {
			System.out.println("Error! Could not save game.");
		}
    	return true;
    }
    
    //If there is no file returns false, if there is then reads it and sets values equal to what the save file tells it to
    //FINISHED
    static boolean ReadFile(String file, Inventory i){
    	try
    	{
    		Scanner fileScanner = new Scanner(new File(file)).useDelimiter(":");
    		String line = "";
    		int lineNumber = 0;
    		Animal tempAnimal;
    		while(fileScanner.hasNext())
    		{
    			line = fileScanner.next();
    			if(lineNumber == 0)
    			{
    				i.Name = line;
    			}
    			if(lineNumber == 1)
    			{
    				i.Food = Integer.parseInt(line);
    			}
    			else if(lineNumber == 2)
    			{
    				i.Money = Integer.parseInt(line);
    			}
    			else if(line.equals("dog"))
    			{
    				tempAnimal = new Dog();
    				line = fileScanner.next();
    				tempAnimal.setname(line);
    				i.addAnimal(tempAnimal);
    			}
    			else if(line.equals("cat"))
    			{
    				tempAnimal = new Cat();
    				line = fileScanner.next();
    				tempAnimal.setname(line);
    				i.addAnimal(tempAnimal);
    			}
    			lineNumber++;
    		}
    		return true;
    	}
    	catch (FileNotFoundException e)
    	{
    		return false;
    	}
    }
    
    
    /**********************NEED ERASE AND NEW GAME FUNCTIONS*****************************/
    
    
    //Introduction on start-up.
    //if user has played this is not initiated, if the user has not then this function
    //gives them a free animal and goes over instructions on how to play the game
    //FINISHED
    
    
    static void Introduction(Inventory i)
    {
    	Scanner input = new Scanner(System.in);
    	System.out.println("Hello and welcome to Inuko! The interactive virtual pet game.");
    	System.out.println("Why don't you start by telling me your name?");
    	String PlayerName = input.next();
    	i.SetPlayerName(PlayerName);
    	
    	System.out.println("Well, " + i.getPlayerName() + ", to begin, why don't we give you a new pet to play with?");
    	i.addAnimal(PickAnimal());
    	System.out.println("Now that you have a pet, why don't you try playing with it?\n");
    	System.out.println("To interact with your pet first go home by typing 'home', then type 'accesspet' and type in your pet's name.");
    	boolean gohome = false;
    	while(!gohome)
    	{
        	String home = input.next();
        	home = home.toLowerCase();
    		if(!home.equals("home"))
    		{
    			System.out.println("Type 'home' to go to your house.");
    		}
    		else
    		{
    			gohome = true;
    			Home(i);
    		}
    	}
    	return;
    }
    
    
    //At home you can access your pets and pet/scold them
    //Home will tell you all the pets you own and wait for a response
    //WILL BE ADDING A FEED OPTION, A WAY TO SAVE PET DISPOSITIONS, AND AN OPTION TO TEACH PETS TRICKS
    /*************************NEEDS WORK*****************************/
    static void Home(Inventory i)
    {
    	Animal myCurrentAnimal;
    	Scanner input = new Scanner(System.in);
    	System.out.println("To access a pet to interact with type 'accesspet' to go back to the main menu type 'main.'");
    	boolean trueHome = true;
    	while(trueHome)
    	{
    		String response = input.next().toLowerCase();
    		if(response.equals("accesspet"))
    		{
    			System.out.println("The pets you own are named: ");
    			for(int j = 0; j < i.getNumOfAnimals(); j++)
    			{
    				System.out.println(i.allAnimals(j));
    			}
    			System.out.println("Type the name of the pet you wish to interact with.");
    			String animalName = input.next();
    			myCurrentAnimal = i.accessPet(animalName);
    			Interact(myCurrentAnimal);
    			trueHome = false;
    		}
    		else if(response.equals("main"))
    		{
    			return;
    		}
    		else
    		{
    			System.out.println("To go back type 'main,' or to play with a certain pet type 'accesspet.'");
    		}
    		
    		return;
    	}
    	
    }
    
    
    //Nothing yet really
    //Gives options to buy meat (food for animals) or toys, but there isn't a lot of functionality with either yet
    //NEEDS TO ADD A BUY ANIMAL OPTION
    /*******************NEEDS WORK*****************/
    static void StoreChoice(Store g, Inventory i)
    {
    	Scanner input = new Scanner(System.in);
    	boolean t = true;
    	while(t)
    	{
    		String choice = input.next();
    		choice = choice.toLowerCase();
    		if(choice.equals("meat"))
    		{
    			g.buyMeat(i);
    			System.out.println("If you would like to buy something else, type it in now, else type 'main' to return to the main menu.");
    		}
    		else if(choice.equals("toy"))
    		{
    			g.buyToy(i);
    			System.out.println("If you would like to buy something else, type it in now, else type 'main' to return to the main menu.");
    		}
    		else if(choice.equals("main"))
    		{
    			return;
    		}
    		/*else if(choice.equals("dog"))
    		{
    			g.buyDog(i);
    		}
    		else if(choice.equals("cat"))
    		{
    			g.buyCat(i);
    		}*/
    		else
    		{
    			System.out.println("Type 'meat' to buy meat, 'toy' to buy toys, 'dog' to buy a new dog, or 'cat' to buy a new cat.");
    			System.out.println("Or type 'main' to return to the main menu.");
    		}
    	}
    }
    
    
    
    //Allows the user to interact with the pet that they pass through this function
    //Need to allow the user to play games like fetch, roll over, etc.
    //Also need to allow the user to feed their animals and need to make it possible for animals to get hungry, sick, etc
    /************************NEEDS WORK*********************/
    static void Interact(Animal myPet)
    {
    	Scanner user_input = new Scanner(System.in);
    	boolean i = true;
    	System.out.print("To interact with your " + myPet.getanimaltype() + ", please type 'pet' or 'scold'; if you wish to end please type 'end.'");
    	while(i)
    	{
    		String response = user_input.next();
    		response = response.toLowerCase();
    		if(response.equals("end"))
    		{
    			i = false;
    		}
    		else if(response.equals("pet"))
    		{
    			System.out.print("Your " + myPet.getanimaltype() + ", " + myPet.getname() + " says " + myPet.MakeHappyNoise());
    		}
    		else if(response.equals("scold"))
    		{
    			System.out.print("Your " + myPet.getanimaltype() + ", " + myPet.getname() + " " + myPet.MakeAngryNoise());

    		}
    		else
    		{
    			System.out.print("To interact with your " + myPet.getanimaltype() + " please type 'pet' or 'scold'; if you wish to end please type 'end.'");
    		}
    	}
    	return;
    }
    
    //Initiates a small game in which the user attempts to catch an animal in the wild
    //Need to make this harder or slightly different, think pokemon
    /***************NEEDS A LITTLE BIT OF WORK *********************/
    static Animal CatchAnimal(Inventory i)
    {
    	Scanner input = new Scanner(System.in);
    	int FoodChance = 10;
    	Animal[] RANDOMANIMAL = {new Cat(), new Dog()};
    	Random RandAnimal = new Random();
      	int RandAnimalIterator = RandAnimal.nextInt(2);
    	Animal WildAnimal = RANDOMANIMAL[RandAnimalIterator];
    	System.out.println("You have come across a wild " + WildAnimal.getanimaltype() +"!");
    	System.out.println("To catch it try giving it food. To feed type 'feed,' to flee type 'flee':");
    	boolean flee = false;
    	boolean Catch;
    	while(!flee)
    	{
    		String animalcatcher = input.next();
    		animalcatcher = animalcatcher.toLowerCase();
    		if(animalcatcher.equals("feed") && (i.Food != 0))
    			{
    				Catch = WildAnimal.Capture(FoodChance);
    				i.Food = i.Food - 10;
    				if(Catch == true)
    				{
    					System.out.println("You have caught a " + WildAnimal.getanimaltype() + "!");
    					System.out.println("Would you like to name your " + WildAnimal.getanimaltype() +"?");
    					String response = input.next();
    					response = response.toLowerCase();
    					if(response.equals("yes"))
    					{
    						System.out.println("What would you like to name your new " + WildAnimal.getanimaltype() + "?");
    						response = input.next();
    						WildAnimal.setname(response);
    						i.addAnimal(WildAnimal);
    						System.out.println("Your " + WildAnimal.getanimaltype() + " has been named " + WildAnimal.getname() +".");
    						System.out.println("Take good care of " + WildAnimal.getname() + "!");
    					}
    					else
    					{
    						i.addAnimal(WildAnimal);
    						System.out.println("Your new " + WildAnimal.getanimaltype() +" has been given the name " + WildAnimal.getname() + ".");
    					}
    					
    					return WildAnimal;
    				}
    				else if(Catch == false)
    				{
    					System.out.println("The " + WildAnimal.getanimaltype() + " does not want to come with you.");
    				}
    				if(i.Food == 0)
    				{
    					System.out.println("You are out of food");
    					return null;
    				}
    			}
    		else if(animalcatcher.equals("flee"))
    			{
    				System.out.println("You have fled");
    				return null;
    			}
    		else
    		{
    			System.out.println("Please type 'feed' or 'flee.'");
    		}
    	}
    	return null;
    }
    
    
    
    //The first animal you pick when the introduction starts up
    //FINISHED
    static Animal PickAnimal()
    {
    	Animal myAnimal;
    	Animal[] RANDOMANIMAL = {new Cat(), new Dog()};
    	System.out.print("What animal would you like? A dog, or a cat?");
    	Scanner user_input = new Scanner(System.in);
    	String AnimalType = user_input.next();
    	AnimalType = AnimalType.toLowerCase();
      	if(AnimalType.equals("dog"))
      	{
      		myAnimal = new Dog();
      		System.out.println("What would you like to name your " + myAnimal.getanimaltype() + "?");
      		String DogName = user_input.next();
      		myAnimal.setname(DogName);
      		System.out.println("Your " + myAnimal.getanimaltype() + " has been named " + myAnimal.getname() + "!");
      	
      		return myAnimal;
      	}
      	
      	else if(AnimalType.equals("cat"))
      	{
      		myAnimal = new Cat();
      		System.out.print("What would you like to name your " + myAnimal.getanimaltype() + "?");
      		String CatName = user_input.next();
      		myAnimal.setname(CatName);
      		System.out.println("Your " + myAnimal.getanimaltype() + " has been named " + myAnimal.getname() + "!");
      		
      		return myAnimal;
      	}
      	else
      	{
          	Random RandAnimal = new Random();
          	int RandAnimalIterator = RandAnimal.nextInt(2);
          	myAnimal = RANDOMANIMAL[RandAnimalIterator];
          	System.out.println("You have been assigned a " + myAnimal.getanimaltype() + " named " + myAnimal.getname() + ". Take good care of " + myAnimal.getname() +"!");
          	
           	return myAnimal;
      	}
      	
    }
}

//END 