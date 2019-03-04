package accessConstructor;

/**
 * 创建一个MoreConstructor类，类中声明一个string变量和三个int变量，并提供3个构造方法
 * @author jpgong
 *
 */

public class MoreConstructor {
	String s;
	int i,i1,i2;
	
	@SuppressWarnings("unused")
	private MoreConstructor() {     //不带参数的构造方法
		
	}
	protected MoreConstructor(String s, int i) {  //带两个参数的构造方法
		this.s = s;
		this.i = i;
	}
	//带可变参数的构造方法
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
