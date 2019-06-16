package IO;

import java.io.IOException;
import java.io.Reader;

public class MylineNumberReader extends MybufferedReader {
    private  int lineNumber = 0;
    public MylineNumberReader(Reader rd) {
        super(rd);
    }
    public int getLineNumber() {
        return lineNumber;
    }
    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }
    public String myReadLine() throws IOException {
        lineNumber++;
        return  super.myReadLine();
    }
}
