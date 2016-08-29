import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        final char types[] = {'a','b','c'};
        final String [] cnTypes = {"所有玩家","偶数玩家","技术玩家"};
        for(int i = 0;i < 2;i++){
            System.out.println("首页设置所有玩家为："+ i + ",进入第二界面");
            for (int j = 0 ; j < 4;j++){
                // 四种可能，C30,C31，C32，C33，先求出这四种情况下的组合
                subSets.clear();
                c(types, j, "", 0);
                System.out.println("C(3,"+j+")子集设置:");
                for (char[] subSet : subSets) {
                    List<String> cnSubSet = new ArrayList<>();
                    for (char ch: subSet) {
                        cnSubSet.add(cnTypes[ch - 'a']);
                    }
                    System.out.println("为子集："+ cnSubSet.toString() + "设值");
                    for(char ch : subSet){
                        for (int k = 0;k < 2;k++){
                            System.out.println("设置" + cnTypes[ch - 'a'] + "的值为" + k );
                        }
                    }
                    System.out.println();
                }
            }
        }
    }

    private static List<char[]> subSets = new ArrayList<>();

    private static void c(char[] types, int n, String subSet, int index) {
        // 选择0字符
        if (n == 0) {
            subSets.add(subSet.toCharArray());
            return;
        }

        // 扫描到最后一个字符
        if (index == types.length) return ;

        // 从后面身下的元素中选n-1个
        c(types, n - 1, subSet + types[index], index + 1);
        // 从后面剩下的元素中选n个，当前这个不选
        c(types, n, subSet, index + 1);
    }

}
