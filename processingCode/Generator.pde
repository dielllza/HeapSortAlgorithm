import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Generator {
public  void generateRandomArray(int numberOfEntries) {
    ArrayList<Integer> sortedEntries = new ArrayList();
    ArrayList<Integer> shuffledArray = new ArrayList();
    for (int i = 0; i < numberOfEntries; i++) {
      sortedEntries.add(i);
    }


    while (shuffledArray.size() < numberOfEntries) {
      int r1 = (int) (Math.random() * sortedEntries.size());
      int r2 = (int) (Math.random() * sortedEntries.size());

      if (r1 < r2) {
        shuffledArray.add(sortedEntries.get(r2));
        sortedEntries.remove(r2);
      } else {
        shuffledArray.add(sortedEntries.get(r1));
        sortedEntries.remove(r1);
      }
    }

    String array = "";
    for (Integer number : shuffledArray) {
      array += number+"\n";
    }

    try {
      FileWriter fileWriter = new FileWriter(new File("C:\\Users\\fis20\\Desktop\\Sorting\\processingCode\\HeapSort\\array.txt"));

      fileWriter.write(array);
      fileWriter.close();
    } 
    catch (Exception e) {
      print("failed");
    }
  }
}
