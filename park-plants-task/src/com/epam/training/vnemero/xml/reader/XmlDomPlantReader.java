package com.epam.training.vnemero.xml.reader;

import com.epam.training.vnemero.data.Bush;
import com.epam.training.vnemero.data.Tree;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class XmlDomPlantReader implements PlantReader {

    private Document document;

    public XmlDomPlantReader(String xmlFilePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(xmlFilePath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Tree> readAllTrees() {
        List<Tree> allTrees = new ArrayList<>();

        Element root = document.getDocumentElement();
        NodeList treeList = root.getElementsByTagName("tree-list");
        if (treeList.getLength() == 0) {
            return allTrees;
        }

        Element treeListTag = (Element) treeList.item(0);
        NodeList allTreeNodes = treeListTag.getElementsByTagName("tree");

        for (int i = 0; i < allTreeNodes.getLength(); i++) {
            Element treeTag = (Element) allTreeNodes.item(i);

            String name = treeTag.getElementsByTagName("name").item(0).getTextContent();
            String heightStr = treeTag.getElementsByTagName("height").item(0).getTextContent();
            double height = Double.parseDouble(heightStr);

            Tree tree = new Tree(name, height);
            allTrees.add(tree);
        }

        return allTrees;
    }

    @Override
    public List<Bush> readAllBushes() {
        List<Bush> allBushes = new ArrayList<>();

        Element root = document.getDocumentElement();
        NodeList bushList = root.getElementsByTagName("bush-list");
        if (bushList.getLength() == 0) {
            return allBushes;
        }

        Element bushListTag = (Element) bushList.item(0);
        NodeList allBushNodes = bushListTag.getElementsByTagName("bush");

        for (int i = 0; i < allBushNodes.getLength(); i++) {
            Element bushTag = (Element) allBushNodes.item(i);

            String name = bushTag.getElementsByTagName("name").item(0).getTextContent();
            String heightStr = bushTag.getElementsByTagName("height").item(0).getTextContent();
            double height = Double.parseDouble(heightStr);

            Bush bush = new Bush(name, height);
            allBushes.add(bush);
        }

        return allBushes;
    }
}
