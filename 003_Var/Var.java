
public class Var
{
	static void main(String args[])
	{
		int a = 3;
		float f = (float)3.14;
		float f1 = 3.14f;
		int p[] = new int[10];
		int Num[] = {1,2,3,4};
		//char str[100];
		char str[] = new char[100];
		String strlong = "abc";
		
		short s = 4;
		
		p = null;
		Num = null;
		str = null;
		strlong = null;
		
		short s1 = 4;
		short s2 = 5;
		short sum = (short)(s1 + s2);		//must add the force change
	}
}
