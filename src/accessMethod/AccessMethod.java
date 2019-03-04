package accessMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class AccessMethod {
	public static void main(String[] args) {
		MoreMethod moreMethod = new MoreMethod();
		Class<?> class1 = moreMethod.getClass();
		Method[] methods = class1.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			System.out.println("名称为：" + method.getName());;
			System.out.println("是否允许带可变数量的参数：" + method.isVarArgs());;
			System.out.println("入口参数类型依次为：");
			Class<?>[] parameterTypes = method.getParameterTypes();
			for (int j = 0; j < parameterTypes.length; j++) {
				System.out.println(" " + parameterTypes[j]);
			}
			
			System.out.println("返回值类型为：" + method.getReturnType());
			System.out.println("可能抛出的异常类型有：");
			Class<?>[] execptionTypes = method.getExceptionTypes();
			for (int k = 0; k < execptionTypes.length; k++) {
				System.out.println(" " + execptionTypes[k]);
			}
			boolean isTurn = true;
			while(isTurn) {
				//如果该方法的访问权限为private,则抛出异常，即不允许访问
				try {
					isTurn = false;
					int modifiers = method.getModifiers();
					if (Modifier.isStatic(modifiers)) {
						method.invoke(moreMethod);    //执行没有入口参数的方法
					}else if (Modifier.isPublic(modifiers)) {
						System.out.println("返回值为：" + method.invoke(moreMethod, 168));
					}else if (Modifier.isProtected(modifiers)) {
						System.out.println("返回值为：" + method.invoke(moreMethod, "7" , 5));
					}else if(Modifier.isPrivate(modifiers)){
						Object[] parameters = new Object[] {new String[] {"M","W","Q"}};
						System.out.println("返回值为：" + method.invoke(moreMethod, parameters));
					}
				} catch (Exception e) {
					System.out.println("在执行方法时抛出异常，下面执行setAccessible()方法");
					method.setAccessible(true);
					isTurn = true;
				}
			}
			System.out.println();
		}
	}
}
