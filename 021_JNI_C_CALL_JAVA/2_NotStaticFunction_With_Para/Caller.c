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
	 jmethodID cid;
	 
	 jobject jobj;
	 jstring jstr;
	 
	 int r;
	 
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
		goto destroy;
	}
	
	//3. create object
	cid = (*env)->GetMethodID(env, cls, "<init>", "()V");
	if(cid == NULL)
	{
		ret = -1;
		printf("can not get method ID\n");
		goto destroy;
	}
	
	jobj = (*env)->NewObject(env, cls, cid);
	if(jobj == NULL)
	{
		ret = -1;
		printf("can not create object\n");
		goto destroy;
	}
	//4. call method
	//4.1 get method
	mid = (*env)->GetStaticMethodID(env, cls,"SayHelloTo", "(Ljava/lang/String;)I");
	if(mid == NULL)
	{
		ret = -1;
		printf("can not get class\n");
		goto destroy;
	}
	//4.2 create para
	jstr = (*env)->NewStringUTF(env, "I am glad to join in");
	
	
	//4.3 call 
	r = (*env)->CallIntMethod(env, jobj, mid, jstr);
	printf("caller return %d", r);
	
destroy:
	(*jvm)->DestroyJavaVM(jvm);
	return 0;
}
