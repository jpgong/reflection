package accessConstructor;

import java.lang.reflect.Constructor;

/**
 * 在该类中通过反射机制访问MoreConstructor类中的所有构造方法，
 * 并将该构造方法是否允许带有可变数量的参数、入口参数类型和可能抛出的异常类信息输出
 * @author jpgong
 *
 */

public class AccessConstructor {
	public static void main(String[] args) {
		MoreConstructor moreConstructor = new MoreConstructor();
		Class<?> class1 = moreConstructor.getClass();
		Constructor<?>[] constructors = class1.getDeclaredConstructors();   //获得所有构造方法
		for (int i = 0; i < constructors.length; i++) {
			Constructor<?> constructor = constructors[i];
			System.out.println("构造方法" + i + "是否允许带有可变数量的参数：" + constructor.isVarArgs());
			System.out.println("该构造方法的入口参数类型依次为：");
			Class<?>[] parameterTypes = constructor.getParameterTypes();
			for (int j = 0; j < parameterTypes.length; j++) {
				System.out.println(" " + parameterTypes[j]);
			}
			System.out.println("该构造方法可能抛出的异常类型为：");
			Class<?>[] execptionTypes = constructor.getExceptionTypes();
			for (int j = 0; j < execptionTypes.length; j++) {
				System.out.println(" " + execptionTypes[j]);
			}
		}
	}
}
