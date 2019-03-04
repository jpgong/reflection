import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

import accessConstructor.MoreConstructor;

public class ClassView {
	public static void main(String[] args) throws ClassNotFoundException {
	//	MoreConstructor more = new MoreConstructor();
	//	Class<?> class1 = more.getClass();
		Class<?> class1 = Class.forName("java.util.ArrayList");    //���ArrayList�����
		System.out.println("��ı�׼���ƣ�" + class1.getCanonicalName());
		System.out.println("������η���" + Modifier.toString(class1.getModifiers()));
		//�����ķ��Ͳ���
		TypeVariable<?>[] typeVariables = class1.getTypeParameters();
		System.out.println("��ķ��Ͳ�����");
		if (typeVariables.length != 0) {
			for (TypeVariable<?> typeVariable : typeVariables) {
				System.out.println(typeVariable);
			}
		}else {
			System.out.println("��");
		}
		System.out.println();
		//�������ʵ�ֵ����нӿ�
		Type[] interfaces = class1.getGenericInterfaces();
		System.out.println("����ʵ�ֵĽӿڣ�");
		if (interfaces.length != 0) {
			for (Type type : interfaces) {
				System.out.println(type);
			}
		}else {
			System.out.println("��");
		}
		System.out.println();
		//������ֱ�Ӽ̳��࣬����̳���object�򷵻ؿ�
		Type superClass = class1.getGenericSuperclass();
		System.out.println("���ֱ�Ӽ̳��ࣺ");
		if (superClass != null) {
			System.out.println(superClass);
		}else {
			System.out.println("��");
		}
		System.out.println();
		//����������ע����Ϣ����Щע����Ϣ�ǲ����÷����õ�
		Annotation[] annotations = class1.getAnnotations();
		System.out.println("���ע�ͣ�");
		if (annotations.length != 0) {
			for (Annotation annotation : annotations) {
				System.out.println(annotation);
			}
		}else {
			System.out.println("��");
		}
		
		
	}

}
