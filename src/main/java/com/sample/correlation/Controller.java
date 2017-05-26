package com.sample.correlation;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.correlation.models.HealthModel;
import com.sample.correlation.models.HealthView;
import com.sample.correlation.utils.CorrelationCalculator;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button simpleButton = new Button();

    @FXML
    private TableView<HealthView> correlationTable = new TableView<>();

    public void initialize(URL location, final ResourceBundle resources) {
        simpleButton.setOnAction(event -> handleButton());
        initializeTableView();

    }

    private void initializeTableView() {
        TableColumn yearColumn = new TableColumn("Year");
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        TableColumn overAllSampleSizeColumn = new TableColumn("OverAllSample");
        overAllSampleSizeColumn.setCellValueFactory(new PropertyValueFactory<>("sampleSize"));
        TableColumn overAllPopulationSizeColumn = new TableColumn("OverAllPopulation");
        overAllPopulationSizeColumn.setCellValueFactory(new PropertyValueFactory<>("populationSize"));
        TableColumn sampleCases = new TableColumn("SampleCases");
        sampleCases.setCellValueFactory(new PropertyValueFactory<>("sampleCases"));
        TableColumn estPopulation = new TableColumn("EstPopulation");
        estPopulation.setCellValueFactory(new PropertyValueFactory<>("estPopulation"));
        TableColumn percentage = new TableColumn("Percentage");
        percentage.setCellValueFactory(new PropertyValueFactory<>("percentange"));
        TableColumn lowerConfidence = new TableColumn("LowerConfidence");
        lowerConfidence.setCellValueFactory(new PropertyValueFactory<>("lower"));
        TableColumn upperConfidence = new TableColumn("UpperConfidence");
        upperConfidence.setCellValueFactory(new PropertyValueFactory<>("upper"));

        correlationTable.getColumns().addAll(yearColumn, overAllSampleSizeColumn, overAllPopulationSizeColumn, sampleCases,
                estPopulation, percentage, lowerConfidence, upperConfidence);
    }


    /**
     * Async call for retrieving the data from API
     * Obtained data is converter into needed format and inserted into TableView
     */
    private void handleButton() {
        simpleButton.setDisable(Boolean.TRUE);

        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(System.getProperty("user.dir") +
                    "/src/main/resources/data.json"));
            ObjectMapper objectMapper = new ObjectMapper();
            List<HealthModel> list = objectMapper.readValue(jsonData, new TypeReference<List<HealthModel>>() {});
            correlationTable.setItems(FXCollections.observableArrayList(CorrelationCalculator.getINSTANCE().
                    with(list).computeCorrelationMatrix()
                    .getOutList()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
