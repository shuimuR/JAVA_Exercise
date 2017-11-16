
public class Hello
{
	private String name;
	private int age;
	public static void main(String args[])
	{
		System.out.println("Hello world\n");
	}
	
	public int SayHelloTo(String name)
	{
		System.out.println("Hello, " + name);
		return 123;
	}
	
	public int SayHelloTo2(String str)
	{
		System.out.println("Hello, " + name + ", age is " + age);
		return 456;
	}
}
