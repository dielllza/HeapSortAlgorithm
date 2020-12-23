public class Algorithm{
	
	private int[] array;
	
	
//	public Algorithm(int[] array){
//		this.array = array;
//	}
	public void setArray(int[] array){
		this.array = array;
	}
	
	public int[] swap(int[] array, int indx1, int indx2){
		int temp = array[indx1];
		array[indx1] = array[indx2];
		array[indx2] = temp;
		return array;
	}
	/**
	public int[] heapSort(int[] array, int length){
		//build the array:
		int elementIndex = length/2;
		for(int i = elementIndex; i >= 0; i--) {
			array = buildHeap(array,length, i);
		}
		
		// sort the array
		while(length > 0 ) {
			swap(array, 0, length-1); // -i-1 i->0 to (length?)
			buildHeap(array, length-1, 0);
			
			length = length - 1;
		}
		return array;
	}
	public int[] optimizdHeapSort(int[] array, int length){
		//build the array:
		int elementIndex = length/2;
		for(int i = elementIndex; i >= 0; i--) {
			array = buildOptimizedHeap(array,length, i);
		}
		
		// sort the array
		while(length > 0 ) {
			swap(array, 0, length-1); // -i-1 i->0 to (length?)
			buildOptimizedHeap(array, length-1, 0);
			
			length = length - 1;
		}
		return array;
	}
	**/
	public int parentIndex(int index) {
		double i = (index-1.0)/2.0;
		if(i < 0) {
			return -1;
		}
		return (int)i;
	}
	public int leftChildIndex(int index, int length) {
		int i = 2*index+1;
		if(i >= length) {
			return -1;
		}
		return i;
	}
	public int rightChildIndex(int index, int length) {
		int i = 2*index+2;
		if(i >= length) {
			return -1;
		}
		return i;
	}

//	public int[] buildHeap(int[] array, int length, int i){
//			int leftIndx = leftChildIndex(i, length);
//			int rightIndx = rightChildIndex(i, length);
//			
//			int maxIndx = i;
//			
//			if(leftIndx != -1 && array[maxIndx] < array[leftIndx]) {
//				maxIndx = leftIndx;
//			}
//			if(rightIndx != -1 && array[maxIndx] < array[rightIndx]) {
//				maxIndx = rightIndx;
//			}
//			if(maxIndx != i) {
//				array = swap(array, i, maxIndx);
//				return buildHeap(array, length, maxIndx);
//			}
//			System.out.print(i + " : ");
//			print(array);
//			System.out.println();
//			return array;
//	}
	
	
//	public int[] buildOptimizedHeap(int[] array, int length, int i){
//		int leftIndx = leftChildIndex(i, length);
//		int rightIndx = rightChildIndex(i, length);
//		int maxIndx = i;
//		if(leftIndx == -1 && rightIndx != -1) {
//			maxIndx = rightIndx;
//		}
//		else if(leftIndx != -1 && rightIndx == -1) {
//			maxIndx = leftIndx;
//		}
//		else if(leftIndx != -1 && rightIndx != -1) {
//			if(array[leftIndx] > array[rightIndx]) {
//				maxIndx = leftIndx;
//			}
//			else {
//				maxIndx = rightIndx;
//			}
//		}
//		else{
//			return bubbleUp(array, length, i);
//		}
//		swap(array, i, maxIndx);
//		System.out.print(i + " : ");
//		print(array);
//		System.out.println();
//		return buildOptimizedHeap(array, length, maxIndx);
//	}
	
	
	public void print(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
	}
}
