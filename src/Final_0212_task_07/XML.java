package Final_0212_task_07;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class XML {

    public void ConstructorsForXML(Set<String> secondTask) {
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
    public void WriteParamXML(Set<String> secondTask) throws TransformerException, IOException {

        Document doc=builder.newDocument();
        Element RootElement=doc.createElement("sales");

        for (String elemnet : secondTask) {

            Element NameElementDate=doc.createElement("date");
            NameElementDate.appendChild(doc.createTextNode(elemnet.split("date = ")[1].split(",")[0]));
            RootElement.appendChild(NameElementDate);

            Element NameElementRepeats=doc.createElement("repeats");
            NameElementRepeats.appendChild(doc.createTextNode(elemnet.split("repeats = ")[1]));
            RootElement.appendChild(NameElementRepeats);

        }
        doc.appendChild(RootElement);

        Transformer t=TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.METHOD, "xml");
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        String xmlFilePath = "src\\Final_0212_task_07\\xmls\\secondTask.xml";
        t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(xmlFilePath)));
    }
}
