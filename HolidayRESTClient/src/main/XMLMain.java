package main;

import generated.NewDataSet;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.List;

/**
 * Created by kpant on 6/16/17.
 */
public class XMLMain {
    public static final String XML_FILE_NAME = "GetHolidaysForYear.xml";

    public static void main(String[] args) {
        JAXBContext jc = null;
        try {
            jc = JAXBContext.newInstance("generated");
            Unmarshaller u = jc.createUnmarshaller();

            //Build a DOM
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(XML_FILE_NAME));

            //Traverse the data until newDataSet is generated
            Element subtree = doc.getDocumentElement();
            Node node = subtree.getElementsByTagName("NewDataSet").item(0);

            //UnMarshal newDataSet
            JAXBElement<NewDataSet> dataSet = u.unmarshal(node, NewDataSet.class);

            //Print the holidays
            List<NewDataSet.Holidays> holidays = dataSet.getValue().getHolidays();
            for (NewDataSet.Holidays h : holidays) {
                System.out.printf("%30s: %d%d%d\n", h.getName(), h.getDate().getMonth(), h.getDate().getDay(), h.getDate().getYear());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
