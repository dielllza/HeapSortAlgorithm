PImage imageToSort; //<>// //<>//
int imageW;
int imageH;
int screenW;
int screenH;
int[] pixelsOfImage;
int[] positions;
HeapSwiftdownAlgorithm h = new HeapSwiftdownAlgorithm();
OptimizedHeapSwiftdown o = new OptimizedHeapSwiftdown();



void setup() {
  imageToSort = loadImage("C:\\Users\\fis20\\Desktop\\Sorting\\WIN_20200729_20_14_35_Pro.jpg");
  imageToSort = loadImage("C:\\Users\\fis20\\Desktop\\Sorting\\babyYoda.jpg");
  //imageToSort = loadImage("C:\\Users\\fis20\\Desktop\\Sorting\\babyYodaSmallTest.jpg");
  //imageToSort = loadImage("C:\\Users\\fis20\\Desktop\\Sorting\\shinobuWallpaper.png");
  //imageToSort = loadImage("C:\\Users\\fis20\\Desktop\\Sorting\\babyYodaRlySmall.jpg");
  imageW = imageToSort.width;
  imageH = imageToSort.height;
  screenW  =2000;
  screenH = 1285;
  size(2000, 1285);
  pixelsOfImage  = new int[imageW*imageH]; 
  positions = new int[imageW*imageH];
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
      //imagePixels.put(imageLocation, color(r, g, b));
      positions[imageLocation] = imageLocation;
      //print(imageLocation + ",");
    }
  }
  //updatePixels();
  positions = shuffle(positions);
  //positions = o.optimizdHeapSort(positions, positions.length);

  //positions = h.basicHeapSort(positions, positions.length);
}




private int[] shuffle(int[] shuffle) {


  for (int i =0; i<imageW*imageH; i++) {

    //print("Sorting");
    int x = (int)random(imageW*imageH);
    int y = (int)random(imageW*imageH);

    int temp  = shuffle[x];
    shuffle[x] = shuffle[y];
    shuffle[y] = temp;
  }
  //pixelsOfImage = fixImg(shuffle);

  //o.print(shuffle);

  return shuffle;
}

int length;
int elementIndex;
boolean start =true;
void draw() {

  background(0);

  drawPixels();



  if (start) {
    length = positions.length;
    elementIndex = positions.length/2;

    start = false;
  }
  //println(elementIndex);


  //    for(int i = elementIndex; i >= 0; i--) {

  for (int i =0; i<10000; i++) {
    //for (int j = elementIndex; j >= 0; j--) {
    if (elementIndex>=0) {
      positions  = o.buildHeap(positions, length, elementIndex);
      elementIndex--;
    } else if (length >0) {
      o.swap(positions, 0, length-1);
      o.buildHeap(positions, length-1, 0);
      length--;
    }
  }

  //println();
  //o.print(positions);

  //noLoop();
}

void drawPixels() {
  loadPixels();
  for (int y=0; y<imageH; y++) {
    for (int x =0; x<imageW; x++) {
      int Displayloacation = x + y*screenW;
      int imageLocation = x + y*imageToSort.width;
      pixels[Displayloacation] = pixelsOfImage[positions[imageLocation]];
    }
  }
  updatePixels();
}
