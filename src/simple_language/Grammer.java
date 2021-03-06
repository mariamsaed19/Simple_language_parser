/* Generated By:JavaCC: Do not edit this line. Grammer.java */
package simple_language;

import java.io.StringReader;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
public class Grammer implements GrammerConstants {

    public static void main(String[] args){
      try {
        new Grammer(new java.io.StringReader(args[0])).S();
        System.out.println("Syntax checked");
      }catch(Throwable  e) {
        System.out.println("Syntax check failed");
      }

    }

  final public java.util.HashMap<String, Integer> S() throws ParseException {
  //create a global hash maps to store variables and their values
  java.util.HashMap<String, Integer> varList = new java.util.HashMap<String, Integer>();
  if(map!=null) {
                varList=map;
        }
    Com(varList,true);
{if (true) return varList;}
    jj_consume_token(0);
    throw new Error("Missing return statement in function");
  }

// to use a variable, we have to check if it already exists in varList first/
  final public int AExp(java.util.HashMap<String, Integer> varList,String variable,boolean flag) throws ParseException {
  String var;int n1,n2; Token sign,num;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case Digit:
      num = jj_consume_token(Digit);
        int val=Integer.parseInt(num.image);
        if(flag&&variable!=null) {
                varList.put(variable,val);
        }
        {if (true) return val;}
      break;
    case 22:
    case 23:
      var = Var();
        if(varList.get(var) == null) {

                {if (true) return 0;}
        }else {

                {if (true) return varList.get(var);}
        }
      break;
    case 9:
      jj_consume_token(9);
      n1 = AExp(varList,variable,flag);
      sign = jj_consume_token(Sign);
      n2 = AExp(varList,variable,flag);
      jj_consume_token(10);
  String s=sign.image;
  int res=0;
  if(s.equals("+")) {
    res=n1+n2;
  }
  else {
        res=n1-n2;
  }
  if(flag&&variable!=null) {
        varList.put(variable,res);
  }
  {if (true) return res;}
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public boolean BExp(java.util.HashMap<String, Integer> varList,boolean flag) throws ParseException {
 boolean b;
    if (jj_2_1(2147483647)) {
      b = Bool();
    {if (true) return b;}
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 9:
        jj_consume_token(9);
        b = Exp1(varList,flag);
        jj_consume_token(10);
    {if (true) return b;}
        break;
      case 12:
        jj_consume_token(12);
        b = BExp(varList,flag);
    {if (true) return !b;}
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public boolean Bool() throws ParseException {
  Token x;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 20:
      x = jj_consume_token(20);
    {if (true) return false;}
      break;
    case 21:
      x = jj_consume_token(21);
    {if (true) return true;}
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public String Var() throws ParseException {
 Token matchedTok;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 22:
      matchedTok = jj_consume_token(22);
          {if (true) return matchedTok.image;}
      break;
    case 23:
      matchedTok = jj_consume_token(23);
          {if (true) return matchedTok.image;}
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public boolean Exp1(java.util.HashMap<String, Integer> varList,boolean flag) throws ParseException {
 boolean b1, b2; int n1,n2;
    if (jj_2_2(2147483647)) {
      n1 = AExp(varList,null,flag);
      jj_consume_token(11);
      n2 = AExp(varList,null,flag);
    // if equal return true else return false
    {if (true) return n1==n2;}
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 9:
      case 12:
      case 20:
      case 21:
        b1 = BExp(varList,flag);
        jj_consume_token(13);
        b2 = BExp(varList,flag);
    {if (true) return b1 && b2;}
        break;
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    throw new Error("Missing return statement in function");
  }

//hash map is passed as an argument to keep the same data structure for all variables/
  final public void Com(java.util.HashMap<String, Integer> varList,boolean flag) throws ParseException {
  String var; //used to store variable name in case of assignment operations
  int value = 0; //needs to be returned from AExp
  boolean b; //used to store the value of if or while condition
  Token x;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 19:
      jj_consume_token(19);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 8:
        jj_consume_token(8);
        Com(varList,flag);
        break;
      default:
        jj_la1[5] = jj_gen;
        ;
      }
      break;
    default:
      jj_la1[9] = jj_gen;
      if (jj_2_3(2147483647)) {
        var = Var();
        jj_consume_token(7);
        AExp(varList,var,flag);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 8:
          jj_consume_token(8);
          Com(varList,flag);
          break;
        default:
          jj_la1[6] = jj_gen;
          ;
        }
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 14:
          jj_consume_token(14);
          b = BExp(varList,flag);
          jj_consume_token(15);
          Com(varList,b&&flag);
          jj_consume_token(16);
          Com(varList,!b && flag);
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case 8:
            jj_consume_token(8);
            Com(varList,!b&&flag);
            break;
          default:
            jj_la1[7] = jj_gen;
            ;
          }
          break;
        case 17:
          jj_consume_token(17);
          b = BExp(varList,flag);
          jj_consume_token(18);
          Com(varList,b&flag);
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case 8:
            jj_consume_token(8);
            Com(varList,b&flag);
            break;
          default:
            jj_la1[8] = jj_gen;
            ;
          }
          //TODO
                if(b&flag) {
            InputStream in;
                        try {
                        in = new ByteArrayInputStream(str.getBytes("UTF-8"));
                Grammer g= new Grammer(in);

                String exp=str.substring(str.indexOf("while"));
                int i=exp.indexOf("else");
                if(i==-1) {
                g.str=exp;
                }
                else {
                  g.str=exp.substring(0,i);
                }
                g.map=varList;
                g.S();
                        } catch (UnsupportedEncodingException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }

                }
          break;
        default:
          jj_la1[10] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  private boolean jj_3R_7() {
    if (jj_3R_3()) return true;
    return false;
  }

  private boolean jj_3_2() {
    if (jj_3R_2()) return true;
    if (jj_scan_token(11)) return true;
    if (jj_3R_2()) return true;
    return false;
  }

  private boolean jj_3R_9() {
    if (jj_scan_token(22)) return true;
    return false;
  }

  private boolean jj_3_1() {
    if (jj_3R_1()) return true;
    return false;
  }

  private boolean jj_3R_3() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_9()) {
    jj_scanpos = xsp;
    if (jj_3R_10()) return true;
    }
    return false;
  }

  private boolean jj_3R_6() {
    if (jj_scan_token(Digit)) return true;
    return false;
  }

  private boolean jj_3R_2() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_6()) {
    jj_scanpos = xsp;
    if (jj_3R_7()) {
    jj_scanpos = xsp;
    if (jj_3R_8()) return true;
    }
    }
    return false;
  }

  private boolean jj_3R_5() {
    if (jj_scan_token(21)) return true;
    return false;
  }

  private boolean jj_3R_8() {
    if (jj_scan_token(9)) return true;
    if (jj_3R_2()) return true;
    if (jj_scan_token(Sign)) return true;
    if (jj_3R_2()) return true;
    if (jj_scan_token(10)) return true;
    return false;
  }

  private boolean jj_3R_1() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_4()) {
    jj_scanpos = xsp;
    if (jj_3R_5()) return true;
    }
    return false;
  }

  private boolean jj_3R_4() {
    if (jj_scan_token(20)) return true;
    return false;
  }

  private boolean jj_3_3() {
    if (jj_3R_3()) return true;
    return false;
  }

  private boolean jj_3R_10() {
    if (jj_scan_token(23)) return true;
    return false;
  }

  /** Generated Token Manager. */
  public GrammerTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[11];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0xc00220,0x1200,0x300000,0xc00000,0x301200,0x100,0x100,0x100,0x100,0x80000,0x24000,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[3];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public Grammer(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Grammer(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new GrammerTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public Grammer(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new GrammerTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public Grammer(GrammerTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(GrammerTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;
public String str;
public java.util.HashMap<String, Integer> map;
  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[24];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 11; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 24; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 3; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
