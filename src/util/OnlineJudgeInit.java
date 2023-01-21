package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class OnlineJudgeInit {
	private static final String pathSeparator = "\\";
	private static final PrintStream printInConsole = System.out;
	private static final InputStream scanInConsole = System.in;
	private static final String testFolderName = "test-files";
	public static Scanner scanner = null;

	public static void set() {
		String rootPath = System.getProperty("user.dir");
		
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		String className = stackTraceElements[stackTraceElements.length - 1].getClassName();
		String[] args = className.split("[.]");
		String inputFileName = args[args.length - 1] + "-input.txt";
		String outputFileName = args[args.length - 1] + "-output.txt";
		String folderName = args[args.length - 2];

		setInputOutputStream(rootPath, inputFileName, outputFileName, folderName);
	}

	private static void setInputOutputStream(String rootPath, String inputFileName, String outputFileName,
			String folderName) {
		String inputFilePath = rootPath + pathSeparator + testFolderName + pathSeparator + folderName + pathSeparator
				+ inputFileName;
		String outputFilePath = rootPath + pathSeparator + testFolderName + pathSeparator + folderName + pathSeparator
				+ outputFileName;
		set(inputFilePath, outputFilePath);
	}

	// TODO unset method is not completed
	public static void unset() {
		if (scanner != null)
			scanner.close();
		System.setIn(scanInConsole);
		System.setOut(printInConsole);
	}

	public static void set(String inputFilePath, String outputFilePath) {
		setInputStream(inputFilePath);
		setOutputStream(outputFilePath);
		scanner = new Scanner(System.in);
	}

	private static void setInputStream(String inputFilePath) {
		try {
			File initialFile = new File(inputFilePath);
			InputStream in = new FileInputStream(initialFile);
			System.setIn(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void setOutputStream(String outputFile) {
		try {
			PrintStream out = new PrintStream(new FileOutputStream(outputFile), true);
			System.setOut(out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
