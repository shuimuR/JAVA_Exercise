
public class JNI
{
	static 
	{
		/*Load C*/
		System.loadLibrary("native");		/*libnative.so*/
	}
	public native static String hello(String str);
	public static void main(String args[])
	{
		/*call */
		JNI jniDemo = new JNI();
		System.out.println("JAVA: the String from C is " + jniDemo.hello("This is JAVA"));
	}
}
