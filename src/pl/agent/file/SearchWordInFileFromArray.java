package pl.agent.file;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//to trzeba zaimportowac z jara commons-lang3-3.1.jar
import org.apache.commons.lang3.StringUtils;

public class SearchWordInFileFromArray {
	
	static ReadFile readFile = new ReadFile();
	static int resulds;
	
	public static List<String> words(){
		List<String> tokens = new ArrayList<String>();
		
		tokens.add("ma");
		tokens.add("kota");
		tokens.add("nie");
		tokens.add("cos");
		tokens.add("tam");
		
		return tokens;
	}
	
	
	public static int searchWord(int resulds){
		
		String patternString = "\\b(" + StringUtils.join(words(), "|") + ")\\b";
		Pattern pat = Pattern.compile(patternString);
        Matcher mat = pat.matcher(readFile.text);
		
        resulds = 0;
        
		while (mat.find()) {
			
			//wyswietla znalezione slowo
		   
			//System.out.println(mat.group(1));
		   
			
			//zlicza ile slow znaleziono
		   resulds++;
		}
		return resulds;
	}

	public static void main(String[] args) throws IOException {
		
		readFile.readFile("c:/plik.txt");
		
		System.out.println(searchWord(resulds));
		
		

	}

}
