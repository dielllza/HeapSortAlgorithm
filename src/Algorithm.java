public class Algorithm{




//	public Algorithm(int[] array){
//		this.array = array;
//	}
//	public void setArray(int[] array){
//	this.array = array;
//}


	public int[] heapSort(int[] array, int length, Heap heapInterface) {

		int elementIndex = length/2;
		for(int i = elementIndex; i >= 0; i--) {
			array = heapInterface.buildHeap(array, length, i);
		}


		// sort the array
		while(length > 0 ) {
			swap(array, 0, length-1); // -i-1 i->0 to (length?)
			heapInterface.buildHeap(array, length-1, 0);

			length = length - 1;
		}
		return array;
	}

	public int[] swap(int[] array, int indx1, int indx2){
		int temp = array[indx1];
		array[indx1] = array[indx2];
		array[indx2] = temp;
		return array;
	}
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

	public void print(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
	}
}
