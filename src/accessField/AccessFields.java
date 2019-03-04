package accessField;

import java.lang.reflect.Field;

/**
 * 运用反射机制，对Student类中的私有域进行修改
 * @author jpgong
 *
 */
public class AccessFields {
	public static void main(String[] args) {
		MoreFields moreFields = new MoreFields();                       
		Class<?> clazz = moreFields.getClass();     //获得代表student对象的Class类
		System.out.println("类的标准名称：" + clazz.getCanonicalName());
		
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			System.out.println("名称为：" + field.getName());
			System.out.println("类型为：" + field.getType());
			boolean isTurn = true;
			while(isTurn) {    
				try {  //如果成员变量的访问权限为private,则抛出异常，即不允许访问
					isTurn = false;
					System.out.println("修改前的值为：" + field.get(moreFields));
					if (field.getType().equals(int.class)) {
						System.out.println("利用方法setInt()修改成员变量");
						field.setInt(moreFields, 168);
					}else if (field.getType().equals(float.class)) {
						System.out.println("利用方法setFloat()修改成员变量");
						field.setFloat(moreFields, 99.9F);
					}else if (field.getType().equals(boolean.class)) {
						System.out.println("利用方法setBoolean()修改成员变量");
						field.setBoolean(moreFields, true);
					}else if (field.getType().equals(String.class)) {     //成员变量的访问权限为private，不能访问
						System.out.println("利用方法set()修改成员变量");
						field.set(moreFields, "mingri");
					}
					System.out.println("修改后的值为：" + field.get(moreFields));
				} catch (Exception e) {
					System.out.println("在设置成员变量值时抛出异常，下面执行setAccessible()方法");
					field.setAccessible(true);
					isTurn = true;
				}
			}
			System.out.println();
		}
	}
}
