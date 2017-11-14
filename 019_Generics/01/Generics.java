
class Person<T, N>
{
	private T age;
	private N name;
	
	public void SetAge(T age)
	{
		this.age = age;
	}
	
	public T GetAge()
	{
		return age;
	}
}

public class Generics
{
	public static void main(String args[])
	{
		Person<String, String> p = new Person<String, String>();
		p.SetAge("3 years old");
		System.out.println(p.GetAge());
		
		Person<Integer, String> p1 = new Person<Integer, String>();
		p1.SetAge(3);
		System.out.println(p1.GetAge());
	}
}
