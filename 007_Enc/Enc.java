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
}

public class Enc
{
	public static void main(String args[])
	{
		Person per = new Person();
		per.setAge(201);
		per.setAge(50);
		System.out.println("The age is " + per.getAge());
	}
}
