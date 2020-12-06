package Final_0212_task_07;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class task1XML {

    public void ConstructorsForXML(List<SellerHasItem> firstTask) {
        ParamLangXML();
        try {
            WriteParamXML(firstTask);
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
    public void WriteParamXML(List<SellerHasItem> firstTask) throws TransformerException, IOException {

        Document doc=builder.newDocument();
        Element RootElement=doc.createElement("items");

        for (SellerHasItem element : firstTask) {

            Element ItemName = doc.createElement("itemName");
            ItemName.appendChild(doc.createTextNode(element.getNameOfItem()));
            RootElement.appendChild(ItemName);

            Element SellerName = doc.createElement("sellerName");
            SellerName.appendChild(doc.createTextNode(element.getSellerName()));
            RootElement.appendChild(SellerName);

            Element Amount = doc.createElement("amount");
            Amount.appendChild(doc.createTextNode(String.valueOf(element.getAmountOfItem())));
            RootElement.appendChild(Amount);

        }
        doc.appendChild(RootElement);

        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.METHOD, "xml");
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        String xmlFilePath = "src\\Final_0212_task_07\\xmls\\firstTask.xml";
        t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(xmlFilePath)));
    }

}
