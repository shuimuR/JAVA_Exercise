
interface A
{
	public void PrintInfo();
}

class B implements A
{
	public void PrintInfo()
	{
		System.out.println("Hello world!");
	}
}

public class Annoy
{
	public static void main(String args[])
	{
		B b = new B();
		TestFun(b);
		//匿名类
		TestFun(new A()
		{
			public void PrintInfo()
			{
				System.out.println("Hello Hoo!");
			}
		});
	}
	
	public static void TestFun(A a)
	{
		a.PrintInfo();
	}
}
