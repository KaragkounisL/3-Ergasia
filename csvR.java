/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;



/**
 *
 * @author karag
 */
public class csvR {
	ArrayList<String> names = new ArrayList();
	ArrayList<String> iso = new ArrayList();
	
	
	public ArrayList<String> getNames() {
		return names;
	}

	public ArrayList<String> getIso() {
		return iso;
	}
//Διάβασμα του csv και αποθήκευση των δεδομένων σε arraylists
	public void read()throws IOException{
		Scanner scanner = new Scanner(new File("iso-countries.csv"));
		Scanner dataScanner = null;
		int index =0;
		scanner.nextLine();
		while(scanner.hasNextLine()){
		  dataScanner = new Scanner (scanner.nextLine());
		  dataScanner.useDelimiter(";");
		  while (dataScanner.hasNext()){
			String data = dataScanner.next();
			if(index == 0)
				names.add(data);
			else if (index == 2)
			    iso.add(data);
			index++;
		  }
		  index = 0;
		}
	}
	
	
}
