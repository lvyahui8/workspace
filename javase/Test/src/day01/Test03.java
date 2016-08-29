package day01;

public class Test03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		boolean flag = true;
		try{
			throw new Exception();
		}
		catch (Exception e) {
			System.out.println("出异常");
		}
		finally{
//			try{
//				if(true == flag){
//					throw new Exception();
//				}
//				System.out.println("这里执行了");
//			}
//			catch (Exception e) {
//				System.out.println("出异常");
//			}
			
			if (true == flag) {
				throw new Exception();
			}
			System.out.println("这里执行了");
			
		}
	}

}
