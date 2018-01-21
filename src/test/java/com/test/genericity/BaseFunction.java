package com.test.genericity;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class BaseFunction<T1,T2> {

	private Class<T1> entityClass1;
	private Class<T2> entityClass2;
	
	public BaseFunction() {
		Type genericSuperclass = this.getClass().getGenericSuperclass();
		if(genericSuperclass instanceof ParameterizedType){
			ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
			Type[] arguments = parameterizedType.getActualTypeArguments();
			entityClass1 = (Class<T1>) arguments[0];
			entityClass2 = (Class<T2>) arguments[1];
		}
	}
	
	/**
	 * 
	 * @param t1 被反射的obj
	 * @param methodName obj的指定方法名
	 * @param t2 obj指定方法名的参数的参数obj
	 * @return
	 */
	public T1 getObjcet(T1 t1,String methodName,T2 t2){
		Class<? extends Object> class1 = t1.getClass();
		try {
			Method method = class1.getDeclaredMethod(methodName, entityClass2);
			method.setAccessible(true);
			// 调用
			method.invoke(t1, t2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 传入什么，返回什么
		return t1;
	}
}
