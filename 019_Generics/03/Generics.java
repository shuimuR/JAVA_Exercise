
class Person<T>
{
	private T age;
	
	public void SetAge(T age)
	{
		this.age = age;
	}
	
	public T GetAge()
	{
		return age;
	}
}

class Student<T> extends Person<T>
{
	
}

class Student2 extends Person<String>
{
	
}

public class Generics
{
	public static void main(String args[])
	{
		Person<String> p = new Person<String>();
		p.SetAge("3 years old");
		PrintInfo(p);
		
		Person<Integer> p1 = new Person<Integer>();
		p1.SetAge(3);
		PrintInfo(p1);
		
		Person<?> p2;
		p2 = p;
		//p2.SetAge("9 years old");
		p2.GetAge();
		
		PrintInfon(p);
		PrintInfon(p1);
		PrintInfon(p2);
		
		Student<Integer> s = new Student<Integer>();
		s.SetAge(18);
		PrintInfon(s);
		PrintInfo(s);
		
		Student2 s2 = new Student2();
		s2.SetAge("16 years old");
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
