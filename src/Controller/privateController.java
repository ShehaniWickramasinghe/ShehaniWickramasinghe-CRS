package  controller;

import dto.Coursedto;
import dto.Privatedto;
import dto.Reportdto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import javafx.collections.FXCollections;
import javafx.scene.control.TableView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.custom.PrivateService;
import service.custom.ReportService;
import service.custom.impl.PrivateServiceImpl;
import service.custom.impl.ReportServiceImpl;

public class privateController {
     @FXML
    private Button btnSave;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnBack;

    @FXML
    private TableColumn<Privatedto, String> colAttendance;

    @FXML
    private TableColumn<Privatedto, String> colDepartment;

    @FXML
    private TableColumn<Privatedto, String> colId;

    @FXML
    private TableColumn<Privatedto, String> colName;

    @FXML
    private TableColumn<Privatedto, String> colSem1;

    @FXML
    private TableColumn<Privatedto, String> colSem2;

    @FXML
    private Label lblAttendance;

    @FXML
    private Label lblDepartment;

    @FXML
    private Label lblGrade2;

    @FXML
    private Label lblName;

    @FXML
    private Label lblSem1;

    @FXML
    private Label lblStudentId;

    @FXML
    private TableView<Privatedto> tblAcademic;

    @FXML
    private TextField txtAttendance;

    @FXML
    private TextField txtDepartment;

    @FXML
    private TextField txtGrade1;

    @FXML
    private TextField txtGrade2;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtStudentId;

    private final ReportService reportService = new ReportServiceImpl();

    public void initialize() throws Exception{
        getAllDetails();

        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colDepartment.setCellValueFactory(new PropertyValueFactory<>("Department"));
        colAttendance.setCellValueFactory(new PropertyValueFactory<>("Attendance"));
        colSem1.setCellValueFactory(new PropertyValueFactory<>("Sem1Grade"));
        colSem2.setCellValueFactory(new PropertyValueFactory<>("Sem2Grade"));
       
        tblAcademic.refresh();
        tblAcademic.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->{
            System.out.println("Table row click");
            System.out.println("oldSelection:"+oldSelection);
            System.out.println("=====================");
            System.out.println("newSelection:"+newSelection);
            if (newSelection!=null) {
                txtStudentId.setText(newSelection.getId());
                txtName.setText(newSelection.getName());
                txtDepartment.setText(newSelection.getDepartment());
                txtAttendance.setText(newSelection.getAttendance());
                txtGrade1.setText(newSelection.getSem1Grade());
                txtGrade2.setText(newSelection.getSem2Grade());
            }
        });
        
    }

    public void getAllDetails() throws Exception{
        PrivateService privateService=new PrivateServiceImpl();
        ArrayList<Privatedto> getAll=privateService.getAll();
        System.out.println(getAll);
        ObservableList<Privatedto> observableList=FXCollections.observableArrayList();
        observableList.addAll(getAll);
        tblAcademic.setItems(observableList);

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws Exception {
            String Id = txtStudentId.getText();
            String Name = txtName.getText();
            String Department = txtDepartment.getText();
            String Attendance = txtAttendance.getText();
            String sem1 = txtGrade1.getText();
            String sem2 = txtGrade2.getText();

            Privatedto privatedto=new Privatedto(Id, Name, Department, Attendance, sem1, sem2);
            PrivateService privateService=new PrivateServiceImpl();
            String save = privateService.save(privatedto);
            clearForm();
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) throws Exception {
                    String Id = txtStudentId.getText();
                   PrivateService privateService=new PrivateServiceImpl();
                   Privatedto privatedto = privateService.search(Id);
                    if (privatedto!=null) {
                        txtStudentId.setText(privatedto.getId());
                        txtName.setText(privatedto.getName());
                        txtDepartment.setText(privatedto.getDepartment());
                        txtAttendance.setText(privatedto.getAttendance());
                        txtGrade1.setText(privatedto.getSem1Grade());
                        txtGrade2.setText(privatedto.getSem2Grade());
                    }else{
                        Alert alert=new Alert(Alert.AlertType.INFORMATION,"Student Not Found",ButtonType.OK);
                    }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws Exception {
        String Id = txtStudentId.getText().trim();
        String Name = txtName.getText().trim();
        String Department = txtDepartment.getText().trim();
        String Attendance = txtAttendance.getText().trim();
        String sem1 = txtGrade1.getText().trim();
        String sem2 = txtGrade2.getText().trim();

        

            Privatedto privatedto=new Privatedto(Id, Name, Department, Attendance, sem1, sem2);
            List<Reportdto> reportList = fetchReportData(Id);
            for (Reportdto reportdto : reportList) {
                System.out.println("Updated Report Data: " + reportdto);
            }
            
            for (Reportdto reportdto : reportList) {
                reportdto.setStudentName(Name); 
                String reportUpdateStatus = reportService.update(reportdto);
            
                }
            PrivateService privateService=new PrivateServiceImpl();
            String update = privateService.update(privatedto, reportList);
            System.out.println(update);
            loadTable();
            clearForm();
    }
            private List<Reportdto> fetchReportData(String studentId) throws Exception {
                ReportService reportService=new ReportServiceImpl();
                return reportService.search(studentId);
    }

    public void clearForm(){
        txtStudentId.setText("");
        txtName.setText("");
        txtDepartment.setText("");
        txtAttendance.setText("");
        txtGrade1.setText("");
        txtGrade2.setText("");
    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
            Stage stage=(Stage)btnBack.getScene().getWindow();
            FXMLLoader loader=new FXMLLoader(getClass().getResource("../view/admin.fxml"));
            Parent root=loader.load();

            Stage stage1=new Stage();
            stage1.setScene(new Scene(root));
            stage1.show();
            stage.close();
    }
    
    @SuppressWarnings("unchecked")
    public void loadTable(){
        try {
            tblAcademic.getColumns().clear();
            tblAcademic.getColumns().addAll(colId,colName,colDepartment,colAttendance,colSem1,colSem2);
            PrivateService privateService=new PrivateServiceImpl();
            ObservableList<Privatedto> privatedtos=FXCollections.observableArrayList(privateService.getAll());
            tblAcademic.setItems(privatedtos);
             String columns[]={"Id","Name","Department","Attendance","Sem1","Sem2"};
            DefaultTableModel dtm=new DefaultTableModel(columns,0){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
                
            };
                tblAcademic.getItems();

                ArrayList<Privatedto> privatedtos1=privateService.getAll();
                for (Privatedto privatedto : privatedtos1) {
                    Object rowData[]={privatedto.getId(),privatedto.getName(),privatedto.getDepartment(),privatedto.getAttendance(),
                    privatedto.getSem1Grade(),privatedto.getSem2Grade()};
                    dtm.addRow(rowData);
                    System.out.println(privatedtos1);
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
