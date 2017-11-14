#include <stdio.h>
#include <jni.h>			///usr/lib/jvm/java-1.8.0-openjdk-amd64/include/

int c_hello(JNIEnv *env, jobject cls, jint a)
{
	printf("Hello world!\n");
	printf("C: the number come from JAVA is %d\n", a);
	return 100;
}

static const JNINativeMethod methods[] = 
{
	{"hello", "(I)I", (void *)c_hello},
};

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *jvm, void *reserved)
{
	JNIEnv *env = NULL;
	jclass cls;
	
	if((*jvm)->GetEnv(jvm, (void **)&env, JNI_VERSION_1_4))
	{
		return JNI_ERR;
	}
	
	cls = (*env)->FindClass(env, "JNI");
	if(cls == NULL)
	{
		return JNI_ERR;
	}
	
	if((*env)->RegisterNatives(env, cls, methods, 1) < 0)
		return JNI_ERR;
	
	return JNI_VERSION_1_4;
}

