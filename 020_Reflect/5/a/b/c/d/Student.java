package a.b.c.d;

public class Student
{
	private String name;
	
	public void SetName(String name)
	{
		this.name = name;
	}
	
	public String GetName()
	{
		return name;
	}
	
	public Student()
	{
		System.out.println("Construct Student with no parameter");
	}
	
	public Student(String name)
	{
		this.name = name;
		System.out.println("Construct Student with String para");
	}
}
