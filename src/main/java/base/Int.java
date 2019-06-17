package base;

class Int {

	public static void main(String agrs[]) {
		int a = 6;
		int b = a / 4;
		System.out.println("b==" + b);

		switch (a) {
		case 6:
			System.out.println("a==");
		default:
			System.out.println("z==");
		case 3:
			System.out.println("b==");
		}

		int[] arrs = { 12, 56, 10, 5, 96 };
		sortSelect(arrs);
		printArrs(arrs);

		int[] arrs2 = { 622, 45, 55, 20, 232, 12, 11 };
		sortBubble(arrs2);
		printArrs(arrs2);

		int index_para = findInt(20, arrs2);
		System.out.println(index_para);

		int[] arrs3 = { 11, 12, 20, 45, 55, 232, 622 };
		int index_para3 = binaryInt(20, arrs3);
		System.out.println(index_para3);
	}

	// 二分查找
	public static int binaryInt(int para, int[] arrs) {
		int start = 0;
		int end = extracted(arrs);

		while (start <= end) {
			int mid = (start + end) >>> 1;
			if (para == arrs[mid]) {
				return mid;
			} else if (para < arrs[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return -1;
	}

	private static int extracted(int[] arrs) {
		int end = arrs.length - 1;
		return end;
	}

	// 一般查找
	public static int findInt(int para, int[] arrs) {
		if (arrs.length > 0) {
			for (int x = 0; x < arrs.length; x++) {
				if (arrs[x] == para) {
					return x;
				}
			}
		}
		return -1;
	}

	// 选择排序
	public static void sortSelect(int[] arrs) {

		if (arrs.length > 0) {
			for (int x = 0; x < arrs.length - 1; x++) {
				for (int y = x + 1; y < arrs.length - 1; y++) {
					if (arrs[x] > arrs[y]) {
						int temp = arrs[y];
						arrs[y] = arrs[x];
						arrs[x] = temp;
					}
				}
			}
		}
	}

	// 冒泡排序
	public static void sortBubble(int[] arrs) {
		if (arrs.length > 0) {
			for (int x = 0; x < arrs.length - 1; x++) {
				for (int y = 0; y < arrs.length - 1 - x; y++) {
					if (arrs[y] > arrs[y + 1]) {
						int temp = arrs[y + 1];
						arrs[y + 1] = arrs[y];
						arrs[y] = temp;
					}
				}
			}
		}
	}

	// 打印数组
	public static void printArrs(int[] arrs) {
		String temp = "";
		if (arrs.length > 0) {
			for (int x = 0; x < arrs.length; x++) {
				if (x != arrs.length - 1)
					temp += arrs[x] + ",";
				else
					temp += arrs[x];
			}
			System.out.println(temp);
		}
	}
}
