package JZoffer;

public class SingletonModel {
	private SingletonModel(){}
	private static SingletonModel instance = new SingletonModel();
	public static SingletonModel getInstace(){
		return instance;
	}
}
class Singleton{
	private static Singleton instance = null;
	public static synchronized Singleton getInstace(){
		if(instance == null)
			instance = new Singleton();
		return instance;
	}
}
