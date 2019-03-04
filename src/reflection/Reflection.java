package reflection;

import java.lang.reflect.Field;

/**
 * ���÷�����ƣ���Student���е�˽��������޸�
 * @author jpgong
 *
 */
public class Reflection {
	public static void main(String[] args) {
		Student student = new Student();
		Class<?> clazz = student.getClass();     //��ô���student�����Class��
		System.out.println("��ı�׼���ƣ�" + clazz.getCanonicalName());
		
		try {
			Field id = clazz.getDeclaredField("id");
			System.out.println("����ǰ��idֵ��" + student.getId());
			id.setAccessible(true);
			id.setInt(student, 10);   //����idֵΪ10
			System.out.println("���ú��idֵ��" + student.getId());
			
			Field name = clazz.getDeclaredField("name");
			System.out.println("����ǰ��nameֵ��" + student.getName());
			name.setAccessible(true);
			name.set(student, "С��");;  
			System.out.println("���ú��nameֵ��" + student.getName());
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
