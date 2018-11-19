#include <jni.h>


#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     HelloWorld
 * Method:    print
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_org_laidu_learn_advance_jni_demo_NativeHelloWorld_hello
  (JNIEnv * env, jobject obj) {
  printf("Hello World!\n");
//  while(1){
//    printf("123\n");
//  }
}

#ifdef __cplusplus
}
#endif