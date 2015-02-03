dir1 = getDirectory("Choose Source Directory "); 
list = getFileList(dir1); 

for (i=0; i<list.length; i++) { 

	if (File.isDirectory(dir1+list[i])){
	} else { 
        path = dir1+list[i]; 
        if (endsWith(path, ".db")){        	
        } else { 
			open(path); 
             if (bitDepth!=24){
             } else	{ 
                setBatchMode(true); 
				title = File.nameWithoutExtension; 
                setMinAndMax(30,125); 

             	run("Split Channels"); 
                
                run("Colocalization Threshold", "channel_1=["+title+".tif (green)] channel_2=["+title+".tif (blue)] use=None channel=[Green : Blue] include");
                run("Close All");           
             	setBatchMode(false); 
            } 
        } 
    }
} 
