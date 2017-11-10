class PersonMore
{
	String name;
	short age;
	
	static int count = 0;
	
	String GetName()
	{
		return name;
	}
	
	short GetAge()
	{
		return age;
	}
	
	public PersonMore()
	{
		
	}
	
	public PersonMore(String name)
	{
		
		this.name = name;
	}
	
	//gouzao block, every time creat the object, it will run the block
	{
		count++;
	}
	
	//static block code, before define a object, it runs, it runs only one time for all programe
	static 
	{
		System.out.println("This is static block code");
	}
	
	public PersonMore(String name, int age)
	{
		this.name = name;
		this.age = (short)age;
	}
	
	public void PrintInfo()
	{
		System.out.println(this.GetName() + " age is " + this.GetAge());
	}
	
	static void PrintClass()
	{
		System.out.println("This is person class");
	}
}


public class Gouzao
{
	public static void main(String args[])
	{
		PersonMore p1 = null;
		p1 = new PersonMore();
		p1.name = "zhangsan";
		p1.age = 16;
		
		PersonMore p2 = new PersonMore("Lisi", 18);
		
		p1.PrintInfo();
		p2.PrintInfo();
		PersonMore.PrintClass();			//no object, it's static, the function of the class
		System.out.println("Count is " + PersonMore.count);		//the class perporty, it's like attribute
	}
}
