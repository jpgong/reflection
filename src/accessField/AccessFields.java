package accessField;

import java.lang.reflect.Field;

/**
 * ���÷�����ƣ���Student���е�˽��������޸�
 * @author jpgong
 *
 */
public class AccessFields {
	public static void main(String[] args) {
		MoreFields moreFields = new MoreFields();                       
		Class<?> clazz = moreFields.getClass();     //��ô���student�����Class��
		System.out.println("��ı�׼���ƣ�" + clazz.getCanonicalName());
		
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			System.out.println("����Ϊ��" + field.getName());
			System.out.println("����Ϊ��" + field.getType());
			boolean isTurn = true;
			while(isTurn) {    
				try {  //�����Ա�����ķ���Ȩ��Ϊprivate,���׳��쳣�������������
					isTurn = false;
					System.out.println("�޸�ǰ��ֵΪ��" + field.get(moreFields));
					if (field.getType().equals(int.class)) {
						System.out.println("���÷���setInt()�޸ĳ�Ա����");
						field.setInt(moreFields, 168);
					}else if (field.getType().equals(float.class)) {
						System.out.println("���÷���setFloat()�޸ĳ�Ա����");
						field.setFloat(moreFields, 99.9F);
					}else if (field.getType().equals(boolean.class)) {
						System.out.println("���÷���setBoolean()�޸ĳ�Ա����");
						field.setBoolean(moreFields, true);
					}else if (field.getType().equals(String.class)) {     //��Ա�����ķ���Ȩ��Ϊprivate�����ܷ���
						System.out.println("���÷���set()�޸ĳ�Ա����");
						field.set(moreFields, "mingri");
					}
					System.out.println("�޸ĺ��ֵΪ��" + field.get(moreFields));
				} catch (Exception e) {
					System.out.println("�����ó�Ա����ֵʱ�׳��쳣������ִ��setAccessible()����");
					field.setAccessible(true);
					isTurn = true;
				}
			}
			System.out.println();
		}
	}
}
