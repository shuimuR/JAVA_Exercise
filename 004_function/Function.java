
public class Function
{
	public static void main(String args[])
	{
		System.out.println(add(1, 2));
		System.out.println(add(1, 2, 3));
		System.out.println(add(1.0f, 2.0f));
	}
	
	public static int add(int a, int b)
	{
		return a+b;
	}
	
	public static int add(int a, int b, int c)
	{
		return a + b + c;
	}
	
	public static float add(float a, float b)
	{
		return a+b;
	}
}
