package com.epam.training.vnemero;

import com.epam.training.vnemero.calculator.ParkCalculator;
import com.epam.training.vnemero.data.Bush;
import com.epam.training.vnemero.data.Tree;
import com.epam.training.vnemero.xml.reader.PlantReader;
import com.epam.training.vnemero.xml.reader.XmlDomPlantReader;
import com.epam.training.vnemero.xml.writer.ParkWriter;
import com.epam.training.vnemero.xml.writer.XmlDomParkWriter;

import java.util.List;

public class ParkPlantsTask {

    private static final String SRC_XML_FILE_PATH = "./xml/park-plants.xml";

    private static final String DEST_XML_FILE_PATH = "./xml/result-document.xml";

    public static void main(String[] args) {
        PlantReader reader = new XmlDomPlantReader(SRC_XML_FILE_PATH);

        List<Tree> trees = reader.readAllTrees();
        List<Bush> bushes = reader.readAllBushes();

        ParkCalculator calculator = new ParkCalculator();
        calculator.addPlants(trees);
        calculator.addPlants(bushes);

        ParkWriter parkWriter = new XmlDomParkWriter(calculator, DEST_XML_FILE_PATH);
        parkWriter.writePark();
    }
}
