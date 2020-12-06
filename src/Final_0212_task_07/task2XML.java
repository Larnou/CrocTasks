package Final_0212_task_07;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class task2XML {

    public void ConstructorsForXML(List<DatesRepeats> secondTask) {
        ParamLangXML();
        try {
            WriteParamXML(secondTask);
        } catch (TransformerException | IOException e) {
            e.printStackTrace();
        }
    }

    public void ParamLangXML() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try { builder = factory.newDocumentBuilder(); }
        catch (ParserConfigurationException e) { e.printStackTrace(); }
    }

    DocumentBuilder builder;
    public void WriteParamXML(List<DatesRepeats> secondTask) throws TransformerException, IOException {

        Document doc = builder.newDocument();
        Element RootElement = doc.createElement("sales");

        for (DatesRepeats element : secondTask) {

            Element Date = doc.createElement("date");
            Date.appendChild(doc.createTextNode(element.getDate()));
            RootElement.appendChild(Date);

            Element Repeats = doc.createElement("repeats");
            Repeats.appendChild(doc.createTextNode(String.valueOf(element.getRepeats())));
            RootElement.appendChild(Repeats);

        }
        doc.appendChild(RootElement);

        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.METHOD, "xml");
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        String xmlFilePath = "src\\Final_0212_task_07\\xmls\\secondTask.xml";
        t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(xmlFilePath)));
    }
}
