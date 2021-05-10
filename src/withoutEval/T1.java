package withoutEval;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.UnsupportedEncodingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import simple_language.Fun;
import simple_language.ParseException;

public class T1 {

	String out="pass";
	String exp;
	Testing t=new Testing();

	@Test
	//valid exp while
	public void test() throws UnsupportedEncodingException {

		exp="a := 1; while !(a==0) do a := (a-1)" ;
		out="pass";
		
		assertEquals(t.test(exp),out);
	}
	
	@Test
	//invalid exp while   a:=a+1 -> a:=(a+1)
	public void test2() throws UnsupportedEncodingException {
		exp="a := 1; b := 12;" + 
				"\n while !((b-a)==0) do a := a + 1" ;
		out="parse exception";
		assertEquals(t.test(exp),out);

	}
	
	@Test
	//invalid aexp
	public void test3() throws UnsupportedEncodingException {
		exp="a := b + c + d + e";
		out="parse exception";
		assertEquals(t.test(exp),out);

	}
	
	@Test
	//valid aexp
	public void test4() throws UnsupportedEncodingException {
		exp="a := (((b + c) + d) + e)";
		out="pass";
		assertEquals(t.test(exp),out);

	}
	
	@Test
	//valid exp while
	public void test5() throws UnsupportedEncodingException {

		exp="a := 5; b:=((a+10)-5);\r\n" + 
				"if !ff then\r\n" + 
				"	c := (20-a);\r\n" + 
				"	b := c\r\n" + 
				"else\r\n" + 
				"	while ((a==4)^!(b==5)) do skip" ;
		out="pass";
		
		
		assertEquals(t.test(exp),out);
	}
	
	@Test
	//invalid exp ;
	public void test6() throws UnsupportedEncodingException {
		exp="while tt do\r\n" + 
				"	while ff do\r\n" + 
				"		a := 5;" ;
		out="parse exception";
		assertEquals(t.test(exp),out);

	}
	
	@Test
	//invalid ;
	public void test7() throws UnsupportedEncodingException {
		exp="if !(a==5) then \r\n" + 
				"	a := (a + a);\r\n" + 
				"else\r\n" + 
				"	a := (a + 5);\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"if ((a==15)^(b==10)) then \r\n" + 
				"	c := 10;\r\n" + 
				"else \r\n" + 
				"	skip;\r\n" + 
				"\r\n" + 
				"while !(c==0) do c := (c - 1); ";
		out="parse exception";
		assertEquals(t.test(exp),out);

	}
	
	@Test
	//ff reserved
	public void test8() throws UnsupportedEncodingException {
		exp="if !((a==15)^((b==10)^!(c==3))) then\r\n" + 
				"	if ((ff==15)^ff) then\r\n" + 
				"		if(ff^(ff==20)) then\r\n" + 
				"			a:= ((a+1)-15);\r\n" + 
				"			b:= (b-1)\r\n" + 
				"		else\r\n" + 
				"			skip\r\n" + 
				"	else\r\n" + 
				"		ff := 1;\r\n" + 
				"		f := 2\r\n" + 
				"else \r\n" + 
				"	while ff do\r\n" + 
				"		fff := 5;";
		out="parse exception";
		assertEquals(t.test(exp),out);

	}
	
	@Test
	//valid
	public void test9() throws UnsupportedEncodingException {
		exp="a:=5 ; \r\n" + 
				"ac:= 6; \r\n" + 
				"while ! (a==0) do\r\n" + 
				"	 if !(ac==a) then \r\n" + 
				"		a:=(a-1) ;\r\n" + 
				"	        ac:=(ac-2)\r\n" + 
				"	 else skip";
		out="pass";
		assertEquals(t.test(exp),out);

	}
	
	
	@Test
	//valid
	public void test10() throws UnsupportedEncodingException {
		exp="add:=0; i:=0 ; while !(i==100) do \n"
				+ "add:=(add+i) ;\n"
				+ " i:=(i+2) \n";
		out="lexical error";
		assertEquals(t.test(exp),out);

	}
	@Test
	//invalid
	public void test11() throws UnsupportedEncodingException {
		exp="a:=0 ; aa:=1 ; c:=5 ; b:=0 ; \r\n" + 
				"while !(c==0) do \r\n" + 
				"	b:=a+aa;\r\n" + 
				" 	a:=aa ;\r\n" + 
				" 	aa:=b;\r\n" + 
				"	c:=c-1;";
		out="parse exception";
		assertEquals(t.test(exp),out);

	}
	@Test
	//valid
	public void test12() throws UnsupportedEncodingException {
		exp="a:=0 ; aa:=1 ; aff:=5 ; ffa:=0 ; f:=(affb+ fffbb) ; f:= (affffa + afffb) ; fff:=5 " ;
		out="pass";
		assertEquals(t.test(exp),"pass");

	}
	@Test
	//negative
	public void test13() throws UnsupportedEncodingException {
		exp="a:=0 ; aa:= -1 " ;
		out="parse exception";
		assertEquals(t.test(exp),out);

	}

	
	

}
