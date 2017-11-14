
public class JNI
{
	static 
	{
		/*Load C*/
		System.loadLibrary("native");		/*libnative.so*/
	}
	public native static void hello();
	public native int hello(String str, double d, int[] c);
	public static void main(String args[])
	{
		/* map*/
		
		/*call */
	}
}
