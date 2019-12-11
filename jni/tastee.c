#include <stdio.h>
#include <stdlib.h>
#include <jni.h>

JNIEXPORT jint JNICALL Java_id_ac_ui_cs_mobileprogramming_nixisendyaputri_tasteeapp_activities_MainActivity_randNumber
  (JNIEnv * env, jobject this){
int n;
n = rand() % 6;
return n;
}