package by.darashuk.fileRead;

import java.io.File;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class TextReader {

	private final static Logger logger = Logger.getLogger(TextReader.class);
	private static TextReader instance;

	private TextReader() {
	}

	public static TextReader getInstance() {
		if (instance == null) {
			instance = new TextReader();
		}
		return instance;
	}

	public String readFromFile(String fileName) {
		logger.info("IN readFromFile() : File are reading");
		StringBuilder stringBuilder = new StringBuilder();

		try (Scanner in = new Scanner(new File(fileName), StandardCharsets.UTF_8)) {
			while (in.hasNext()) {
				stringBuilder.append(in.nextLine()).append("\n");
			}
		} catch (IOException e) {
			logger.error("IN readFromFile() : File " + fileName + " not found!!!");
		}
		return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
	}
}
