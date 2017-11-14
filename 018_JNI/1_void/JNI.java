
public class JNI
{
	static 
	{
		/*Load C*/
		System.loadLibrary("native");		/*libnative.so*/
	}
	public native static void hello();
	public static void main(String args[])
	{
		/*call */
		hello();
	}
}
