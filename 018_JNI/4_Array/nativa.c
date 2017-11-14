#include <stdio.h>
#include <jni.h>			///usr/lib/jvm/java-1.8.0-openjdk-amd64/include/

jint c_hello(JNIEnv *env, jobject cls, jintArray arr)
{
	printf("Hello world!\n");
	jint Sum = 0;
	jint *carr;
	jint i;
	carr = (*env)->GetIntArrayElements(env, arr, NULL);
	if(carr == NULL)
		return 0;
		
	for(i = 0; i < (*env)->GetArrayLength(env, arr); i++)
	{
		Sum += carr[i];
	}
	(*env)->ReleaseIntArrayElements(env, arr, carr, 0);
	return Sum;
}

static const JNINativeMethod methods[] = 
{
	{"hello", "([I)I", (void *)c_hello},
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

