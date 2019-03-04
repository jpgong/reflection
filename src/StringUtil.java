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
		sb.append("������" + package1.getName() + "\t");
		String className = class1.getSimpleName();
		sb.append("������" + className + "\n");
		sb.append("�������췽����\n");
		//������д����췽����Constructor����
		Constructor<?>[] constructors = class1.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			String modifier = Modifier.toString(constructor.getModifiers());   //������η�
			if (modifier.contains("public")) {
				sb.append(constructor.toGenericString() + "\n");
			}
		}
		sb.append("������\n");
		Field[] fields = class1.getDeclaredFields();
		for (Field field : fields) {
			String modifier = Modifier.toString(field.getModifiers());   //������η�
			if (modifier.contains("public")) {
				sb.append(field.toGenericString() + "\n");
			}
		}
		sb.append("����������\n");
		Method[] methods = class1.getDeclaredMethods();
		for (Method method : methods) {
			String modifier = Modifier.toString(method.getModifiers());   //������η�
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
