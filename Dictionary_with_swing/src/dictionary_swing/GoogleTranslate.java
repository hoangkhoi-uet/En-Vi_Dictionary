/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary_swing;
import java.io.InputStreamReader;
/**
 *
 * @author DELL
 */
import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class GoogleTranslate {

    private static final String GOOGLE_TRANSLATE_URL = "http://translate.google.com/translate_a/single";

    /**
     * Completes the complicated process of generating the URL
     * @param text The text that you wish to generate
     * @return The generated URL as a string.
     */
    private static String generateURL(String text) throws UnsupportedEncodingException {
        String encoded = URLEncoder.encode(text, "UTF-8"); //Encode
        StringBuilder sb = new StringBuilder();
        sb.append(GOOGLE_TRANSLATE_URL);
        sb.append("?client=webapp"); //The client parameter
        sb.append("&hl=en");        //The language of the UI?
        sb.append("&sl=");      
        sb.append("en");
        sb.append("&tl=");      
        sb.append("vi");
        sb.append("&q=");
        sb.append(encoded);
        sb.append("&multires=1");   //Necessary but unknown parameters
        sb.append("&otf=0");
        sb.append("&pc=0");
        sb.append("&trs=1");
        sb.append("&ssel=0");
        sb.append("&tsel=0");
        sb.append("&kc=1");
        sb.append("&dt=t");//This parameters requests the translated text back.
        sb.append("&ie=UTF-8");     //Input encoding
        sb.append("&oe=UTF-8");     //Output encoding
        sb.append("&tk=");          //Token authentication parameter
        sb.append(generateToken(text));
        return sb.toString();
    }

    /**
     * Translate text 
     * @param text The text you actually want to translate
     * @return the translated text.
     * @throws IOException if it cannot complete the request
     */
    public static String translate(String text) throws IOException {
        String urlText = generateURL(text);
        URL url = new URL(urlText);
        String rawData = urlToText(url);    //Gets text from Google
        if (rawData == null) {
            return null;
        }
        String[] raw = rawData.split("\""); //Parses the JSON
        if (raw.length < 2) {
            return null;
        }
        return raw[1];                      //Returns the translation
    }

    /**
     * Converts a URL to Text
     * @param url that you want to generate a String from
     * @return The generated String
     * @throws IOException if it cannot complete the request
     */
    private static String urlToText(URL url) throws IOException {
        URLConnection urlConn = url.openConnection();   //Open connection
        urlConn.addRequestProperty("User-Agent", "Mozilla/5.0");
        Reader reader = new InputStreamReader(urlConn.getInputStream());//Gets Data Converts to string
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {          //Reads String from buffer
            int ch = reader.read();
            if (ch < 0) {
                break;
            }
            stringBuilder.append((char) ch);
        }
        return stringBuilder.toString();
    }

   

    

    /**
     * Generates the token needed for translation.
     *
     * @param text The text you want to generate the token for.
     * @return The generated token as a string.
     */
    private static String generateToken(String text) {
        int tkk[] = TKK();
        int b = tkk[0];
        int e = 0;
        int f = 0;
        List<Integer> d = new ArrayList<Integer>();
        for (; f < text.length(); f++) {
            int g = text.charAt(f);
            if (0x80 > g) {
                d.add(e++, g);
            } else {
                if (0x800 > g) {
                    d.add(e++, g >> 6 | 0xC0);
                } else {
                    if (0xD800 == (g & 0xFC00) && f + 1 < text.length() && 0xDC00 == (text.charAt(f + 1) & 0xFC00)) {
                        g = 0x10000 + ((g & 0x3FF) << 10) + (text.charAt(++f) & 0x3FF);
                        d.add(e++, g >> 18 | 0xF0);
                        d.add(e++, g >> 12 & 0x3F | 0x80);
                    } else {
                        d.add(e++, g >> 12 | 0xE0);
                        d.add(e++, g >> 6 & 0x3F | 0x80);
                    }
                }
                d.add(e++, g & 63 | 128);
            }
        }

        int a_i = b;
        for (e = 0; e < d.size(); e++) {
            a_i += d.get(e);
            a_i = RL(a_i, "+-a^+6");
        }
        a_i = RL(a_i, "+-3^+b+-f");
        a_i ^= tkk[1];
        long a_l;
        if (0 > a_i) {
            a_l = 0x80000000l + (a_i & 0x7FFFFFFF);
        } else {
            a_l = a_i;
        }
        a_l %= Math.pow(10, 6);
        return String.format(Locale.US, "%d.%d", a_l, a_l ^ b);
    }
    
    //TODO Possibly refactor code as utility class
    /**
     * This function generates the int array for translation acting as the seed
     * for the hashing algorithm.
     */
    private static int[] TKK() {
        return new int[]{0x6337E, 0x217A58DC + 0x5AF91132};
    }

    /**
     * An implementation of an unsigned right shift. Necessary since Java does
     * not have unsigned ints.
     *
     * @param x The number you wish to shift.
     * @param bits The number of bytes you wish to shift.
     * @return The shifted number, unsigned.
     */
    private static int shr32(int x, int bits) {
        if (x < 0) {
            long x_l = 0xffffffffl + x + 1;
            return (int) (x_l >> bits);
        }
        return x >> bits;
    }

    private static int RL(int a, String b) {//I am not entirely sure what this magic does.
        for (int c = 0; c < b.length() - 2; c += 3) {
            int d = b.charAt(c + 2);
            d = d >= 65 ? d - 87 : d - 48;
            d = b.charAt(c + 1) == '+' ? shr32(a, d) : (a << d);
            a = b.charAt(c) == '+' ? (a + (d & 0xFFFFFFFF)) : a ^ d;
        }
        return a;
    }
}
