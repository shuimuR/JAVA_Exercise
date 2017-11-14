#include <stdio.h>
#include <stdlib.h>
#include <jni.h>			///usr/lib/jvm/java-1.8.0-openjdk-amd64/include/

jintArray c_hello(JNIEnv *env, jobject cls, jintArray arr)
{
	printf("Hello world!\n");
	jint *carr;
	jint i;
	carr = (*env)->GetIntArrayElements(env, arr, NULL);
	if(carr == NULL)
		return 0;
		
	jint Len = (*env)->GetArrayLength(env, arr);
	jint *oarr = (jint *)malloc(Len * sizeof(jint));
	if(oarr == NULL)
	{
		(*env)->ReleaseIntArrayElements(env, arr, carr, 0);
		return 0;
	}
	for(i = 0; i < Len; i++)
	{
		oarr[i] = carr[Len - 1 - i];
	}
	(*env)->ReleaseIntArrayElements(env, arr, carr, 0);
	
	/* create array */
	jintArray rarr;
	rarr = (*env)->NewIntArray(env, Len);
	if(rarr == NULL)
		return 0;
	else
		(*env)->SetIntArrayRegion(env, rarr, 0, Len, oarr);
	
	free(oarr);
		
	return rarr;
}

static const JNINativeMethod methods[] = 
{
	{"hello", "([I)[I", (void *)c_hello},
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

