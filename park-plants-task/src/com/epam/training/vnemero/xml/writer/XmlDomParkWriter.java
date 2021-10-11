package com.epam.training.vnemero.xml.writer;

import com.epam.training.vnemero.calculator.ParkCalculator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class XmlDomParkWriter implements ParkWriter {

    private Document writeDocument;

    private ParkCalculator calculator;

    private String xmlFilePath;

    public XmlDomParkWriter(ParkCalculator calculator, String xmlFilePath) {
        this.calculator = calculator;
        this.xmlFilePath = xmlFilePath;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            writeDocument = builder.newDocument();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writePark() {
        Element rootTag = writeDocument.createElement("park");
        writeDocument.appendChild(rootTag);

        Element plantsNumberTag = writeDocument.createElement("all-plants-number");
        rootTag.appendChild(plantsNumberTag);

        int plantsCount = calculator.getPlantCount();
        Text numberData = writeDocument.createTextNode(String.valueOf(plantsCount));
        plantsNumberTag.appendChild(numberData);

        Element resultTag = writeDocument.createElement("general-height");
        rootTag.appendChild(resultTag);

        double commonHeight = calculator.getCommonHeight();
        Text resultData = writeDocument.createTextNode(String.valueOf(commonHeight));
        resultTag.appendChild(resultData);

        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(writeDocument);
            StreamResult streamResult = new StreamResult(xmlFilePath);

            transformer.transform(domSource, streamResult);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
