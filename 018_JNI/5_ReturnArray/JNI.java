
public class JNI
{
	static 
	{
		/*Load C*/
		System.loadLibrary("native");		/*libnative.so*/
	}
	public native static int[] hello(int[] arr);
	public static void main(String args[])
	{
		/*call */
		JNI jniDemo = new JNI();
		int [] arr = {1,2,3,4};
		int [] arr2 = null;
		int i;
		
		arr2 = jniDemo.hello(arr);
		
		System.out.println("JAVA: The array from C is ");
		for(i = 0; i < arr2.length; i++)
			System.out.println(arr2[i]);
	}
}
