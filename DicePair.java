package pairOfDice.copy;

public class  DicePair extends Die
{
	//member variables
	private int facevalueDie2; // second die
	
	//constructor
	public DicePair(){super();
	facevalueDie2 = 1;}
	
	//member functions
	public void setFaceValues(int value1, int value2) 
	{
		setFaceValue(value1); //die1
		facevalueDie2 = value2;//die 2
	}
	
	public int getFaceValue1() 
	{
		return getFaceValue();
	}
	
	public int getFaceValue2() 
	{
		return facevalueDie2;
	}
	
	public String toString()
	{
		String result2 = Integer.toString(facevalueDie2);
		String result = "The value for die 1 is: " + super.toString() + " \n and the value for die 2 is: " + result2;
		
		return result;
	}
	
	public int rollDice1() 
	{
		return super.roll();
	}
	
	public int rollDice2()
	{
		facevalueDie2 = (int)(Math.random() * MAX) + 1;
		return facevalueDie2;
	}
	
	public int sumDie() 
	{
		int sum = facevalueDie2 + super.faceValue;
		return sum;
		
	}
	
	
}//end class
