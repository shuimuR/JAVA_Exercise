public class Excep
{
	public static void main(String args[])
	{
		int r = 0;
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		System.out.println("Begin call div function");
		try
		{
			r = Div(m,n);
		}
		catch(ArithmeticException e)
		{
			System.out.println(e);
		}
		finally
		{
			System.out.println("This is Finally");
		}
		System.out.println("end call div function");
		
		System.out.println(m + "/" + n + "= " + r);
		
	}
	
	/*
	public static int Div(int m, int n)
	{
		int r = 0;
		try
		{
			r = m/n;
		}
		catch(ArithmeticException e)
		{
			System.out.println(e);
		}
		finally
		{
			System.out.println("This is end of DIV");
		}
		return r;
	}
	*/
	
	public static int Div (int m, int n) throws ArithmeticException
	{
		int r = 0;
		r = m/n;
		return r;
	}
}
