package io;

import java.io.IOException;
import java.io.Reader;

public class MybufferedReader {
    private char[] tempBuffered = new char[1024];
    private int index = 0;
    private int count = 0;
    private Reader rd;

    public MybufferedReader(Reader rd) {
        super();
        this.rd = rd;
    }

    public int myRead() throws IOException {
        if (count == 0) {
            count = rd.read(tempBuffered);
            index = 0;
        }
        if (count < 0) {
            return -1;
        }
        char chars = tempBuffered[index];
        index++;
        count--;
        return chars;
    }

    public String myReadLine() throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        int ch = 0;
        while ((ch = myRead()) != -1) {
            if (ch == '\r')
                continue;
            if (ch == '\n')
                return stringBuffer.toString();
            stringBuffer.append((char) ch);
        }
        if (stringBuffer.length() != 0) {
            return stringBuffer.toString();
        }
        return null;
    }

    public void myClose() throws IOException {
        rd.close();
    }
}
