package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;

import java.util.Iterator;
import java.util.List;
import java.sql.Date;

public class Controller {

    private model.AuthorController authorController = new model.AuthorController();
    private ObservableList<Author> authors = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Author, String> bornColumn;
    @FXML
    private TableColumn<Author, String> nameColumn;
    @FXML
    private TableColumn<Author, String> idColumn;
    @FXML
    private TableView<Author> TB1;

    @FXML
    private Button BT1;

    @FXML
    private Button BT2;

    @FXML
    private TextField TXT;

    @FXML
    private void initialize() {
        // Инициализация таблицы адресатов с двумя столбцами.
        bornColumn.setCellValueFactory(cellData -> cellData.getValue().Born());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().Name());
        idColumn.setCellValueFactory(cellData -> cellData.getValue().Id());
    }

    @FXML
    public void OnMouseClicked(MouseEvent mouseEvent) {
        //Выборка авторов из таблицы:
        authors.clear();
        List<model.Author> list = authorController.select();
        Iterator<model.Author> iter = list.iterator();
        while (iter.hasNext()) {
            sample.Author author = new Author(iter.next());
            authors.add(author);
            System.out.println(author.getId());
        }
        TB1.setItems(authors);
        //BT1.setText("YES!");
    }

    public void OnAdd(MouseEvent mouseEvent) {
        authorController.insert(new model.Author(TXT.getText(), new Date(1123)));
        OnMouseClicked(mouseEvent);
        //...
    }
}
