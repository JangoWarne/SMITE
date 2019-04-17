package uk.ac.glos.ct5057.assignment.s1609415.ui;

import uk.ac.glos.ct5057.assignment.s1609415.items.Item;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;


/**
 * This class is the controller for ListItem.fxml
 * it sets the handles for UI events/actions
 *
 * @author  Joshua Walker
 * @version 1.0
 */
public class ListItemController extends ListCell<Item> {

    @FXML private HBox hBox;

    @FXML private Label nameLabel;
    @FXML private Label sizeLabel;
    @FXML private Label priceLabel;
    @FXML private Button moveButton;

    private FXMLLoader mLLoader;
    private Item item;
    private ScreenController window;
    private boolean clickable;
    private boolean isBasket;

    public ListItemController(ScreenController window, boolean clickable, boolean isBasket) {
        this.window = window;
        this.clickable = clickable;
        this.isBasket = isBasket;
    }

    @Override protected void updateItem(Item item, boolean empty) {
        super.updateItem(item, empty);

        // if the list entry changes
        if(empty || item == null) {

            // clear row
            setText(null);
            setGraphic(null);

        } else {

            // initialise and draw if it does not exits
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("ListItem.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // Handler for click on button
                moveButton.setOnMouseClicked( this::moveButtonHandle );
            }

            // update text
            nameLabel.setText( item.getName() );
            sizeLabel.setText( String.valueOf(item.getSize()) );
            priceLabel.setText( String.valueOf(item.getPrice()) );

            // update button
            if( isBasket ) {
                moveButton.setText( "-" );
            } else {
                moveButton.setText( "+" );
            }
            moveButton.setVisible( clickable );

            this.item = item;

            // draw
            setText(null);
            setGraphic(hBox);
        }
    }

    private void moveButtonHandle(MouseEvent event) {
        // add/remove from basket
        if( isBasket ) {
            window.removeBasketItem( item );
        } else {
            window.addBasketItem( item );
        }
    }
}
