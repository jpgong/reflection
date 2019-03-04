import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

import accessConstructor.MoreConstructor;

public class ClassView {
	public static void main(String[] args) throws ClassNotFoundException {
	//	MoreConstructor more = new MoreConstructor();
	//	Class<?> class1 = more.getClass();
		Class<?> class1 = Class.forName("java.util.ArrayList");    //获得ArrayList类对象
		System.out.println("类的标准名称：" + class1.getCanonicalName());
		System.out.println("类的修饰符：" + Modifier.toString(class1.getModifiers()));
		//输出类的泛型参数
		TypeVariable<?>[] typeVariables = class1.getTypeParameters();
		System.out.println("类的泛型参数：");
		if (typeVariables.length != 0) {
			for (TypeVariable<?> typeVariable : typeVariables) {
				System.out.println(typeVariable);
			}
		}else {
			System.out.println("空");
		}
		System.out.println();
		//输出类所实现的所有接口
		Type[] interfaces = class1.getGenericInterfaces();
		System.out.println("类所实现的接口：");
		if (interfaces.length != 0) {
			for (Type type : interfaces) {
				System.out.println(type);
			}
		}else {
			System.out.println("空");
		}
		System.out.println();
		//输出类的直接继承类，如果继承自object则返回空
		Type superClass = class1.getGenericSuperclass();
		System.out.println("类的直接继承类：");
		if (superClass != null) {
			System.out.println(superClass);
		}else {
			System.out.println("空");
		}
		System.out.println();
		//输出类的所有注释信息，有些注释信息是不能用反射获得的
		Annotation[] annotations = class1.getAnnotations();
		System.out.println("类的注释：");
		if (annotations.length != 0) {
			for (Annotation annotation : annotations) {
				System.out.println(annotation);
			}
		}else {
			System.out.println("空");
		}
		
		
	}

}
