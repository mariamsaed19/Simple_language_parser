package withoutEval;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import simple_language.Fun;
import simple_language.Grammer;
import simple_language.ParseException;

public class Testing {
	
	public String test(String line) throws UnsupportedEncodingException {
		InputStream in = new ByteArrayInputStream(line.getBytes("UTF-8"));

			try {
				new BasicGrammar(in).S();
			} catch (withoutEval.ParseException e) {
				// TODO Auto-generated catch block
				return "parse exception";
			}catch(Throwable e) {
				return "lexical error"; 
			}


	
		return "pass";
	}
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String string="a := 3;\r\n" + 
				"b := 7;\r\n" + 
				"\r\n" + 
				"if (tt ^ (a == b)) then\r\n" + 
				"	a := 1;\r\n" + 
				"	b := 2\r\n" + 
				"else\r\n" + 
				"while !(a == b) do\r\n" + 
				"		if (!(a == 6) ^ (b == 7)) then\r\n" + 
				"			a := (a + 1)\r\n" + 
				"		else\r\n" + 
				"			b := (b - 1)\r\n" ;

		Testing t= new Testing();
		System.out.println(t.test(string));
	}

}
