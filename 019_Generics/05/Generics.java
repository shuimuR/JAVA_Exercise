
interface Person<T>
{	
	public void SetAge(T age);
	
	public T GetAge();
}

class Student<T extends Number> implements Person<T>
{
	T age;
	public void SetAge(T age)
	{
		this.age = age;
	}
	
	public T GetAge()
	{
		return age;
	}
}

class Student2 implements Person<Integer>
{
	Integer age;
	public void SetAge(Integer age)
	{
		this.age = age;
	}
	
	public Integer GetAge()
	{
		return age;
	}
}

public class Generics
{
	public static void main(String args[])
	{		
		Student<Integer> s = new Student<Integer>();
		s.SetAge(6);
		PrintInfon(s);
		PrintInfo(s);
		
		Student2 s2 = new Student2();
		s2.SetAge(18);
		PrintInfo(s2);
	}
	
	public static void PrintInfo(Person<?> p)
	{
		System.out.println(p.GetAge());
	}
	
	public static <T> void PrintInfon(Person<T> p)
	{
		System.out.println(p.GetAge());
	}
	
}
