package automation.utils;

public class CheckList {
	public static boolean isDescending(int[] array) {
        if (array == null || array.length <= 1) {
            return true; // list rỗng hoặc 1 phần tử thì coi như giảm dần
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                return false; // chỉ cần 1 cặp sai là false
            }
        }
        return true;
    }
	
	public static boolean isAscending(int[] array) {
		if (array == null || array.length <= 1) {
            return true; // list rỗng hoặc 1 phần tử thì coi như giảm dần
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false; // chỉ cần 1 cặp sai là false
            }
        }
        return true;
    }
}
