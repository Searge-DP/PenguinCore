package joshie.lib.helpers;

import java.awt.Component;
import java.awt.HeadlessException;
import java.io.File;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FileUtils;

import joshie.enchiridion.helpers.FileHelper;

public class FileCopier {
	private static File last_directory = null;
	
	public static File getFileFromUser() {
		//Only allow pngs to be selected, force the window on top.
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "png", "jpg", "jpeg", "gif");
        JFileChooser fileChooser = new JFileChooser() {
            @Override
            protected JDialog createDialog(Component parent) throws HeadlessException {
                JDialog dialog = super.createDialog(parent);
                dialog.setAlwaysOnTop(true);
                return dialog;
            }
        };

        if (last_directory == null) {
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        } else {
            fileChooser.setCurrentDirectory(last_directory);
        }
        
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
        	File selectedFile = fileChooser.getSelectedFile();
        	last_directory = selectedFile.getParentFile();
        	return selectedFile;
        }
        
        return null;
	}

	public static File copyFileFromUser(File directory) {
		File userFile = getFileFromUser();
		File newFile = new File(directory, userFile.getName());
		try {
			if (newFile.exists()) return newFile;
			FileUtils.copyFile(userFile, newFile); //Copy the file over
			return newFile;
		} catch (Exception e) { return null; }
	}
}