package accessConstructor;

import java.lang.reflect.Constructor;

/**
 * �ڸ�����ͨ��������Ʒ���MoreConstructor���е����й��췽����
 * �����ù��췽���Ƿ�������пɱ������Ĳ�������ڲ������ͺͿ����׳����쳣����Ϣ���
 * @author jpgong
 *
 */

public class AccessConstructor {
	public static void main(String[] args) {
		MoreConstructor moreConstructor = new MoreConstructor();
		Class<?> class1 = moreConstructor.getClass();
		Constructor<?>[] constructors = class1.getDeclaredConstructors();   //������й��췽��
		for (int i = 0; i < constructors.length; i++) {
			Constructor<?> constructor = constructors[i];
			System.out.println("���췽��" + i + "�Ƿ�������пɱ������Ĳ�����" + constructor.isVarArgs());
			System.out.println("�ù��췽������ڲ�����������Ϊ��");
			Class<?>[] parameterTypes = constructor.getParameterTypes();
			for (int j = 0; j < parameterTypes.length; j++) {
				System.out.println(" " + parameterTypes[j]);
			}
			System.out.println("�ù��췽�������׳����쳣����Ϊ��");
			Class<?>[] execptionTypes = constructor.getExceptionTypes();
			for (int j = 0; j < execptionTypes.length; j++) {
				System.out.println(" " + execptionTypes[j]);
			}
		}
	}
}
