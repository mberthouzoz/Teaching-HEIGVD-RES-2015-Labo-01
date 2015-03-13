package ch.heigvd.res.lab01.impl.explorers;

import ch.heigvd.res.lab01.interfaces.IFileExplorer;
import ch.heigvd.res.lab01.interfaces.IFileVisitor;
import java.io.File;
import java.util.Arrays;

/**
 * This implementation of the IFileExplorer interface performs a depth-first
 * exploration of the file system and invokes the visitor for every encountered
 * node (file and directory). When the explorer reaches a directory, it visits all
 * files in the directory and then moves into the subdirectories.
 * 
 * @author Olivier Liechti
 */
public class DFSFileExplorer implements IFileExplorer {

  @Override
  public void explore(File rootDirectory, IFileVisitor vistor) {
    vistor.visit(rootDirectory);
    final File[] list = rootDirectory.listFiles();
    if (list == null) {
        return;
    }
    
    Arrays.sort(list);
    for (final File file : list) {
        if (file.isFile()) {
            vistor.visit(file);
        }
    }

    for (final File file : list) {
        if (file.isDirectory()) {
            explore(file, vistor);
        }
    }
    
    //throw new UnsupportedOperationException("The student has not implemented this method yet.");
  }

}
