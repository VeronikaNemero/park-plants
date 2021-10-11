package com.epam.training.vnemero.xml.reader;

import com.epam.training.vnemero.data.Bush;
import com.epam.training.vnemero.data.Tree;

import java.util.List;

public interface PlantReader {

    List<Tree> readAllTrees();

    List<Bush> readAllBushes();
}
