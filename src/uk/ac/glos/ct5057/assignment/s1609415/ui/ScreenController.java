package uk.ac.glos.ct5057.assignment.s1609415.ui;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

import java.util.HashMap;

public class ScreenController {

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

    @FXML private ListView itemsListView;
    @FXML private ListView basketListView;
    @FXML private ListView westListView;
    @FXML private ListView eastListView;

    @FXML private Polygon nameAscPolygon;
    @FXML private Polygon nameDescPolygon;
    @FXML private Polygon sizeAscPolygon;
    @FXML private Polygon sizeDescPolygon;
    @FXML private Polygon priceAscPolygon;
    @FXML private Polygon priceDescPolygon;

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


    @FXML
    private void initialize() {

        clearBusinesses();

        // Handlers for clicks on businesses
        businessA_ImageView.setOnMouseClicked(this::businessAHandle);
        businessF_ImageView.setOnMouseClicked(this::businessFHandle);
        businessJ_ImageView.setOnMouseClicked(this::businessJHandle);
        businessL_ImageView.setOnMouseClicked(this::businessLHandle);
        businessN_ImageView.setOnMouseClicked(this::businessNHandle);
        businessO_ImageView.setOnMouseClicked(this::businessOHandle);
        businessT_ImageView.setOnMouseClicked(this::businessTHandle);
        businessV_ImageView.setOnMouseClicked(this::businessVHandle);
        businessW_ImageView.setOnMouseClicked(this::businessWHandle);
        business2_ImageView.setOnMouseClicked(this::business2Handle);
        business4_ImageView.setOnMouseClicked(this::business4Handle);

        // Handlers for clicks on regions
        nameRegion.setOnMouseClicked(this::nameRegionHandle);
        sizeRegion.setOnMouseClicked(this::sizeRegionHandle);
        priceRegion.setOnMouseClicked(this::priceRegionHandle);
        sendDeliveryRegion.setOnMouseClicked(this::sendDeliveryHandle);

        // Handler for text input
        searchTextField.textProperty().addListener((observable, oldText, newText)-> itemSearch(newText) );

        // Create map of routes
        mapRoutes();

        // Hide all routes
        routes.forEach((k, route) -> route.setVisible(false));

        // Hide ascending arrows
        nameAscPolygon.setVisible(false);
        sizeAscPolygon.setVisible(false);
        priceAscPolygon.setVisible(false);
    }



    // Business UI event handlers

    private void clearBusinesses(){
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

        routeKey = warehouse + "_" + nodeA + nodeB;
        route = routes.get(routeKey);

        route.setVisible(visible);
    }

    private void nameRegionHandle(MouseEvent event) {
        nameAscPolygon.setVisible( !nameAscPolygon.isVisible() );
        nameDescPolygon.setVisible( !nameDescPolygon.isVisible() );

        if(nameAscPolygon.isVisible()) {

        } else {

        }
    }

    private void sizeRegionHandle(MouseEvent event) {
        sizeAscPolygon.setVisible( !sizeAscPolygon.isVisible() );
        sizeDescPolygon.setVisible( !sizeDescPolygon.isVisible() );

        if(sizeAscPolygon.isVisible()) {

        } else {

        }
    }

    private void priceRegionHandle(MouseEvent event) {
        priceAscPolygon.setVisible( !priceAscPolygon.isVisible() );
        priceDescPolygon.setVisible( !priceDescPolygon.isVisible() );

        if(priceAscPolygon.isVisible()) {

        } else {

        }
    }

    private void sendDeliveryHandle(MouseEvent event) {
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


        // do other stuff
    }

    private void itemSearch(String searchTest) {
        if( searchTest.length() >= 3 ) {

        } else {

        }
    }
}
