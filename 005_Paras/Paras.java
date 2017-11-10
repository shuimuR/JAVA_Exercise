
public class Paras
{
	public static void main(String args[])
	{
		int x = 1;
		fun(x);
		System.out.println(x);
		
		int[] p = new int[1];
		p[0] = 100;
		System.out.println("Before function p[0]:" + p[0]);
		fun2(p);
		System.out.println("After function p[0]:" + p[0]);
	}
	
	public static void fun(int x)
	{
		x = 100;
	}
	
	public static void fun2(int[] p)
	{
		p[0] = 200;
	}
}
