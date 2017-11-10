class Person
{
	private int age;
	public void setAge(int age)
	{
		if(age < 0 || age > 200)
		{
			System.out.println("Age out of range(0---200)");
			age = 0;
		}
		else
			this.age = age;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public Person()
	{
		System.out.println("Person construction");
	}
	
	public Person(int age)
	{
		this.age = age;
		System.out.println("Person age set automatically");
	}
}

class Students extends Person
{
	private String school;
	
	// auto run the father class construction function
	public Students(String sch)
	{
		super(9);
		school = sch;
	}
	
	Students()
	{
		super(7);
	}
	
	public void SetSchool(String str)
	{
		school = str;
	}
	
	public String GetSchool()
	{
		return school;
	}
}

public class Ext
{
	public static void main(String args[])
	{
		Students stu1 = new Students();
		stu1.setAge(205);
		System.out.println("The age is " + stu1.getAge());
		
		Students stu2 = new Students("Yongchang first middle school");
		System.out.println("Stu2 school is " + stu2.GetSchool());
		System.out.println("Stu2 age is " + stu2.getAge());
	}
}
