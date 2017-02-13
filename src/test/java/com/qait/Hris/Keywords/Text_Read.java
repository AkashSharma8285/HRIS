package com.qait.Hris.Keywords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Text_Read {

	static String Read = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "TestData"
			+ File.separator + "Text_Read.txt";

	public ArrayList<String> readTestData() {

		BufferedReader br = null;
		FileReader fr = null;
		ArrayList<String> deviceList = new ArrayList<String>();

		try {

			fr = new FileReader(Read);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(fr);

			while ((sCurrentLine = br.readLine()) != null) {
				deviceList.add(sCurrentLine);
			}
			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		} catch (IOException e) {

			e.printStackTrace();

		}
		System.out.println(deviceList);
		return deviceList;
	}

}
