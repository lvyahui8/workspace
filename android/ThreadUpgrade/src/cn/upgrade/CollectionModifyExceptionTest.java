package cn.upgrade;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
@SuppressWarnings("unused")
public class CollectionModifyExceptionTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Collection users = new CopyOnWriteArrayList();
			
			//new ArrayList();
		users.add(new User("����",28));	
		users.add(new User("����",25));			
		users.add(new User("����",31));	
		Iterator itrUsers = users.iterator();
		while(itrUsers.hasNext()){
			System.out.println("aaaa");
			User user = (User)itrUsers.next();
			if("����".equals(user.getName())){
				users.remove(user);
				//itrUsers.remove();
			} else {
				System.out.println(user);				
			}
		}
	}
}	 
