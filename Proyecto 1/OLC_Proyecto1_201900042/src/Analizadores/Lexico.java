package analizadores;
import java_cup.runtime.Symbol; 


public class Lexico implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 65536;
	private final int YY_EOF = 65537;
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yychar;
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	public Lexico (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	public Lexico (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private Lexico () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yychar = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
 
    yyline = 1; 
    yychar = 1; 
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int yy_state_dtrans[] = {
		0
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yychar = yychar
			+ yy_buffer_index - yy_buffer_start;
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NO_ANCHOR,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NO_ANCHOR,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NOT_ACCEPT,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NOT_ACCEPT,
		/* 68 */ YY_NO_ANCHOR,
		/* 69 */ YY_NOT_ACCEPT,
		/* 70 */ YY_NO_ANCHOR,
		/* 71 */ YY_NOT_ACCEPT,
		/* 72 */ YY_NO_ANCHOR,
		/* 73 */ YY_NOT_ACCEPT,
		/* 74 */ YY_NO_ANCHOR,
		/* 75 */ YY_NOT_ACCEPT,
		/* 76 */ YY_NO_ANCHOR,
		/* 77 */ YY_NOT_ACCEPT,
		/* 78 */ YY_NO_ANCHOR,
		/* 79 */ YY_NOT_ACCEPT,
		/* 80 */ YY_NO_ANCHOR,
		/* 81 */ YY_NOT_ACCEPT,
		/* 82 */ YY_NO_ANCHOR,
		/* 83 */ YY_NOT_ACCEPT,
		/* 84 */ YY_NO_ANCHOR,
		/* 85 */ YY_NOT_ACCEPT,
		/* 86 */ YY_NO_ANCHOR,
		/* 87 */ YY_NOT_ACCEPT,
		/* 88 */ YY_NO_ANCHOR,
		/* 89 */ YY_NOT_ACCEPT,
		/* 90 */ YY_NO_ANCHOR,
		/* 91 */ YY_NOT_ACCEPT,
		/* 92 */ YY_NO_ANCHOR,
		/* 93 */ YY_NOT_ACCEPT,
		/* 94 */ YY_NO_ANCHOR,
		/* 95 */ YY_NOT_ACCEPT,
		/* 96 */ YY_NO_ANCHOR,
		/* 97 */ YY_NOT_ACCEPT,
		/* 98 */ YY_NOT_ACCEPT,
		/* 99 */ YY_NOT_ACCEPT,
		/* 100 */ YY_NOT_ACCEPT,
		/* 101 */ YY_NOT_ACCEPT,
		/* 102 */ YY_NOT_ACCEPT,
		/* 103 */ YY_NOT_ACCEPT,
		/* 104 */ YY_NOT_ACCEPT,
		/* 105 */ YY_NOT_ACCEPT,
		/* 106 */ YY_NOT_ACCEPT,
		/* 107 */ YY_NOT_ACCEPT,
		/* 108 */ YY_NOT_ACCEPT,
		/* 109 */ YY_NOT_ACCEPT,
		/* 110 */ YY_NOT_ACCEPT,
		/* 111 */ YY_NOT_ACCEPT,
		/* 112 */ YY_NOT_ACCEPT,
		/* 113 */ YY_NOT_ACCEPT,
		/* 114 */ YY_NOT_ACCEPT,
		/* 115 */ YY_NOT_ACCEPT,
		/* 116 */ YY_NOT_ACCEPT,
		/* 117 */ YY_NOT_ACCEPT,
		/* 118 */ YY_NOT_ACCEPT,
		/* 119 */ YY_NOT_ACCEPT,
		/* 120 */ YY_NOT_ACCEPT,
		/* 121 */ YY_NOT_ACCEPT,
		/* 122 */ YY_NOT_ACCEPT,
		/* 123 */ YY_NOT_ACCEPT,
		/* 124 */ YY_NOT_ACCEPT,
		/* 125 */ YY_NOT_ACCEPT,
		/* 126 */ YY_NOT_ACCEPT,
		/* 127 */ YY_NOT_ACCEPT,
		/* 128 */ YY_NOT_ACCEPT,
		/* 129 */ YY_NOT_ACCEPT,
		/* 130 */ YY_NOT_ACCEPT,
		/* 131 */ YY_NOT_ACCEPT,
		/* 132 */ YY_NOT_ACCEPT,
		/* 133 */ YY_NOT_ACCEPT,
		/* 134 */ YY_NOT_ACCEPT,
		/* 135 */ YY_NOT_ACCEPT,
		/* 136 */ YY_NOT_ACCEPT,
		/* 137 */ YY_NOT_ACCEPT,
		/* 138 */ YY_NOT_ACCEPT,
		/* 139 */ YY_NOT_ACCEPT,
		/* 140 */ YY_NOT_ACCEPT,
		/* 141 */ YY_NOT_ACCEPT,
		/* 142 */ YY_NOT_ACCEPT,
		/* 143 */ YY_NOT_ACCEPT,
		/* 144 */ YY_NOT_ACCEPT,
		/* 145 */ YY_NOT_ACCEPT,
		/* 146 */ YY_NOT_ACCEPT,
		/* 147 */ YY_NOT_ACCEPT,
		/* 148 */ YY_NOT_ACCEPT,
		/* 149 */ YY_NOT_ACCEPT,
		/* 150 */ YY_NOT_ACCEPT,
		/* 151 */ YY_NOT_ACCEPT,
		/* 152 */ YY_NOT_ACCEPT,
		/* 153 */ YY_NOT_ACCEPT,
		/* 154 */ YY_NOT_ACCEPT,
		/* 155 */ YY_NOT_ACCEPT,
		/* 156 */ YY_NOT_ACCEPT,
		/* 157 */ YY_NOT_ACCEPT,
		/* 158 */ YY_NOT_ACCEPT,
		/* 159 */ YY_NOT_ACCEPT,
		/* 160 */ YY_NOT_ACCEPT,
		/* 161 */ YY_NOT_ACCEPT,
		/* 162 */ YY_NOT_ACCEPT,
		/* 163 */ YY_NOT_ACCEPT,
		/* 164 */ YY_NOT_ACCEPT,
		/* 165 */ YY_NOT_ACCEPT,
		/* 166 */ YY_NOT_ACCEPT,
		/* 167 */ YY_NOT_ACCEPT,
		/* 168 */ YY_NOT_ACCEPT,
		/* 169 */ YY_NOT_ACCEPT,
		/* 170 */ YY_NOT_ACCEPT,
		/* 171 */ YY_NOT_ACCEPT,
		/* 172 */ YY_NOT_ACCEPT,
		/* 173 */ YY_NOT_ACCEPT,
		/* 174 */ YY_NOT_ACCEPT,
		/* 175 */ YY_NOT_ACCEPT,
		/* 176 */ YY_NOT_ACCEPT,
		/* 177 */ YY_NOT_ACCEPT,
		/* 178 */ YY_NOT_ACCEPT,
		/* 179 */ YY_NOT_ACCEPT,
		/* 180 */ YY_NOT_ACCEPT,
		/* 181 */ YY_NOT_ACCEPT,
		/* 182 */ YY_NOT_ACCEPT,
		/* 183 */ YY_NOT_ACCEPT,
		/* 184 */ YY_NOT_ACCEPT,
		/* 185 */ YY_NOT_ACCEPT,
		/* 186 */ YY_NOT_ACCEPT,
		/* 187 */ YY_NOT_ACCEPT,
		/* 188 */ YY_NOT_ACCEPT,
		/* 189 */ YY_NOT_ACCEPT,
		/* 190 */ YY_NOT_ACCEPT,
		/* 191 */ YY_NOT_ACCEPT,
		/* 192 */ YY_NOT_ACCEPT,
		/* 193 */ YY_NOT_ACCEPT,
		/* 194 */ YY_NOT_ACCEPT,
		/* 195 */ YY_NOT_ACCEPT,
		/* 196 */ YY_NOT_ACCEPT,
		/* 197 */ YY_NOT_ACCEPT,
		/* 198 */ YY_NOT_ACCEPT,
		/* 199 */ YY_NOT_ACCEPT,
		/* 200 */ YY_NOT_ACCEPT,
		/* 201 */ YY_NOT_ACCEPT,
		/* 202 */ YY_NOT_ACCEPT,
		/* 203 */ YY_NOT_ACCEPT,
		/* 204 */ YY_NOT_ACCEPT,
		/* 205 */ YY_NOT_ACCEPT,
		/* 206 */ YY_NOT_ACCEPT,
		/* 207 */ YY_NOT_ACCEPT,
		/* 208 */ YY_NOT_ACCEPT,
		/* 209 */ YY_NOT_ACCEPT,
		/* 210 */ YY_NOT_ACCEPT,
		/* 211 */ YY_NOT_ACCEPT,
		/* 212 */ YY_NO_ANCHOR,
		/* 213 */ YY_NOT_ACCEPT,
		/* 214 */ YY_NOT_ACCEPT,
		/* 215 */ YY_NOT_ACCEPT,
		/* 216 */ YY_NOT_ACCEPT,
		/* 217 */ YY_NOT_ACCEPT,
		/* 218 */ YY_NOT_ACCEPT,
		/* 219 */ YY_NOT_ACCEPT,
		/* 220 */ YY_NOT_ACCEPT,
		/* 221 */ YY_NOT_ACCEPT,
		/* 222 */ YY_NOT_ACCEPT,
		/* 223 */ YY_NOT_ACCEPT,
		/* 224 */ YY_NOT_ACCEPT,
		/* 225 */ YY_NOT_ACCEPT,
		/* 226 */ YY_NOT_ACCEPT,
		/* 227 */ YY_NOT_ACCEPT,
		/* 228 */ YY_NOT_ACCEPT,
		/* 229 */ YY_NOT_ACCEPT,
		/* 230 */ YY_NOT_ACCEPT,
		/* 231 */ YY_NOT_ACCEPT,
		/* 232 */ YY_NOT_ACCEPT,
		/* 233 */ YY_NOT_ACCEPT,
		/* 234 */ YY_NOT_ACCEPT,
		/* 235 */ YY_NOT_ACCEPT,
		/* 236 */ YY_NOT_ACCEPT,
		/* 237 */ YY_NOT_ACCEPT,
		/* 238 */ YY_NOT_ACCEPT,
		/* 239 */ YY_NOT_ACCEPT,
		/* 240 */ YY_NOT_ACCEPT,
		/* 241 */ YY_NOT_ACCEPT,
		/* 242 */ YY_NOT_ACCEPT,
		/* 243 */ YY_NO_ANCHOR,
		/* 244 */ YY_NOT_ACCEPT,
		/* 245 */ YY_NOT_ACCEPT,
		/* 246 */ YY_NOT_ACCEPT,
		/* 247 */ YY_NOT_ACCEPT,
		/* 248 */ YY_NOT_ACCEPT,
		/* 249 */ YY_NOT_ACCEPT,
		/* 250 */ YY_NOT_ACCEPT,
		/* 251 */ YY_NOT_ACCEPT,
		/* 252 */ YY_NOT_ACCEPT,
		/* 253 */ YY_NOT_ACCEPT,
		/* 254 */ YY_NOT_ACCEPT,
		/* 255 */ YY_NOT_ACCEPT,
		/* 256 */ YY_NOT_ACCEPT,
		/* 257 */ YY_NOT_ACCEPT,
		/* 258 */ YY_NOT_ACCEPT,
		/* 259 */ YY_NOT_ACCEPT,
		/* 260 */ YY_NOT_ACCEPT,
		/* 261 */ YY_NOT_ACCEPT,
		/* 262 */ YY_NOT_ACCEPT,
		/* 263 */ YY_NOT_ACCEPT,
		/* 264 */ YY_NOT_ACCEPT,
		/* 265 */ YY_NOT_ACCEPT,
		/* 266 */ YY_NOT_ACCEPT,
		/* 267 */ YY_NOT_ACCEPT,
		/* 268 */ YY_NOT_ACCEPT,
		/* 269 */ YY_NOT_ACCEPT,
		/* 270 */ YY_NOT_ACCEPT
	};
	private int yy_cmap[] = unpackFromString(1,65538,
"45:9,40,39,45:2,40,45:18,21,45,44,45,48,45:2,47,26,27,37,36,25,30,42,38,54," +
"55,56,41,57,51,50,52:2,53,45,24,45,35,31,34,45,5,17,12,4,2,7,13,19,10,23,46" +
",8,14,11,6,20,22,3,9,18,16,1,46:4,28,45,29,45,15,45,5,17,12,4,2,7,13,19,10," +
"23,46,8,14,11,6,20,22,3,9,18,16,1,46:4,49,43,58,45:51,59,45:13,33,45:2,32,5" +
"9,45:30,32,59,45:7988,59,45:57319,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,271,
"0,1,2,3,1:6,4,1:4,5,1,6,1:3,7,1,8,1:2,9,1:7,10,1:15,11,1:14,12,13,14,1,15,1" +
"6,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,4" +
"1,42,43,44,45,46,9,40,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64" +
",65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89" +
",90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110," +
"111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129" +
",130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,14" +
"8,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,1" +
"67,168,169,170,171,98,172,173,174,175,176,177,178,179,180,181,182,183,184,1" +
"85,186,187,188,189,190,191,192,193,194,195,196,197,198,199,200,201,202,203," +
"204,205,206,207,208,209,210,211,212,213")[0];

	private int yy_nxt[][] = unpackFromString(214,60,
"1,2,66,212,243,68,70,72,68,74,76,78,80,68,82,84,68,86,68,88,90,3,68:2,4,5,6" +
",7,8,9,10,68,92,68,11,12,13,14,15,16,3,17,68:2,94,68:2,96,68:2,17:8,68:2,-1" +
":62,65,-1:78,3,-1:18,3,-1:50,19,-1:65,100,21,-1:62,17,101,-1:7,17:8,-1:3,21" +
":38,-1,21:20,-1:15,123,-1:65,26,-1:19,26,-1,26,-1:6,26:8,-1:17,166,-1:59,19" +
"5,-1:47,105,-1:67,67,-1:11,69,-1:54,217,-1:43,106,-1:72,75,-1:62,244,-1,107" +
",-1:44,77,-1:4,79,-1:5,81,-1:58,216,-1:46,83,-1:7,18,-1:58,108,-1:61,85,-1:" +
"2,87,-1:53,109,-1:67,89,-1:54,23,-1:53,91,93,-1:64,218,-1:50,265,-1:3,95,-1" +
":3,215,-1:62,110,-1:47,97:14,-1,97:5,-1,97:2,-1:17,97,-1:4,97,-1:3,97:8,-1:" +
"12,245,-1:2,111,-1:52,98,-1:73,221,-1:44,99,-1:68,219,-1:50,213,214,-1:56,1" +
"12,246,-1:88,20,-1:37,113,-1:2,114,-1:46,102:43,22,102:15,-1:4,24,-1:56,103" +
":14,-1,103:5,-1,103:2,-1:22,103,-1,104,-1:10,103,-1,97:14,25,97:5,-1,97:2,-" +
"1:17,97,-1:4,97,-1:3,97:8,-1:8,116,-1:62,117,-1:2,258,-1:48,100:36,119,-1,1" +
"00:21,-1:47,27,-1:61,120,-1:14,222,-1:67,220,-1:49,224,-1:67,28,-1:58,122,-" +
"1:66,125,-1:46,126,-1:61,128,-1:69,129,-1:5,259,-1:44,29,-1:64,249,-1:56,22" +
"6,-1:69,131,-1:46,30,-1:92,31,-1:71,134,-1,228,135,-1,136,-1:10,138,-1:59,3" +
"2,-1:60,139,-1,140,-1:4,141,-1:5,142,-1:49,143,-1:60,33,-1:50,145,-1:60,147" +
",-1:68,230,-1:48,231,-1:18,267,-1:43,149,-1:60,34,-1:57,35,-1:67,151,-1:98," +
"152:4,-1:58,152:3,-1:55,153,-1:3,154:2,155,-1:21,260,-1:56,233,-1:60,158,-1" +
":45,159,-1:7,36,-1:51,160,-1:7,255,-1:54,232,-1:60,161,-1:59,37,-1:62,162,-" +
"1:64,163,-1:51,38,-1:58,39,-1:60,40,-1:56,235,-1:68,236,-1:105,167,-1:52,15" +
"2,-1:5,152,-1:6,152,-1:109,152:3,-1:5,168,-1:60,41,-1:67,173,-1:61,174,-1:6" +
"4,238,-1:52,42,-1:53,177,-1:64,178,-1:57,256,-1:62,43,-1:70,239,-1:84,44,-1" +
":15,183,-1:65,45,-1:53,46,-1:59,47,-1:62,270,-1:65,184,-1:63,185,-1:54,187," +
"-1:53,48,-1:57,49,-1:59,50,-1:59,51,-1:61,189,-1:63,52,-1:55,53,-1:60,54,-1" +
":63,192,-1:60,55,-1:52,193,-1:73,194,-1:44,56,-1:70,240,-1:47,196,-1:59,57," +
"-1:63,197,-1:59,58,-1:56,198,-1:67,199,-1:62,201,-1:56,59,-1:53,202,-1:62,6" +
"0,-1:69,203,-1:43,204,-1:66,61,-1:53,205,-1:67,206,-1:54,208,-1:71,209,-1:5" +
"1,210,-1:58,62,-1:55,211,-1:60,63,-1:61,64,-1:53,71,-1:60,118,-1:74,262,-1:" +
"43,115,-1:65,121,-1:57,223,-1:65,124,-1:49,127,-1:73,137,-1:46,250,-1:61,25" +
"1,-1:65,227,-1:66,263,-1:51,144,-1:51,252,-1:69,234,-1:58,264,-1:66,261,-1:" +
"46,164,-1:57,176,-1:68,172,-1:49,169,-1:62,181,-1:64,182,-1:52,190,-1:62,18" +
"6,-1:69,191,-1:45,200,-1:62,242,-1:57,207,-1:58,73,-1:63,247,-1:65,225,-1:4" +
"9,248,-1:60,229,-1:67,148,-1:66,150,-1:51,146,-1:53,156,-1:60,165,-1:57,180" +
",-1:68,237,-1:49,175,-1:63,188,-1:59,130,-1:55,132,-1:67,266,-1:54,170,-1:5" +
"6,179,-1:59,133,-1:67,157,-1:54,171,-1:72,257,-1:52,254,-1:53,253,-1:57,241" +
",-1:74,268,-1:52,269,-1:48");

	public java_cup.runtime.Symbol next_token ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {
				return null;
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:
						
					case -2:
						break;
					case 2:
						{
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
}
					case -3:
						break;
					case 3:
						{}
					case -4:
						break;
					case 4:
						{return new Symbol(sym.PTCOMA,yyline,yychar, yytext());}
					case -5:
						break;
					case 5:
						{return new Symbol(sym.COMA,yyline,yychar, yytext());}
					case -6:
						break;
					case 6:
						{return new Symbol(sym.PARIZQ,yyline,yychar, yytext());}
					case -7:
						break;
					case 7:
						{return new Symbol(sym.PARDER,yyline,yychar, yytext());}
					case -8:
						break;
					case 8:
						{return new Symbol(sym.CORIZQ,yyline,yychar, yytext());}
					case -9:
						break;
					case 9:
						{return new Symbol(sym.CORDER,yyline,yychar, yytext());}
					case -10:
						break;
					case 10:
						{return new Symbol(sym.RESTA,yyline,yychar, yytext());}
					case -11:
						break;
					case 11:
						{return new Symbol(sym.INTCIERRA,yyline,yychar, yytext());}
					case -12:
						break;
					case 12:
						{return new Symbol(sym.IGUAL,yyline,yychar, yytext());}
					case -13:
						break;
					case 13:
						{return new Symbol(sym.SUMA,yyline,yychar, yytext());}
					case -14:
						break;
					case 14:
						{return new Symbol(sym.MULTIPLICACION,yyline,yychar, yytext());}
					case -15:
						break;
					case 15:
						{return new Symbol(sym.DIVIDIR,yyline,yychar, yytext());}
					case -16:
						break;
					case 16:
						{yychar=1;}
					case -17:
						break;
					case 17:
						{return new Symbol(sym.ENTERO,yyline,yychar, yytext());}
					case -18:
						break;
					case 18:
						{return new Symbol(sym.RSI,yyline,yychar, yytext());}
					case -19:
						break;
					case 19:
						{return new Symbol(sym.FLECHA,yyline,yychar, yytext());}
					case -20:
						break;
					case 20:
						{return new Symbol(sym.INTABRE,yyline,yychar, yytext());}
					case -21:
						break;
					case 21:
						{return new Symbol(sym.COMENTARIOL,yyline,yychar, yytext());}
					case -22:
						break;
					case 22:
						{return new Symbol(sym.CADENA,yyline,yychar, yytext());}
					case -23:
						break;
					case 23:
						{return new Symbol(sym.RFIN,yyline,yychar,yytext());}
					case -24:
						break;
					case 24:
						{return new Symbol(sym.MODULAR,yyline,yychar, yytext());}
					case -25:
						break;
					case 25:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -26:
						break;
					case 26:
						{return new Symbol(sym.DECIMAL,yyline,yychar, yytext());}
					case -27:
						break;
					case 27:
						{return new Symbol(sym.CARACTER,yyline,yychar, yytext());}
					case -28:
						break;
					case 28:
						{return new Symbol(sym.ROSI,yyline,yychar, yytext());}
					case -29:
						break;
					case 29:
						{return new Symbol(sym.RCOMO,yyline,yychar,yytext());}
					case -30:
						break;
					case 30:
						{return new Symbol(sym.RPARA,yyline,yychar, yytext());}
					case -31:
						break;
					case 31:
						{return new Symbol(sym.COMENTARIOML,yyline,yychar, yytext());}
					case -32:
						break;
					case 32:
						{return new Symbol(sym.RFALSO,yyline,yychar,yytext());}
					case -33:
						break;
					case 33:
						{return new Symbol(sym.RSEGUN,yyline,yychar, yytext());}
					case -34:
						break;
					case 34:
						{return new Symbol(sym.RHASTA,yyline,yychar, yytext());}
					case -35:
						break;
					case 35:
						{return new Symbol(sym.RHACER,yyline,yychar, yytext());}
					case -36:
						break;
					case 36:
						{return new Symbol(sym.RFINSI,yyline,yychar, yytext());}
					case -37:
						break;
					case 37:
						{return new Symbol(sym.RINICIO,yyline,yychar,yytext());}
					case -38:
						break;
					case 38:
						{return new Symbol(sym.RNUMERO,yyline,yychar,yytext());}
					case -39:
						break;
					case 39:
						{return new Symbol(sym.RCADENA,yyline,yychar,yytext());}
					case -40:
						break;
					case 40:
						{return new Symbol(sym.RMETODO,yyline,yychar, yytext());}
					case -41:
						break;
					case 41:
						{return new Symbol(sym.RREPETIR,yyline,yychar, yytext());}
					case -42:
						break;
					case 42:
						{return new Symbol(sym.RFUNCION,yyline,yychar, yytext());}
					case -43:
						break;
					case 43:
						{return new Symbol(sym.RBOOLEAN,yyline,yychar,yytext());}
					case -44:
						break;
					case 44:
						{return new Symbol(sym.CARASCCI,yyline,yychar, yytext());}
					case -45:
						break;
					case 45:
						{return new Symbol(sym.RENTONCES,yyline,yychar, yytext());}
					case -46:
						break;
					case 46:
						{return new Symbol(sym.REJECUTAR,yyline,yychar, yytext());}
					case -47:
						break;
					case 47:
						{return new Symbol(sym.RRETORNAR,yyline,yychar, yytext());}
					case -48:
						break;
					case 48:
						{return new Symbol(sym.RFINPARA,yyline,yychar, yytext());}
					case -49:
						break;
					case 49:
						{return new Symbol(sym.RINGRESAR,yyline,yychar,yytext());}
					case -50:
						break;
					case 50:
						{return new Symbol(sym.RIMPRIMIR,yyline,yychar, yytext());}
					case -51:
						break;
					case 51:
						{return new Symbol(sym.RCARACTER,yyline,yychar,yytext());}
					case -52:
						break;
					case 52:
						{return new Symbol(sym.RMIENTRAS,yyline,yychar, yytext());}
					case -53:
						break;
					case 53:
						{return new Symbol(sym.POTENCIA,yyline,yychar, yytext());}
					case -54:
						break;
					case 54:
						{return new Symbol(sym.RVERDADERO,yyline,yychar,yytext());}
					case -55:
						break;
					case 55:
						{return new Symbol(sym.RFINSEGUN,yyline,yychar, yytext());}
					case -56:
						break;
					case 56:
						{return new Symbol(sym.RCONVALOR,yyline,yychar,yytext());}
					case -57:
						break;
					case 57:
						{return new Symbol(sym.RHASTAQUE,yyline,yychar, yytext());}
					case -58:
						break;
					case 58:
						{return new Symbol(sym.RFINMETODO,yyline,yychar, yytext());}
					case -59:
						break;
					case 59:
						{return new Symbol(sym.RFINFUNCION,yyline,yychar, yytext());}
					case -60:
						break;
					case 60:
						{return new Symbol(sym.RIMPRIMIRNL,yyline,yychar, yytext());}
					case -61:
						break;
					case 61:
						{return new Symbol(sym.RFINMIENTRAS,yyline,yychar, yytext());}
					case -62:
						break;
					case 62:
						{return new Symbol(sym.RCONPARAMETROS,yyline,yychar, yytext());}
					case -63:
						break;
					case 63:
						{return new Symbol(sym.RDELOCONTRARIO,yyline,yychar, yytext());}
					case -64:
						break;
					case 64:
						{return new Symbol(sym.RCONINCREMENTAL,yyline,yychar, yytext());}
					case -65:
						break;
					case 66:
						{
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
}
					case -66:
						break;
					case 68:
						{
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
}
					case -67:
						break;
					case 70:
						{
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
}
					case -68:
						break;
					case 72:
						{
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
}
					case -69:
						break;
					case 74:
						{
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
}
					case -70:
						break;
					case 76:
						{
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
}
					case -71:
						break;
					case 78:
						{
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
}
					case -72:
						break;
					case 80:
						{
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
}
					case -73:
						break;
					case 82:
						{
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
}
					case -74:
						break;
					case 84:
						{
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
}
					case -75:
						break;
					case 86:
						{
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
}
					case -76:
						break;
					case 88:
						{
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
}
					case -77:
						break;
					case 90:
						{
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
}
					case -78:
						break;
					case 92:
						{
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
}
					case -79:
						break;
					case 94:
						{
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
}
					case -80:
						break;
					case 96:
						{
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
}
					case -81:
						break;
					case 212:
						{
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
}
					case -82:
						break;
					case 243:
						{
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
}
					case -83:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
