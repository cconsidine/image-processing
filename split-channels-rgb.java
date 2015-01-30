dir=getDirectory("Choose a Directory"); 
print(dir); 
splitDir=dir + "\Split\\"; 
print(splitDir); 
File.makeDirectory(splitDir); 
list = getFileList(dir); 

for (i=0; i<list.length; i++) { 
     if (endsWith(list[i], ".tif")){ 
               print(i + ": " + dir+list[i]); 
             open(dir+list[i]); 
             imgName=getTitle(); 
         baseNameEnd=indexOf(imgName, ".tif"); 
         baseName=substring(imgName, 0, baseNameEnd); 

         run("Split Channels"); 
         selectWindow(imgName + " (blue)"); 
         rename(baseName + "-blue.tiff"); 
         saveAs("Tiff", splitDir+baseName + "-blue.tif"); 
         close(); 
         selectWindow(imgName + " (green)"); 
         saveAs("Tiff", splitDir+baseName + "-green.tif"); 
         close(); 
         selectWindow(imgName + " (red)"); 
         saveAs("Tiff", splitDir+baseName + "-red.tif"); 

         run("Close All"); 
     } 
} 
