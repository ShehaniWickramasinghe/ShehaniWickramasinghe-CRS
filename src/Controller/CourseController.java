package controller;



import dto.Coursedto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.table.DefaultTableModel;
import service.custom.CourseService;
import service.custom.impl.CourseServiceImpl;

public class CourseController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnGoBack;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<Coursedto, String> colCourseId;

    @FXML
    private TableColumn<Coursedto, String> colCourseName;

    @FXML
    private TableColumn<Coursedto, String> colCreditHours;

    @FXML
    private TableColumn<Coursedto,String> colDepartment;

    @FXML
    private TableColumn<Coursedto, Integer> colMEC;

    @FXML
    private TableColumn<Coursedto, String> colprerequisites;

    @FXML
    private ComboBox<String> comboBox1;

    @FXML
    private Label lblCourseId;

    @FXML
    private Label lblCourseName;

    @FXML
    private Label lblCreditHours;

    @FXML
    private Label lblDepartment;

    @FXML
    private Label lblMEC;

    @FXML
    private Label lblprerequisites;

    @FXML
    private TableView<Coursedto> tblCourse;

    @FXML
    private TextField txtCourseId;

    @FXML
    private TextField txtCourseName;

    @FXML
    private TextField txtCreditHours;

    @FXML
    private TextField txtMEC;

    @FXML
    private TextField txtprerequisites;
    
    public void getAllCourse() throws Exception{
        CourseService courseService=new CourseServiceImpl();
        ArrayList<Coursedto> getAll=courseService.getAll();
        System.out.println(getAll);
        ObservableList<Coursedto> observableList=FXCollections.observableArrayList();
        observableList.addAll(getAll);
        tblCourse.setItems(observableList);
    }
    public void initialize() throws Exception{
        System.out.println("first method");
        getAllCourse();
        colCourseId.setCellValueFactory(new PropertyValueFactory<>("CourseId"));
        colCourseName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCreditHours.setCellValueFactory(new PropertyValueFactory<>("CreditHour"));
        colprerequisites.setCellValueFactory(new PropertyValueFactory<>("prerequisites"));
        colDepartment.setCellValueFactory(new PropertyValueFactory<>("Department"));
        colMEC.setCellValueFactory(new PropertyValueFactory<>("maximumCapacity"));

        List<String> arrayList=Arrays.asList("Computer Science","Chemistry","Applied Maths","Pure Maths","Physics",
        "Nuclear Science ");
        ObservableList<String> comboBoList=FXCollections.observableArrayList(arrayList);
        comboBox1.setItems(comboBoList);
        comboBox1.setValue("Chemistry");

        tblCourse.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->{
            System.out.println("Table row click");
            System.out.println("oldSelection:"+oldSelection);
            System.out.println("=====================");
            System.out.println("newSelection:"+newSelection);
            if (newSelection!=null) {
                txtCourseId.setText(newSelection.getCourseId());
                txtCourseName.setText(newSelection.getName());
                txtCreditHours.setText(newSelection.getCreditHour());
                txtprerequisites.setText(newSelection.getPrerequisites());
                txtMEC.setText(Integer.toString(newSelection.getMaximumCapacity()));
                comboBox1.setValue(newSelection.getDepartment().toString());
            }
        });
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws Exception {
            CourseService courseService=new CourseServiceImpl();
            String delete = courseService.delete(txtCourseId.getText());
    }

    @FXML
    void btnGoBackOnAction(ActionEvent event) throws IOException {
        System.out.println("Go Back");
            Stage stage=(Stage)btnGoBack.getScene().getWindow();
            FXMLLoader load= new FXMLLoader(getClass().getResource("../view/login.fxml"));
            Parent root=load.load();
    
            Stage stage1=new Stage();
            stage1.setScene(new Scene(root));
            stage1.show();
            stage.close();

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws Exception {
            String courseId = txtCourseId.getText();
            String courseName = txtCourseName.getText();
            String creditHour = txtCreditHours.getText();
            String prerequisites = txtprerequisites.getText();
            int mec = Integer.parseInt(txtMEC.getText());
            String department =(String) comboBox1.getValue();
            ObservableList<String> comboBoList=FXCollections.observableArrayList();
            if (department!=null) {
                comboBoList.add(department);
            }
            Coursedto coursedto=new Coursedto(courseId, courseName, creditHour, prerequisites, mec, comboBoList);
            CourseService courseService=new CourseServiceImpl();
            String save = courseService.save(coursedto);
            
            clearForm();
          
        }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws Exception {
            String id = txtCourseId.getText();
            String name = txtCourseName.getText();
            String creditHour = txtCreditHours.getText();
            String prerequisites = txtprerequisites.getText();
            int mec = Integer.parseInt(txtMEC.getText());
            String department=(String) comboBox1.getValue();
            ObservableList<String> comboBoxList=FXCollections.observableArrayList();
            if (department!=null) {
                comboBoxList.add(department);
            }
            Coursedto coursedto=new Coursedto(id, name, creditHour, prerequisites, mec, comboBoxList);
            CourseService courseService=new CourseServiceImpl();
            String update = courseService.update(coursedto);

            clearForm();
    }

    public void clearForm(){
            txtCourseId.setText("");
            txtCourseName.setText("");
            txtCreditHours.setText("");
            txtprerequisites.setText("");
            txtMEC.setText(null);
            comboBox1.setValue("");
    }

    @SuppressWarnings("unused")
    private void alert(Alert.AlertType alertType,String header,String context){
        Alert alert=new Alert(alertType);
        alert.setHeaderText(header);
        alert.setContentText(context);
        alert.showAndWait();
    }

    @SuppressWarnings("unchecked")
    public void loadTable(){
        try {
            tblCourse.getColumns().clear();
            tblCourse.getColumns().addAll(colCourseId,colCourseName,colCreditHours,colprerequisites,colMEC,colDepartment);
            CourseService courseService=new CourseServiceImpl();
            ObservableList<Coursedto> courseList=FXCollections.observableArrayList(courseService.getAll());
            tblCourse.setItems(courseList);
            String columns[]={"CourseId","Course Name","Credit Hours","Prerequisites","MEC","Department"};
            DefaultTableModel dtm=new DefaultTableModel(columns,0){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
                
            };
            tblCourse.getItems();

            ArrayList<Coursedto> coursedtos=courseService.getAll();
            for (Coursedto coursedto : coursedtos) {
                Object rowData[]={coursedto.getCourseId(),
                coursedto.getName(),coursedto.getCreditHour(),coursedto.getPrerequisites(),
            coursedto.getMaximumCapacity(),coursedto.getDepartment()};
            dtm.addRow(rowData);
            System.out.println(coursedtos);
            System.out.println("successfully loaded");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
