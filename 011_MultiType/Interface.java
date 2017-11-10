class Father
{
	public void PrintInfo()
	{
		System.out.println("This is father");
	}
}


class Son extends Father
{
	public void PrintInfo()
	{
		System.out.println("This is Son");
	}
	
	
}

class Daughter extends Father
{
	public void PrintInfo()
	{
		System.out.println("This is Daughter");
	}
}

class MultiType
{
	public static void main(String args[])
	{
		Son son1 = new Son();
		Daughter dau = new Daughter();
		Father f = son1; 
		f.PrintInfo();
		//error, the type is father, there's no playgame type	
		f.PlayGame();
	}
}
