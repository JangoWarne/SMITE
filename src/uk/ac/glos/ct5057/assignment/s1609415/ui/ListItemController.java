package uk.ac.glos.ct5057.assignment.s1609415.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import uk.ac.glos.ct5057.assignment.s1609415.items.Item;

import java.io.IOException;

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

    public ListItemController(ScreenController window, boolean clickable) {
        this.window = window;
        this.clickable = clickable;
    }

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

                // Handler for click on button
                moveButton.setOnMouseClicked( this::moveButtonHandle );
            }

            nameLabel.setText( item.getName() );
            sizeLabel.setText( item.getSize() );
            priceLabel.setText( String.valueOf(item.getPrice()) );

            if( item.isInBasket() ) {
                moveButton.setText( "-" );
            } else {
                moveButton.setText( "+" );
            }
            moveButton.setVisible( clickable );

            this.item = item;

            setText(null);
            setGraphic(hBox);
        }
    }

    private void moveButtonHandle(MouseEvent event) {

        boolean inBasket = moveButton.getText().equals("+");

        item.setInBasket( inBasket );

        if( inBasket ) {
            window.addBasketItem( item );
            window.removeListItem( item );
        } else {
            window.addListItem( item );
            window.removeBasketItem( item );
        }
    }
}
