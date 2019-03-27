package uk.ac.glos.ct5057.assignment.s1609415.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import uk.ac.glos.ct5057.assignment.s1609415.items.Item;

import java.io.IOException;

public class ListItemController extends ListCell<Item> {

    @FXML private HBox hBox;

    @FXML private Label nameLabel;
    @FXML private Label sizeLabel;
    @FXML private Label priceLabel;

    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(Item item, boolean empty) {
        super.updateItem(item, empty);

        if(empty || item == null) {

            setText(null);
            setGraphic(null);

        } else {

            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("ListItem.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(item.getName());
            nameLabel.setText( item.getName() );
            sizeLabel.setText( item.getSize() );
            priceLabel.setText( String.valueOf(item.getPrice()) );

            setText(null);
            setGraphic(hBox);
        }
    }
}
