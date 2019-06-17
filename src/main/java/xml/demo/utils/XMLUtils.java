package xml.demo.utils;

import org.w3c.dom.Document;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;

public class XMLUtils {
    //private static String filename = "\\src\\main\\java\\xml\\exam.xml";

    /**
     * @param filename
     * @return
     * @throws Exception
     */
    public static Document getDocument(String filename) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(filename);
    }

    /**
     * @param document
     * @param filename
     * @throws Exception
     */
    public static void write2XML(Document document, String filename) throws Exception {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer tf = factory.newTransformer();
        tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream(filename)));
    }
}
