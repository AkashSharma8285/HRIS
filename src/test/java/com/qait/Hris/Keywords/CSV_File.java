package com.qait.Hris.Keywords;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CSV_File {
	/*
	 * public static void main(String[] args) { CSV_File myCSV_File = new
	 * CSV_File(); myCSV_File.CSV("akash"); }
	 */

	String HRIS = ("src" + File.separator + "test" + File.separator + "resources" + File.separator + "TestData"
			+ File.separator + "Item-details.csv");

	public void CSV(HashMap<String, String> contentList) {

		for (String each : contentList.keySet()) {

			BufferedWriter bw = null;
			FileWriter fw = null;

			try {

				fw = new FileWriter(HRIS, true);
				bw = new BufferedWriter(fw);
				bw.write(each + "," + contentList.get(each) + "\n");

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

		System.out.println("Done");
	}

	public String readData(String token) {
		BufferedReader br = null;
		FileReader fr = null;
		ArrayList<String> deviceList = new ArrayList<String>();

		try {

			fr = new FileReader(HRIS);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(fr);

			while ((sCurrentLine = br.readLine()) != null) {
				if (sCurrentLine.split(",")[1].contains(token)) {
					try {

						if (br != null)
							br.close();

						if (fr != null)
							fr.close();

					} catch (IOException ex) {

						ex.printStackTrace();

					}
					return sCurrentLine.split(",")[1];
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
