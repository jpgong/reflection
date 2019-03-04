package accessConstructor;

/**
 * ����һ��MoreConstructor�࣬��������һ��string����������int���������ṩ3�����췽��
 * @author jpgong
 *
 */

public class MoreConstructor {
	String s;
	int i,i1,i2;
	
	@SuppressWarnings("unused")
	private MoreConstructor() {     //���������Ĺ��췽��
		
	}
	protected MoreConstructor(String s, int i) {  //�����������Ĺ��췽��
		this.s = s;
		this.i = i;
	}
	//���ɱ�����Ĺ��췽��
	public MoreConstructor(String...strings) {
		if (strings.length > 0) {
			i = Integer.valueOf(strings[0]);
		}
		if (strings.length > 1) {
			i1 = Integer.valueOf(strings[1]);
		}
		if (strings.length > 2) {
			i2 = Integer.valueOf(strings[2]);
		}
	}
	public void print() {
		System.out.println("s=" + s);
		System.out.println("i=" + i);
		System.out.println("i1=" + i1);
		System.out.println("i2=" + i2);
	}

}
