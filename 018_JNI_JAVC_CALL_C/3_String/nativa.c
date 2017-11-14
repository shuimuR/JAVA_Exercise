#include <stdio.h>
#include <jni.h>			///usr/lib/jvm/java-1.8.0-openjdk-amd64/include/

jstring c_hello(JNIEnv *env, jobject cls, jstring str)
{
	printf("Hello world!\n");
	const jbyte *cstr;
	cstr = (*env)->GetStringUTFChars(env, str, NULL);
	if(cstr == NULL)
		return NULL;
	printf("Get string from JAVA: %s\n", cstr);
	(*env)->ReleaseStringUTFChars(env, str, cstr);
	
	return (*env)->NewStringUTF(env, "The string come from C");
}

static const JNINativeMethod methods[] = 
{
	{"hello", "(Ljava/lang/String;)Ljava/lang/String;", (void *)c_hello},
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

