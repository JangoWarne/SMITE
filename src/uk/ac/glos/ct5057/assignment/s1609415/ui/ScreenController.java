package uk.ac.glos.ct5057.assignment.s1609415.ui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import uk.ac.glos.ct5057.assignment.s1609415.algorithms.RadixSort;
import uk.ac.glos.ct5057.assignment.s1609415.file.FileRead;
import uk.ac.glos.ct5057.assignment.s1609415.items.Item;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;


/**
 * This class is the controller for Screen.fxml
 * it sets the handles for UI events/actions
 *
 * @author  Joshua Walker
 * @version 1.0
 */
public class ScreenController implements Initializable {

    @FXML private AnchorPane mainAnchorPane;

    @FXML private ImageView businessA_ImageView;
    @FXML private ImageView businessF_ImageView;
    @FXML private ImageView businessJ_ImageView;
    @FXML private ImageView businessL_ImageView;
    @FXML private ImageView businessN_ImageView;
    @FXML private ImageView businessO_ImageView;
    @FXML private ImageView businessT_ImageView;
    @FXML private ImageView businessV_ImageView;
    @FXML private ImageView businessW_ImageView;
    @FXML private ImageView business2_ImageView;
    @FXML private ImageView business4_ImageView;

    @FXML private Circle businessA_Circle;
    @FXML private Circle businessF_Circle;
    @FXML private Circle businessJ_Circle;
    @FXML private Circle businessL_Circle;
    @FXML private Circle businessN_Circle;
    @FXML private Circle businessO_Circle;
    @FXML private Circle businessT_Circle;
    @FXML private Circle businessV_Circle;
    @FXML private Circle businessW_Circle;
    @FXML private Circle business2_Circle;
    @FXML private Circle business4_Circle;

    @FXML private ListView<Item> itemsListView;
    @FXML private ListView<Item> basketListView;
    @FXML private ListView<Item> eastListView;
    @FXML private ListView<Item> westListView;

    @FXML private Polygon nameAscPolygon;
    @FXML private Polygon nameDescPolygon;
    @FXML private Polygon sizeAscPolygon;
    @FXML private Polygon sizeDescPolygon;
    @FXML private Polygon priceAscPolygon;
    @FXML private Polygon priceDescPolygon;

    @FXML private Rectangle nameRectangle;
    @FXML private Rectangle sizeRectangle;
    @FXML private Rectangle priceRectangle;

    @FXML private Region sendDeliveryRegion;
    @FXML private Region nameRegion;
    @FXML private Region sizeRegion;
    @FXML private Region priceRegion;

    @FXML private TextField searchTextField;

    @FXML private Pane west_AE_Pane;
    @FXML private Pane east_AE_Pane;
    @FXML private Pane west_AB_Pane;
    @FXML private Pane east_AB_Pane;
    @FXML private Pane west_FO_Pane;
    @FXML private Pane east_FO_Pane;
    @FXML private Pane west_DE_Pane;
    @FXML private Pane west_DJ_Pane;
    @FXML private Pane west_GL_Pane;
    @FXML private Pane west_KN_Pane;
    @FXML private Pane west_MO_Pane;
    @FXML private Pane west_LT_Pane;
    @FXML private Pane west_PU_Pane;
    @FXML private Pane west_SV_Pane;
    @FXML private Pane west_X3_Pane;
    @FXML private Pane west_Z4_Pane;
    @FXML private Pane west_67_Pane;
    @FXML private Pane west_TV_Pane;
    @FXML private Pane west_EI_Pane;
    @FXML private Pane east_EI_Pane;
    @FXML private Pane west_BF_Pane;
    @FXML private Pane east_BF_Pane;
    @FXML private Pane west_OP_Pane;
    @FXML private Pane east_OP_Pane;
    @FXML private Pane west_IN_Pane;
    @FXML private Pane east_IN_Pane;
    @FXML private Pane east_PU_Pane;
    @FXML private Pane east_UX_Pane;
    @FXML private Pane west_UX_Pane;
    @FXML private Pane west_78_Pane;
    @FXML private Pane west_W8_Pane;
    @FXML private Pane west_RW_Pane;
    @FXML private Pane west_NP_Pane;
    @FXML private Pane west_NQ_Pane;
    @FXML private Pane west_QR_Pane;
    @FXML private Pane west_Q1_Pane;
    @FXML private Pane west_W1_Pane;
    @FXML private Pane west_12_Pane;
    @FXML private Pane west_27_Pane;
    @FXML private Pane west_46_Pane;
    @FXML private Pane west_34_Pane;
    @FXML private Pane west_56_Pane;
    @FXML private Pane west_XY_Pane;
    @FXML private Pane west_Y3_Pane;
    @FXML private Pane west_VY_Pane;
    @FXML private Pane west_TZ_Pane;
    @FXML private Pane west_Z1_Pane;
    @FXML private Pane west_25_Pane;
    @FXML private Pane west_Z5_Pane;
    @FXML private Pane west_QT_Pane;
    @FXML private Pane west_PS_Pane;
    @FXML private Pane west_SU_Pane;
    @FXML private Pane west_LM_Pane;
    @FXML private Pane west_JK_Pane;
    @FXML private Pane west_IJ_Pane;
    @FXML private Pane west_KL_Pane;
    @FXML private Pane west_AC_Pane;
    @FXML private Pane west_CD_Pane;
    @FXML private Pane west_CG_Pane;
    @FXML private Pane west_BG_Pane;
    @FXML private Pane west_GH_Pane;
    @FXML private Pane west_FH_Pane;
    @FXML private Pane west_HM_Pane;
    @FXML private Pane east_HM_Pane;
    @FXML private Pane east_EH_Pane;
    @FXML private Pane east_GH_Pane;
    @FXML private Pane east_BG_Pane;
    @FXML private Pane east_CG_Pane;
    @FXML private Pane east_CD_Pane;
    @FXML private Pane east_AC_Pane;
    @FXML private Pane east_KL_Pane;
    @FXML private Pane east_IJ_Pane;
    @FXML private Pane east_JK_Pane;
    @FXML private Pane east_LM_Pane;
    @FXML private Pane east_SU_Pane;
    @FXML private Pane east_PS_Pane;
    @FXML private Pane east_QT_Pane;
    @FXML private Pane east_Z5_Pane;
    @FXML private Pane east_25_Pane;
    @FXML private Pane east_Z1_Pane;
    @FXML private Pane east_TZ_Pane;
    @FXML private Pane east_VY_Pane;
    @FXML private Pane east_Y3_Pane;
    @FXML private Pane east_XY_Pane;
    @FXML private Pane east_56_Pane;
    @FXML private Pane east_34_Pane;
    @FXML private Pane east_46_Pane;
    @FXML private Pane east_27_Pane;
    @FXML private Pane east_12_Pane;
    @FXML private Pane east_W1_Pane;
    @FXML private Pane east_Q1_Pane;
    @FXML private Pane east_QR_Pane;
    @FXML private Pane east_NQ_Pane;
    @FXML private Pane east_NR_Pane;
    @FXML private Pane east_RW_Pane;
    @FXML private Pane east_W8_Pane;
    @FXML private Pane east_78_Pane;
    @FXML private Pane east_TV_Pane;
    @FXML private Pane east_67_Pane;
    @FXML private Pane east_Z4_Pane;
    @FXML private Pane east_X3_Pane;
    @FXML private Pane east_SV_Pane;
    @FXML private Pane east_LT_Pane;
    @FXML private Pane east_MO_Pane;
    @FXML private Pane east_KN_Pane;
    @FXML private Pane east_GL_Pane;
    @FXML private Pane east_DJ_Pane;
    @FXML private Pane east_DE_Pane;

    private HashMap<String, Pane> routes;
    private ObservableList<Item> itemObservableList;
    private ObservableList<Item> basketObservableList;
    private ObservableList<Item> eastObservableList;
    private ObservableList<Item> westObservableList;
    private ArrayList<Item> allItems;
    private ArrayList<Item> searchableItems;
    private ArrayList<Item> foundItems;

    @FXML public void initialize(URL location, ResourceBundle resources) {

        // Handlers for clicks on businesses
        businessA_ImageView.setOnMouseClicked( this::businessAHandle );
        businessF_ImageView.setOnMouseClicked( this::businessFHandle );
        businessJ_ImageView.setOnMouseClicked( this::businessJHandle );
        businessL_ImageView.setOnMouseClicked( this::businessLHandle );
        businessN_ImageView.setOnMouseClicked( this::businessNHandle );
        businessO_ImageView.setOnMouseClicked( this::businessOHandle );
        businessT_ImageView.setOnMouseClicked( this::businessTHandle );
        businessV_ImageView.setOnMouseClicked( this::businessVHandle );
        businessW_ImageView.setOnMouseClicked( this::businessWHandle );
        business2_ImageView.setOnMouseClicked( this::business2Handle );
        business4_ImageView.setOnMouseClicked( this::business4Handle );

        // Handlers for clicks on regions
        nameRegion.setOnMouseClicked( this::nameRegionHandle );
        sizeRegion.setOnMouseClicked( this::sizeRegionHandle );
        priceRegion.setOnMouseClicked( this::priceRegionHandle );
        sendDeliveryRegion.setOnMouseClicked( this::sendDeliveryHandle );

        // Handler for text input
        searchTextField.textProperty().addListener( (observable, oldText, newText) -> itemSearch(newText) );

        // Create map of routes
        mapRoutes();

        // Define itemListView
        itemsListView.setItems(itemObservableList);
        itemsListView.setCellFactory( listView -> new ListItemController(this, true, false) );
        itemsListView.setEditable(true);

        // Define basketListView
        basketListView.setItems(basketObservableList);
        basketListView.setCellFactory( listView -> new ListItemController(this, true, true) );
        basketListView.setEditable(true);

        // Define eastListView
        eastListView.setItems(eastObservableList);
        eastListView.setCellFactory( listView -> new ListItemController(this, false, true) );
        eastListView.setEditable(true);

        // Define westListView
        westListView.setItems(westObservableList);
        westListView.setCellFactory( listView -> new ListItemController(this, false, true) );
        westListView.setEditable(true);

        resetUI();
    }

    @FXML private void mainAnchorPaneClick() {
        // Deselect focus
        mainAnchorPane.requestFocus();
    }

    public ScreenController() {
        //
        itemObservableList = FXCollections.observableArrayList();
        basketObservableList = FXCollections.observableArrayList();
        eastObservableList = FXCollections.observableArrayList();
        westObservableList = FXCollections.observableArrayList();

        FileRead itemPath = new FileRead("src/uk/ac/glos/ct5057/assignment/s1609415/file/items.txt");
        allItems = itemPath.parseFile();
        searchableItems = allItems;
        foundItems = allItems;
    }



    // Business UI event handlers

    private void clearBusinesses(){
        // clear user selection
        businessA_Circle.setVisible(false);
        businessF_Circle.setVisible(false);
        businessJ_Circle.setVisible(false);
        businessL_Circle.setVisible(false);
        businessN_Circle.setVisible(false);
        businessO_Circle.setVisible(false);
        businessT_Circle.setVisible(false);
        businessV_Circle.setVisible(false);
        businessW_Circle.setVisible(false);
        business2_Circle.setVisible(false);
        business4_Circle.setVisible(false);
    }

    private void businessAHandle(MouseEvent event) {
        // Select Business
        clearBusinesses();
        businessA_Circle.setVisible(true);
    }

    private void businessFHandle(MouseEvent event) {
        // Select Business
        clearBusinesses();
        businessF_Circle.setVisible(true);
    }

    private void businessJHandle(MouseEvent event) {
        // Select Business
        clearBusinesses();
        businessJ_Circle.setVisible(true);
    }

    private void businessLHandle(MouseEvent event) {
        // Select Business
        clearBusinesses();
        businessL_Circle.setVisible(true);
    }

    private void businessNHandle(MouseEvent event) {
        // Select Business
        clearBusinesses();
        businessN_Circle.setVisible(true);
    }

    private void businessOHandle(MouseEvent event) {
        // Select Business
        clearBusinesses();
        businessO_Circle.setVisible(true);
    }

    private void businessTHandle(MouseEvent event) {
        // Select Business
        clearBusinesses();
        businessT_Circle.setVisible(true);
    }

    private void businessVHandle(MouseEvent event) {
        // Select Business
        clearBusinesses();
        businessV_Circle.setVisible(true);
    }

    private void businessWHandle(MouseEvent event) {
        // Select Business
        clearBusinesses();
        businessW_Circle.setVisible(true);
    }

    private void business2Handle(MouseEvent event) {
        // Select Business
        clearBusinesses();
        business2_Circle.setVisible(true);
    }

    private void business4Handle(MouseEvent event) {
        // Select Business
        clearBusinesses();
        business4_Circle.setVisible(true);
    }



    private void mapRoutes(){
        // Create map of routes
        routes = new HashMap<>();
        routes.put("west_AE", west_AE_Pane);
        routes.put("east_AE", east_AE_Pane);
        routes.put("west_AB", west_AB_Pane);
        routes.put("east_AB", east_AB_Pane);
        routes.put("west_FO", west_FO_Pane);
        routes.put("east_FO", east_FO_Pane);
        routes.put("west_DE", west_DE_Pane);
        routes.put("west_DJ", west_DJ_Pane);
        routes.put("west_GL", west_GL_Pane);
        routes.put("west_KN", west_KN_Pane);
        routes.put("west_MO", west_MO_Pane);
        routes.put("west_LT", west_LT_Pane);
        routes.put("west_PU", west_PU_Pane);
        routes.put("west_SV", west_SV_Pane);
        routes.put("west_X3", west_X3_Pane);
        routes.put("west_Z4", west_Z4_Pane);
        routes.put("west_67", west_67_Pane);
        routes.put("west_TV", west_TV_Pane);
        routes.put("west_EI", west_EI_Pane);
        routes.put("east_EI", east_EI_Pane);
        routes.put("west_BF", west_BF_Pane);
        routes.put("east_BF", east_BF_Pane);
        routes.put("west_OP", west_OP_Pane);
        routes.put("east_OP", east_OP_Pane);
        routes.put("west_IN", west_IN_Pane);
        routes.put("east_IN", east_IN_Pane);
        routes.put("east_PU", east_PU_Pane);
        routes.put("east_UX", east_UX_Pane);
        routes.put("west_UX", west_UX_Pane);
        routes.put("west_78", west_78_Pane);
        routes.put("west_W8", west_W8_Pane);
        routes.put("west_RW", west_RW_Pane);
        routes.put("west_NP", west_NP_Pane);
        routes.put("west_NQ", west_NQ_Pane);
        routes.put("west_QR", west_QR_Pane);
        routes.put("west_Q1", west_Q1_Pane);
        routes.put("west_W1", west_W1_Pane);
        routes.put("west_12", west_12_Pane);
        routes.put("west_27", west_27_Pane);
        routes.put("west_46", west_46_Pane);
        routes.put("west_34", west_34_Pane);
        routes.put("west_56", west_56_Pane);
        routes.put("west_XY", west_XY_Pane);
        routes.put("west_Y3", west_Y3_Pane);
        routes.put("west_VY", west_VY_Pane);
        routes.put("west_TZ", west_TZ_Pane);
        routes.put("west_Z1", west_Z1_Pane);
        routes.put("west_25", west_25_Pane);
        routes.put("west_Z5", west_Z5_Pane);
        routes.put("west_QT", west_QT_Pane);
        routes.put("west_PS", west_PS_Pane);
        routes.put("west_SU", west_SU_Pane);
        routes.put("west_LM", west_LM_Pane);
        routes.put("west_JK", west_JK_Pane);
        routes.put("west_IJ", west_IJ_Pane);
        routes.put("west_KL", west_KL_Pane);
        routes.put("west_AC", west_AC_Pane);
        routes.put("west_CD", west_CD_Pane);
        routes.put("west_CG", west_CG_Pane);
        routes.put("west_BG", west_BG_Pane);
        routes.put("west_GH", west_GH_Pane);
        routes.put("west_FH", west_FH_Pane);
        routes.put("west_HM", west_HM_Pane);
        routes.put("east_HM", east_HM_Pane);
        routes.put("east_EH", east_EH_Pane);
        routes.put("east_GH", east_GH_Pane);
        routes.put("east_BG", east_BG_Pane);
        routes.put("east_CG", east_CG_Pane);
        routes.put("east_CD", east_CD_Pane);
        routes.put("east_AC", east_AC_Pane);
        routes.put("east_KL", east_KL_Pane);
        routes.put("east_IJ", east_IJ_Pane);
        routes.put("east_JK", east_JK_Pane);
        routes.put("east_LM", east_LM_Pane);
        routes.put("east_SU", east_SU_Pane);
        routes.put("east_PS", east_PS_Pane);
        routes.put("east_QT", east_QT_Pane);
        routes.put("east_Z5", east_Z5_Pane);
        routes.put("east_25", east_25_Pane);
        routes.put("east_Z1", east_Z1_Pane);
        routes.put("east_TZ", east_TZ_Pane);
        routes.put("east_VY", east_VY_Pane);
        routes.put("east_Y3", east_Y3_Pane);
        routes.put("east_XY", east_XY_Pane);
        routes.put("east_56", east_56_Pane);
        routes.put("east_34", east_34_Pane);
        routes.put("east_46", east_46_Pane);
        routes.put("east_27", east_27_Pane);
        routes.put("east_12", east_12_Pane);
        routes.put("east_W1", east_W1_Pane);
        routes.put("east_Q1", east_Q1_Pane);
        routes.put("east_QR", east_QR_Pane);
        routes.put("east_NQ", east_NQ_Pane);
        routes.put("east_NR", east_NR_Pane);
        routes.put("east_RW", east_RW_Pane);
        routes.put("east_W8", east_W8_Pane);
        routes.put("east_78", east_78_Pane);
        routes.put("east_TV", east_TV_Pane);
        routes.put("east_67", east_67_Pane);
        routes.put("east_Z4", east_Z4_Pane);
        routes.put("east_X3", east_X3_Pane);
        routes.put("east_SV", east_SV_Pane);
        routes.put("east_LT", east_LT_Pane);
        routes.put("east_MO", east_MO_Pane);
        routes.put("east_KN", east_KN_Pane);
        routes.put("east_GL", east_GL_Pane);
        routes.put("east_DJ", east_DJ_Pane);
        routes.put("east_DE", east_DE_Pane);
    }

    public void routeVisibility(String warehouse, String nodeA, String nodeB, boolean visible) {
        String routeKey;
        Pane route;

        // select requested route
        routeKey = warehouse + "_" + nodeA + nodeB;
        route = routes.get(routeKey);

        // shoe route
        route.setVisible(visible);
    }

    private void nameRegionHandle(MouseEvent event) {
        // change sort direction if already selected
        Color rectColor = (Color)nameRectangle.getFill();
        String colorHex = String.format( "%02x%02x%02x",
                (int)( rectColor.getRed() * 255 ),
                (int)( rectColor.getGreen() * 255 ),
                (int)( rectColor.getBlue() * 255 ) );
        if( colorHex.equals("c8d8e1") ) {
            nameAscPolygon.setVisible( !nameAscPolygon.isVisible() );
            nameDescPolygon.setVisible( !nameDescPolygon.isVisible() );
        }

        // ensure only this heading is selected
        nameRectangle.setFill( Color.web("c8d8e1") );
        sizeRectangle.setFill( Color.web("dadada") );
        priceRectangle.setFill( Color.web("dadada") );

        clearListItems();

        // sort item list
        if(nameAscPolygon.isVisible()) {
            RadixSort.sort( getFoundItems(), RadixSort.SortValue.Name, false ).forEach(item -> addListItem(item) );
        } else {
            RadixSort.sort( getFoundItems(), RadixSort.SortValue.Name, true ).forEach(item -> addListItem(item) );
        }
    }

    private void sizeRegionHandle(MouseEvent event) {
        // change sort direction if already selected
        Color rectColor = (Color)sizeRectangle.getFill();
        String colorHex = String.format( "%02x%02x%02x",
                (int)( rectColor.getRed() * 255 ),
                (int)( rectColor.getGreen() * 255 ),
                (int)( rectColor.getBlue() * 255 ) );
        if( colorHex.equals("c8d8e1") ) {
            sizeAscPolygon.setVisible(!sizeAscPolygon.isVisible());
            sizeDescPolygon.setVisible(!sizeDescPolygon.isVisible());
        }

        // ensure only this heading is selected
        nameRectangle.setFill( Color.web("dadada") );
        sizeRectangle.setFill( Color.web("c8d8e1") );
        priceRectangle.setFill( Color.web("dadada") );

        clearListItems();

        // sort item list
        if(sizeAscPolygon.isVisible()) {
            RadixSort.sort( getFoundItems(), RadixSort.SortValue.Size, false ).forEach(item -> addListItem(item) );
        } else {
            RadixSort.sort( getFoundItems(), RadixSort.SortValue.Size, true ).forEach(item -> addListItem(item) );
        }
    }

    private void priceRegionHandle(MouseEvent event) {
        // change sort direction if already selected
        Color rectColor = (Color)priceRectangle.getFill();
        String colorHex = String.format( "%02x%02x%02x",
                (int)( rectColor.getRed() * 255 ),
                (int)( rectColor.getGreen() * 255 ),
                (int)( rectColor.getBlue() * 255 ) );
        if( colorHex.equals("c8d8e1") ) {
            priceAscPolygon.setVisible(!priceAscPolygon.isVisible());
            priceDescPolygon.setVisible(!priceDescPolygon.isVisible());
        }

        // ensure only this heading is selected
        nameRectangle.setFill( Color.web("dadada") );
        sizeRectangle.setFill( Color.web("dadada") );
        priceRectangle.setFill( Color.web("c8d8e1") );

        clearListItems();

        // sort item list
        if(priceAscPolygon.isVisible()) {
            RadixSort.sort( getFoundItems(), RadixSort.SortValue.Price, false ).forEach(item -> addListItem(item) );
        } else {
            RadixSort.sort( getFoundItems(), RadixSort.SortValue.Price, true ).forEach(item -> addListItem(item) );
        }
    }

    private void sendDeliveryHandle(MouseEvent event) {
        resetUI();
    }

    private void itemSearch(String searchTest) {
        if( searchTest.isEmpty() ) {
            // show all items
            foundItems = allItems;
        } else {
            // restrict found items to matching items only
            foundItems = searchableItems;
        }

        //
        //  clear item list then show found items sorted based on current sort selection
        //

        clearListItems();

        Color priceColor = (Color)priceRectangle.getFill();
        String priceHex = String.format( "%02x%02x%02x",
                (int)( priceColor.getRed() * 255 ),
                (int)( priceColor.getGreen() * 255 ),
                (int)( priceColor.getBlue() * 255 ) );
        if( priceHex.equals("c8d8e1") ) {
            if(priceAscPolygon.isVisible()) {
                RadixSort.sort( getFoundItems(), RadixSort.SortValue.Price, false ).forEach(item -> addListItem(item) );
            } else {
                RadixSort.sort( getFoundItems(), RadixSort.SortValue.Price, true ).forEach(item -> addListItem(item) );
            }
        }

        Color sizeColor = (Color)sizeRectangle.getFill();
        String sizeHex = String.format( "%02x%02x%02x",
                (int)( sizeColor.getRed() * 255 ),
                (int)( sizeColor.getGreen() * 255 ),
                (int)( sizeColor.getBlue() * 255 ) );
        if( sizeHex.equals("c8d8e1") ) {
            if(sizeAscPolygon.isVisible()) {
                RadixSort.sort( getFoundItems(), RadixSort.SortValue.Size, false ).forEach(item -> addListItem(item) );
            } else {
                RadixSort.sort( getFoundItems(), RadixSort.SortValue.Size, true ).forEach(item -> addListItem(item) );
            }
        }

        Color nameColor = (Color)nameRectangle.getFill();
        String nameHex = String.format( "%02x%02x%02x",
                (int)( nameColor.getRed() * 255 ),
                (int)( nameColor.getGreen() * 255 ),
                (int)( nameColor.getBlue() * 255 ) );
        if( nameHex.equals("c8d8e1") ) {
            if(nameAscPolygon.isVisible()) {
                RadixSort.sort( getFoundItems(), RadixSort.SortValue.Name, false ).forEach(item -> addListItem(item) );
            } else {
                RadixSort.sort( getFoundItems(), RadixSort.SortValue.Name, true ).forEach(item -> addListItem(item) );
            }
        }
    }

    private void addListItem(Item item) {
        // add item to main list
        itemObservableList.add( item );
    }

    private void clearListItems() {
        // remove all items from main list
        itemObservableList.clear();
    }

    protected void addBasketItem(Item item) {
        // add item to the basket and its warehouse list
        basketObservableList.add( item );

        if(item.getWarehouse() == Item.Location.East) {
            eastObservableList.add( item );
        } else {
            westObservableList.add( item );
        }
    }

    protected void removeBasketItem(Item item) {
        // remove item from the basket and its warehouse list
        basketObservableList.remove( item );

        if(item.getWarehouse() == Item.Location.East) {
            eastObservableList.remove( item );
        } else {
            westObservableList.remove( item );
        }
    }

    private ArrayList<Item> getFoundItems() {
        return foundItems;
    }

    private void resetUI() {
        // Reset business selection
        clearBusinesses();

        // Hide all routes
        routes.forEach((k, route) -> route.setVisible(false));

        // Reset sort orders
        nameAscPolygon.setVisible( false );
        nameDescPolygon.setVisible( true );
        sizeAscPolygon.setVisible( false );
        sizeDescPolygon.setVisible( true );
        priceAscPolygon.setVisible( false );
        priceDescPolygon.setVisible( true );

        // Clear search box
        searchTextField.clear();

        // Clear items lists
        clearListItems();
        basketObservableList.clear();
        eastObservableList.clear();
        westObservableList.clear();

        // Hide descending arrows
        nameDescPolygon.setVisible(false);
        sizeDescPolygon.setVisible(false);
        priceDescPolygon.setVisible(false);

        // Show ascending arrows
        nameAscPolygon.setVisible(true);
        sizeAscPolygon.setVisible(true);
        priceAscPolygon.setVisible(true);

        // set sort selection colors
        nameRectangle.setFill( Color.web("c8d8e1") );
        sizeRectangle.setFill( Color.web("dadada") );
        priceRectangle.setFill( Color.web("dadada") );

        // Add and sort items
        RadixSort.sort( getFoundItems(), RadixSort.SortValue.Name, false ).forEach(item -> addListItem(item) );
    }
}
