class Array2Demo 
{
	public static void main(String[] args) 
	{
		int [] arr1 [] = new int[3][4];
		int [] arr2 [] = new int[3][];//C++ C   int * pp = new (int*)[3];   pp[0] = new int[3];  pp[1] = new int[2]; pp[2] = new int[4];
		System.out.println(arr1);//[[I@bdb503  @左边是实体的类型，@右边是实体的哈希值（地址转换过来的）
		System.out.println(arr1[0]);
		System.out.println(arr1[0][0]);
		System.out.println(arr2[0]);//null
		arr2[0] = new int[3];
		arr2[1] = new int[2];
		arr2[2] = new int[4];
		System.out.println(arr2[1]);//[I@119dc16

		int [][]arr3 = {{3,1,7},{5,2},{9,4,0,5}};

		for(int i=0;i<arr3.length;i++){
			for(int j=0;j<arr3[i].length;j++){
				System.out.print(" arr["+i+"]["+j+"]= "+arr3[i][j]);
			}
			System.out.print('\n');
		}

		int a1 = 10;
		int a2 = 010;
		int a3 = 0X10;
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
	}
}
