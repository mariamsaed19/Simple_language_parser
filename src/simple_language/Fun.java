package simple_language;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class Fun {
	
	public String test(String line) throws UnsupportedEncodingException {
		InputStream in = new ByteArrayInputStream(line.getBytes("UTF-8"));
		try {
			Grammer g=new Grammer(in);
			//System.out.println(line);
			g.str=line;
			java.util.HashMap<String, Integer> varList=g.S();
			  for (String i : varList.keySet()) { 
		      		System.out.println("key: " + i + " value: " + varList.get(i));
		}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return "parse exception";
		}catch(Throwable e) {
			System.out.println(e.getMessage());
			return "lexical error";
		}
	
		return "pass";
	}
	public static void main(String[] args) throws UnsupportedEncodingException {
 /*
					a:=11; b:=7; c:=4;
					if ((c+b)==a) then
						d := (c-1);
						while !(b==0) do b := (b-1)
					else 
						skip;
						d := 0

  */
		//lookahead var,bool
		// bool first
		//while
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
					"			b := (b - 1)\r\n";


			Fun t= new Fun();
			System.out.println(t.test(string));

}
}
