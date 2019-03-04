package reflection;

import java.lang.reflect.Field;

/**
 * 运用反射机制，对Student类中的私有域进行修改
 * @author jpgong
 *
 */
public class Reflection {
	public static void main(String[] args) {
		Student student = new Student();
		Class<?> clazz = student.getClass();     //获得代表student对象的Class类
		System.out.println("类的标准名称：" + clazz.getCanonicalName());
		
		try {
			Field id = clazz.getDeclaredField("id");
			System.out.println("设置前的id值：" + student.getId());
			id.setAccessible(true);
			id.setInt(student, 10);   //设置id值为10
			System.out.println("设置后的id值：" + student.getId());
			
			Field name = clazz.getDeclaredField("name");
			System.out.println("设置前的name值：" + student.getName());
			name.setAccessible(true);
			name.set(student, "小明");;  
			System.out.println("设置后的name值：" + student.getName());
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
