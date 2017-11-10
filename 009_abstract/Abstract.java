abstract class Father
{
	public abstract void Study();
}

class Son extends Father
{
	public void Study()
	{
		System.out.println("Son study");
	}
}

class Abstract
{
	public static void main(String args[])
	{
		Son son1 = new Son();
		son1.Study();
	}
}
