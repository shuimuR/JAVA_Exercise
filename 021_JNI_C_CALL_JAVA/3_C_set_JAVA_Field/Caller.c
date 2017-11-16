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
	mid = (*env)->GetMethodID(env, cls,"SayHelloTo", "(Ljava/lang/String;)I");
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
	printf("caller return %d\n", r);

	#if 1
	/**************************************************************
	call the second function
	**************************************************************/
	jmethodID mid2;
	jmethodID cid2;
	 
	jobject jobj2;
	jstring jstr2;
	//3. create object
	cid2 = (*env)->GetMethodID(env, cls, "<init>", "()V");
	if(cid2 == NULL)
	{
		ret = -1;
		printf("can not get method ID\n");
		goto destroy;
	}
	
	jobj2 = (*env)->NewObject(env, cls, cid2);
	if(jobj2 == NULL)
	{
		ret = -1;
		printf("can not create object\n");
		goto destroy;
	}
	
	/********************************************
	Get or set field
	********************************************/
	jfieldID nameID;
	jfieldID ageID;

	nameID = (*env)->GetFieldID(env, cls, "name", "Ljava/lang/String;");
	if(nameID == NULL)
	{
		ret = -1;
		printf("can get name ID\n");
		goto destroy;
	}
	
	ageID = (*env)->GetFieldID(env, cls, "age", "I");
	if(ageID == NULL)
	{
		ret = -1;
		printf("can get age ID\n");
		goto destroy;
	}
	//4. call method
	//4.1 get method
	mid2 = (*env)->GetMethodID(env, cls,"SayHelloTo2", "(Ljava/lang/String;)I");
	if(mid2 == NULL)
	{
		ret = -1;
		printf("can not get class\n");
		goto destroy;
	}
	//4.2 create para
	jstr2 = (*env)->NewStringUTF(env, "I am the second function string");
	
	jstring jstr_Name;
	jstr_Name = (*env)->NewStringUTF(env, "Popo");
	(*env)->SetObjectField(env, jobj2, nameID, jstr_Name);
	
	jint SetAgeNum = 16;
	(*env)->SetIntField(env, jobj2, ageID, SetAgeNum);
	
	//4.3 call 
	r = (*env)->CallIntMethod(env, jobj2, mid2, jstr2);
	printf("caller return %d\n", r);
	#endif
destroy:
	(*jvm)->DestroyJavaVM(jvm);
	return 0;
}
