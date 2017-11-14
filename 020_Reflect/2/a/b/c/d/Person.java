package a.b.c.d;

public class Person
{
	private String name;
	
	void SetName(String name)
	{
		this.name = name;
	}
	
	String GetName()
	{
		return name;
	}
	
	public Person()
	{
		System.out.println("Construct person with no parameter");
	}
	
	public Person(String name)
	{
		this.name = name;
		System.out.println("Construct person with String para");
	}
}
