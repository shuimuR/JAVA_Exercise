class Person
{
	String name;
	String GetName()
	{
		return name;
	}
}


public class oop
{
	public static void main(String args[])
	{
		Person p1 = null;
		p1 = new Person();
		p1.name = "zhangsan";
		
		Person p2 = new Person();
		p2.name = "Lisi";
		
		System.out.println(p1.GetName());
		System.out.println(p2.GetName());
	}
}
