
public class JNI
{
	static 
	{
		/*Load C*/
		System.loadLibrary("native");		/*libnative.so*/
	}
	public native static int hello(int a);
	public static void main(String args[])
	{
		/*call */
		JNI jniDemo = new JNI();
		System.out.println("JAVA: the value from C is " + jniDemo.hello(20));
	}
}
