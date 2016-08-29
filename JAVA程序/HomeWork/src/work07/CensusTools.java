package work07;

public class CensusTools {
	public static int add(int a,int b) throws NumberSizeException{
		
		if(a < 0 || b < 0){
			throw new NumberSizeException("不接受小于0的数");
		}
		return a + b;
	}
}
