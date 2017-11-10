class Father
{
	public void PrintInfo()
	{
		System.out.println("This is father");
	}
	
	public void Drink()
	{
		System.out.println("Father is drinking");
	}
}


class Son extends Father
{
	public void PrintInfo()
	{
		System.out.println("This is Son");
	}
	
	public void PlayGame()
	{
		System.out.println("Son is playing game");
	}
}

class Daughter extends Father
{
	public void PrintInfo()
	{
		System.out.println("This is Daughter");
	}
	
	public void Dance()
	{
		System.out.println("Daughter is dancing");
	}
}

class MultiType
{
	public static void main(String args[])
	{
		Father f = new Father();
		Son s = new Son();
		Daughter d = new Daughter();
		
		Print(f);
		Print(d);			//If there's no comfort function, JAVA will change to father class to adapt the function, convert type to father
		Print(s);
		
		Father f1 = new Father();
		Son s1 = new Son();
		Daughter d1 = new Daughter();
		PrintAction(f1);
		PrintAction(s1);
		PrintAction(d1);
	}
	
	public static void Print(Father f)
	{
		f.PrintInfo();
	}
	
	public static void PrintAction(Father f)
	{
		if(f instanceof Daughter)
		{
			Daughter d = (Daughter)f;
			d.Dance();
		}
		else if(f instanceof Son)
		{	
			Son s = (Son)f;
			s.PlayGame();
		}
		else if(f instanceof Father)
			f.Drink();
	}
}
