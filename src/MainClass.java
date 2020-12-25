
public class MainClass {
	public static void main(String[] args) {
		HeapSwiftdownAlgorithm h = new HeapSwiftdownAlgorithm();
		OptimizedHeapSwiftdown o = new OptimizedHeapSwiftdown();
		int[] arr = {
				20, 32, 27, 42, 63, 69, 64, 3, 5, 8, 2, 11, 12, 30, 14, 48, 56, 51, 43, 19, 21, 68, 15, 9, 59, 34, 50, 4, 28, 29, 26, 65, 62, 24, 22, 13, 36, 52, 45, 39, 55, 60, 1, 35, 23, 31, 53, 46, 40, 10, 37, 66, 41, 61, 54, 58, 17, 33, 7, 6, 49, 25, 44, 38, 0, 67, 16, 18, 57, 47};
				int[] a1 = h.basicHeapSort(arr, arr.length); // also returns the array - int[]

		int[] a2 = 	o.optimizdHeapSort(arr, arr.length); // also returns the array - int[]

		boolean test = true;
		for(int i = 0;i<arr.length;i++){
			if(a1[i] != a2[i]){
				test =false;
				break;
			}
		}
		System.out.println("The test  is " + test );
		h.print(arr);
		System.out.println();
		o.print(arr);
	}
}
