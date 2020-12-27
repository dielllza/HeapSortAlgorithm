PImage imageToSort; //<>// //<>//
int imageW;
int imageH;
int screenW;
int screenH;
int[] pixelsOfImage;
int[] positions;
int[] positions2;
int speed =500;
HeapSwiftdownAlgorithm h = new HeapSwiftdownAlgorithm();
OptimizedHeapSwiftdown o = new OptimizedHeapSwiftdown();



void setup() {
  //imageToSort = loadImage("C:\\Users\\fis20\\Desktop\\Sorting\\WIN_20200729_20_14_35_Pro.jpg");
  imageToSort = loadImage("C:\\Users\\fis20\\Desktop\\Sorting\\babyYoda.jpg");
  //imageToSort = loadImage("C:\\Users\\fis20\\Desktop\\Sorting\\babyYodaSmallTest.jpg");
  //imageToSort = loadImage("C:\\Users\\fis20\\Desktop\\Sorting\\shinobuWallpaper.png");
  //imageToSort = loadImage("C:\\Users\\fis20\\Desktop\\Sorting\\babyYodaRlySmall.jpg");
  imageW = imageToSort.width;
  imageH = imageToSort.height;
  screenW  =1700;
  screenH = 1285;
  size(1700, 1285);
  pixelsOfImage  = new int[imageW*imageH]; 
  positions = new int[imageW*imageH];
  positions2 = new int[imageW*imageH];
  //frameRate(240);

  loadPixels();
  imageToSort.loadPixels();


  for (int y=0; y<imageH; y++) {
    for (int x= 0; x<imageW; x++) {
      int Displayloacation = x + y*screenW;
      int imageLocation = x + y*imageToSort.width;

      float r  = red(imageToSort.pixels[imageLocation]);
      float g  = green(imageToSort.pixels[imageLocation]);
      float b  = blue(imageToSort.pixels[imageLocation]);


      pixels[Displayloacation] =color(r, g, b);
      pixelsOfImage[imageLocation] = color(r, g, b);
    }
  }
  //updatePixels();
  //positions = shuffle(positions, positions2);
  //new Generator().generateRandomArray(imageToSort.width*imageToSort.height);
  String[] lines = loadStrings("array.txt");


  for (int i =0; i <lines.length; i++) {    
    positions[i] = Integer.parseInt(lines[i]);
    positions2[i] = Integer.parseInt(lines[i]);
  }
}




private int[] shuffle(int[] shuffle, int[] secondShuffle) {


  for (int i =0; i<imageW*imageH*50; i++) {

    //print("Sorting");
    int x = (int)random(imageW*imageH);
    int y = (int)random(imageW*imageH);

    int temp  = shuffle[x];
    shuffle[x] = shuffle[y];
    shuffle[y] = temp;

    temp  = secondShuffle[x];
    secondShuffle[x] = secondShuffle[y];
    secondShuffle[y] = temp;
  }
  return shuffle;
}

int length;
int elementIndex;
boolean start =true;
void draw() {

  background(0);

  drawPixels(positions, 50);
  drawPixels(positions2, imageToSort.width+100);


  if (start) {
    length = positions.length;
    elementIndex = positions.length/2;

    start = false;
  }


  for (int i =0; i<speed; i++) {
    //for (int j = elementIndex; j >= 0; j--) {
    if (elementIndex>=0) {
      positions  = o.buildHeap(positions, length, elementIndex);
      positions2  = h.buildHeap(positions2, length, elementIndex);
      elementIndex--;
    } else if (length >0) {
      o.swap(positions, 0, length-1);
      h.swap(positions2, 0, length-1);
      o.buildHeap(positions, length-1, 0);
      h.buildHeap(positions2, length-1, 0);
      length--;
    }
  }

}

void drawPixels(int[] positions, int offset) {
  loadPixels();
  for (int y=0; y<imageH; y++) {
    for (int x =0; x<imageW; x++) {
      int Displayloacation = x + y*screenW;
      int imageLocation = x + y*imageToSort.width;
      pixels[Displayloacation+offset] = pixelsOfImage[positions[imageLocation]];
    }
  }
  updatePixels();
}
