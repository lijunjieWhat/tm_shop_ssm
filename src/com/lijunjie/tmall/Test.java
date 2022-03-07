package com.lijunjie.tmall;

public class Test {

	static int a = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[][] = new int[5][5];
		arr[0][0] = 9;
		arr[1][0] = 12;
		arr[1][1] = 15;
		arr[2][0] = 10;
		arr[2][1] = 6;
		arr[2][2] = 8;
		arr[3][0] = 2;
		arr[3][1] = 18;
		arr[3][2] = 9;
		arr[3][3] = 5;
		arr[4][0] = 19;
		arr[4][1] = 7;
		arr[4][2] = 10;
		arr[4][3] = 4;
		arr[4][4] = 16;
		System.out.println(maxSum(0, 0, arr));
		System.out.println(a);

	}

	public static int maxSum(int i, int j, int arr[][]) {
		if (i == 4) {
			int sum1 = arr[i][j];;
			a++;
			return sum1;
		}
		else {
			a++;
		int one =	maxSum(i + 1, j, arr);
		int two =	maxSum(i + 1, j + 1, arr);
		int three = arr[i][j];
			int sum = three + Math.max(one,two);
			return sum;
		}
	}
}
