#include <stdio.h>
#include <jni.h>

 JNIEnv* create_vm(JavaVM ** jvm, JNIEnv** env) {   
    JavaVMInitArgs args;  
    JavaVMOption options[1];  
    args.version = JNI_VERSION_1_6;  
    args.nOptions = 1;  
    options[0].optionString = "-Djava.class.path=./";  
    args.options = options;  
    args.ignoreUnrecognized = JNI_FALSE;  
    JNI_CreateJavaVM(jvm, (void **)env, &args);   
}  

int main(int argc, char **argv)
{
	JavaVM* jvm;
	 JNIEnv* env;
	 jclass cls;
	 int ret = 0;
	 jmethodID mid;
	 
	//1. create java VM
	if(create_vm(&jvm, &env) < 0)
	{
		printf("can not create jvm\n");
		return -1;
	}
	
	//2. get class
	cls = (*env)->FindClass(env, "Hello");
	if(cls == NULL)
	{
		ret = -1;
		printf("can not find class\n");
		goto destory;
	}
	
	//3. create object
	
	//4. call method
	//4.1 get method
	mid = (*env)->GetStaticMethodID(env, cls,"main", "([Ljava/lang/String;)V");
	if(mid == NULL)
	{
		ret = -1;
		printf("can not get class\n");
		goto destory;
	}
	//4.2 create para
	
	//4.3 call 
	(*env)->CallStaticVoidMethod(env, cls, mid, NULL);
	
destory:
	(*jvm)->DestroyJavaVM(jvm);
	return 0;
}
