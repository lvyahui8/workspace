package work06.question02;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class CensusTools {
	public static Set<Integer> computePostage(Stamp sta1, Stamp sta2,
			Comparator<Integer> compr) {
		Set<Integer> postages = new TreeSet<Integer>(compr);
		int sta1Value = sta1.getValue();
		int sta2Value = sta2.getValue();
		int sta1Count = sta1.getCount();
		int sta2Count = sta2.getCount();
		for(int i = 1;i<=sta1.getCount() + sta2.getCount();i++){//i��ʾ��һ���ܹ�Ҫ������
			int m = i, n = 0;//m��ʾ�ü�����ֵΪsta1Vale����Ʊ��n��ʾ�ü�����ֵΪsta2Vale����Ʊ������sta1ȫ��
			for(;n<=i;m--,n++){
	
				if (m >= sta1Count) {//���sta1ȫ�ó�������������
					postages.add(sta1Value * sta1Count + sta2Value * (m-sta1Count) + sta2Value *n);//sta1ȫ����sta2���Ų��ϣ��ٽ��Լ��ó���Ҳ���ˣ�����˵ʣ�µ�sta2����
					continue;
				}
				if (n >= sta2Count) {
					postages.add(sta2Value * sta2Count + sta1Value * (n - sta2Count) + sta1Value  * m);
					continue;
				}
				postages.add(sta1Value*m+sta2Value*n);

			}
		}
		
		return postages;
	}
}
