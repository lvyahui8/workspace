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
			System.out.println("���쳣");
		}
		finally{
//			try{
//				if(true == flag){
//					throw new Exception();
//				}
//				System.out.println("����ִ����");
//			}
//			catch (Exception e) {
//				System.out.println("���쳣");
//			}
			
			if (true == flag) {
				throw new Exception();
			}
			System.out.println("����ִ����");
			
		}
	}

}
