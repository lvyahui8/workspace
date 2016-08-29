/*

5、两个乒乓球队进行比赛，各出三人。
甲队为A、B、C 3人。乙队为X、Y、Z 3人，B，C ，A
已抽签决定比赛名单。有人向队员打听比赛的名单，
A说他不和X比，
C说他不和X、Z比，请编写代码找出三队赛手名单。

*/
public class ForTest02{

	public static void main(String[] args) {
		char a_Opponent;//A的对手
		char b_Opponent;//B的对手
		char c_Opponent;//C的对手
		for (a_Opponent = 'X'; a_Opponent <= 'Z'; a_Opponent++) {
			for (b_Opponent = 'X'; b_Opponent <= 'Z' ; b_Opponent++) {
				if (b_Opponent == a_Opponent) {
					continue;
				}
				for (c_Opponent = 'X'; c_Opponent <= 'Z'; c_Opponent++) {
					if(c_Opponent == b_Opponent || c_Opponent == a_Opponent){
						continue;
					}
					if (a_Opponent != 'X' && (c_Opponent != 'X' && c_Opponent != 'Z')) {
						System.out.println(a_Opponent +  " " + b_Opponent + " " + c_Opponent);
					}
				}
			}
		}
	}
}