//import a.b.c.d.Person

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Reflect
{
	public static void main(String args[]) throws Exception
	{
		Class<?> c = null;
		try
		{
			c = Class.forName("a.b.c.d.Person");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		
		Object p = null;
		
		try
		{
			p = c.newInstance();
		}
		catch(InstantiationException e)
		{
			System.out.println(e);
		}
		
		//获取构造方法
		Constructor<?> con = c.getConstructor(String.class);
		Object p2 = con.newInstance("Hello");
		
		Method set = c.getMethod("SetName", String.class);
		set.invoke(p2, "123");
		set.invoke(p, "abc");
		
		Method get = c.getMethod("GetName");
		System.out.println(get.invoke(p));
		System.out.println(get.invoke(p2));
	}
}
