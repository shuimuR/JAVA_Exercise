
class Outer
{
	private static int a = 10;
	static class Inner
	{
		public void PrintInfo()
		{
			System.out.println("a = " + a);
		}
	}
}

public class Inner
{
	public static void main(String args[])
	{
		Outer.Inner i = new Outer.Inner();
		i.PrintInfo();
	}
}
