package a.b.c.d;

class Person
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
}

public class Reflect
{
	public static void main(String args[])
	{
		Person p = new Person();
		Class<?> c1 = null;
		try
		{
			c1 = Class.forName("a.b.c.d.Person");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		Class<?> c2 = p.getClass();
		Class<?> c3 = Person.class;
		
		System.out.println(c1.getName());
		System.out.println(c2.getName());
		System.out.println(c3.getName());
		
		int arr[] = {1,2,3,4};
		int arr2[] = {1,2,3,4,5};
		int arr3[][] = {{1,2,3,4,5}, {2,4}};
		Class<?> c4 = arr.getClass();
		Class<?> c5 = arr2.getClass();
		Class<?> c6 = arr3.getClass();
		System.out.println(c4.getName());
		
		System.out.println((c4 == c5));
		System.out.println((c4 == c6));
		
		Class<?> c7 = int.class;
		System.out.println(c7.getName());
	}
}
