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
			System.out.println("����Ϊ��" + method.getName());;
			System.out.println("�Ƿ�������ɱ������Ĳ�����" + method.isVarArgs());;
			System.out.println("��ڲ�����������Ϊ��");
			Class<?>[] parameterTypes = method.getParameterTypes();
			for (int j = 0; j < parameterTypes.length; j++) {
				System.out.println(" " + parameterTypes[j]);
			}
			
			System.out.println("����ֵ����Ϊ��" + method.getReturnType());
			System.out.println("�����׳����쳣�����У�");
			Class<?>[] execptionTypes = method.getExceptionTypes();
			for (int k = 0; k < execptionTypes.length; k++) {
				System.out.println(" " + execptionTypes[k]);
			}
			boolean isTurn = true;
			while(isTurn) {
				//����÷����ķ���Ȩ��Ϊprivate,���׳��쳣�������������
				try {
					isTurn = false;
					int modifiers = method.getModifiers();
					if (Modifier.isStatic(modifiers)) {
						method.invoke(moreMethod);    //ִ��û����ڲ����ķ���
					}else if (Modifier.isPublic(modifiers)) {
						System.out.println("����ֵΪ��" + method.invoke(moreMethod, 168));
					}else if (Modifier.isProtected(modifiers)) {
						System.out.println("����ֵΪ��" + method.invoke(moreMethod, "7" , 5));
					}else if(Modifier.isPrivate(modifiers)){
						Object[] parameters = new Object[] {new String[] {"M","W","Q"}};
						System.out.println("����ֵΪ��" + method.invoke(moreMethod, parameters));
					}
				} catch (Exception e) {
					System.out.println("��ִ�з���ʱ�׳��쳣������ִ��setAccessible()����");
					method.setAccessible(true);
					isTurn = true;
				}
			}
			System.out.println();
		}
	}
}
