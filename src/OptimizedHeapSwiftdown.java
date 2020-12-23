
public class OptimizedHeapSwiftdown extends Algorithm{
	
//	private int[] array;
//	
//	public void setArray(int[] array){
//		this.array = array;
//	}
	
	public int[] optimizdHeapSort(int[] array, int length){
		return super.heapSort(array, length, (int[] arr, int l, int i) -> buildOptimizedHeap(arr, l, i));
	}
	
	public int[] buildOptimizedHeap(int[] array, int length, int i){
		int leftIndx = leftChildIndex(i, length);
		int rightIndx = rightChildIndex(i, length);
		int maxIndx = i;
		if(leftIndx == -1 && rightIndx != -1) {
			maxIndx = rightIndx;
		}
		else if(leftIndx != -1 && rightIndx == -1) {
			maxIndx = leftIndx;
		}
		else if(leftIndx != -1 && rightIndx != -1) {
			if(array[leftIndx] > array[rightIndx]) {
				maxIndx = leftIndx;
			}
			else {
				maxIndx = rightIndx;
			}
		}
		else{
			return bubbleUp(array, length, i);
		}
		swap(array, i, maxIndx);
		return buildOptimizedHeap(array, length, maxIndx);
	}
	private int[] bubbleUp(int[] array, int length, int i) {
		int p = parentIndex(i);
		if(p == -1) {
			return array;
		}
		if(array[i] > array[p]) {
			swap(array, i, p);
			return bubbleUp(array, length, p);
		}
		return array;
	}
}
