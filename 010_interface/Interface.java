abstract class Father
{
	public abstract void Study();
}

interface A
{
	int i = 10;
	int getNum();
}

interface B
{
	public static String name = "InterfaceB";
	public abstract String getName();
}


class Son extends Father implements A,B
{
	public int getNum()
	{
		return i;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void Study()
	{
		System.out.println("The son is studying...");
	}
}

class Interface
{
	public static void main(String args[])
	{
		Son son1 = new Son();
		System.out.println("The number is " + son1.getNum() + " the name is " + son1.getName());
	}
}
