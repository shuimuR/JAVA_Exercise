public class ExcepMore
{
	public static void main(String args[])
	{
		int r = 0;
		int m  = 0;
		int n = 0;
		System.out.println("Begin call div function");
		try
		{
			m = Integer.parseInt(args[0]);
		    n = Integer.parseInt(args[1]);
			r = Div(m,n);
		}
		catch(ArithmeticException e)
		{
			System.out.println("Main: " + e);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Main: " + e);
		}
		catch(RuntimeException e)
		{
			System.out.println("Main: " + e);
		}
		catch (Exception e)
		{
			System.out.println("Main: " + e);
		}
		finally
		{
			System.out.println("This is Finally");
		}
		System.out.println("end call div function");
		
		System.out.println(m + "/" + n + "= " + r);
		
	}
	
	public static int Div (int m, int n) throws Exception
	{
		int r = 0;
		try
		{
			r = m/n;
		}
		catch(ArithmeticException e)
		{
			System.out.println("Div: " + e);
			throw new Exception("My error");
		}
		return r;
	}
}
