
public class MainClass {
	public static void main(String[] args) {
		HeapSwiftdownAlgorithm h = new HeapSwiftdownAlgorithm();
		OptimizedHeapSwiftdown o = new OptimizedHeapSwiftdown();
		int[] arr = {10, 6, 7, 5, 15, 17, 12};
		h.heapSort(arr, arr.length);
		o.optimizdHeapSort(arr, arr.length);
		
		h.print(arr);
		System.out.println();
		o.print(arr);
	}
}
