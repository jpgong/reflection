import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;

public class StringUtil {
	public String toString(Object object) {
		Class<?> class1 = object.getClass();
		StringBuilder sb = new StringBuilder();
		Package package1 = class1.getPackage();
		sb.append("包名：" + package1.getName() + "\t");
		String className = class1.getSimpleName();
		sb.append("类名：" + className + "\n");
		sb.append("公共构造方法：\n");
		//获得所有代表构造方法的Constructor数组
		Constructor<?>[] constructors = class1.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			String modifier = Modifier.toString(constructor.getModifiers());   //获得修饰符
			if (modifier.contains("public")) {
				sb.append(constructor.toGenericString() + "\n");
			}
		}
		sb.append("公共域：\n");
		Field[] fields = class1.getDeclaredFields();
		for (Field field : fields) {
			String modifier = Modifier.toString(field.getModifiers());   //获得修饰符
			if (modifier.contains("public")) {
				sb.append(field.toGenericString() + "\n");
			}
		}
		sb.append("公共方法：\n");
		Method[] methods = class1.getDeclaredMethods();
		for (Method method : methods) {
			String modifier = Modifier.toString(method.getModifiers());   //获得修饰符
			if (modifier.contains("public")) {
				sb.append(method.toGenericString() + "\n");
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(new StringUtil().toString(new Date()));
	}

}
