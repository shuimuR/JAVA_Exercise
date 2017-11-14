
public class JNI
{
	static 
	{
		/*Load C*/
		System.loadLibrary("native");		/*libnative.so*/
	}
	public native static int hello(int[] arr);
	public static void main(String args[])
	{
		/*call */
		JNI jniDemo = new JNI();
		int [] arr = {1,2,3,4};
		System.out.println("JAVA: the Sum from C is " + jniDemo.hello(arr));
	}
}
