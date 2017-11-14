#include <stdio.h>
#include <jni.h>			///usr/lib/jvm/java-1.8.0-openjdk-amd64/include/

void c_hello(JNIEnv *env, jobject cls)
{
	printf("Hello world!");
}

static const JNINativeMethod methods[] = 
{
	{"hello", "()V", (void *)c_hello},
};

//JNIEXPORT jint JNICALL
int JNI_OnLoad(JavaVM &jvm, void *reserved)
{
	JNIEnv *env;
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
	
	#if 0
	MID_C_g = (*env)->GetMethodID(env, cls, "g", "()V");
	if(MID_C_g == NULL)
		return JNI_ERR;
	#endif	
	return JNI_VERSION_1_4;
}
