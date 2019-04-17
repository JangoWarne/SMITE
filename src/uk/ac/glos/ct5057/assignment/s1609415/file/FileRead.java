package uk.ac.glos.ct5057.assignment.s1609415.file;


import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import uk.ac.glos.ct5057.assignment.s1609415.items.Item;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class reads an INI file and outputs an ArrayList of Items
 *
 * @author  Joshua Walker
 * @version 1.0
 */
public class FileRead {

    private ArrayList<Item> items;
    private String errors = "";
    private File file;
    private boolean invalid;
    private String name = "";
    private double size;
    private String sizeStr = "";
    private double price;
    private String priceStr = "";
    private Item.Location warehouse;
    private String warehouseStr = "";
    private boolean first = true;


    public FileRead( String filePath ) {
        file = new File( filePath );
    }

    public ArrayList<Item> parseFile() {
        items = new ArrayList<>();
        BufferedReader reader;

        // read file line by line
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();

            while (line != null) {
                // the important bit :D
                parseLine(line);

                // read next line
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            logError(e.getLocalizedMessage(), file.getAbsolutePath() );
        }

        reportErrors();
        return items;
    }

    private void parseLine(String line) {
        // parse line into Item without leading and trailing whitespace
        String originalLine  = line;
        line = line.trim();

        if ( !line.isEmpty() ) {
            // remove comments (text from a semi-colon onwards)
            line = line.split(";", 1)[0];

            if ( !line.isEmpty() ) {
                // find new Item ( text between [] )
                int start = line.indexOf("[");
                int end = line.indexOf("]");
                String nameStr = "";

                if (start > -1 && end > -1 && end > start) {
                    nameStr = line.substring(start + 1, end);
                }

                if ( !nameStr.isEmpty() ) {
                    // pattern found: create new item
                    newItem( nameStr, originalLine );

                } else {
                    // check for item parameters ( property = value )
                    if ( line.contains("=") ) {
                        String property = line.split("=" )[0];
                        String value = line.split("=" )[1];

                        setProperty(property, value, originalLine);

                    } else {
                        // if neither [] or = were found then check for unbalanced brackets
                        if ( line.contains("[") || line.contains("]") ) {
                            name = sizeStr = priceStr = warehouseStr = "";     //reset item
                            invalid = true;
                            logError("Unbalanced Brackets", originalLine);
                        }
                    }
                }
            }
        }
    }

    private void newItem(String newName, String originalLine) {
        if (first) {
            first = false;
        } else {
            // add completed item to list
            if ( name.isEmpty() || sizeStr.isEmpty() || priceStr.isEmpty() || warehouseStr.isEmpty()) {
                if ( name.isEmpty() ) {
                    logError("Missing Name", "lines before: " + originalLine);
                }
                if ( sizeStr.isEmpty() ) {
                    logError("Missing Size", "lines before: " + originalLine);
                }
                if ( priceStr.isEmpty() ) {
                    logError("Missing Price", "lines before: " + originalLine);
                }
                if ( warehouseStr.isEmpty() ) {
                    logError("Missing Warehouse", "lines before: " + originalLine);
                }
            } else {
                items.add( new Item(name, size, price, warehouse) );
            }
        }
        name = sizeStr = priceStr = warehouseStr = "";     //reset item

        setProperty("name", newName, originalLine);
    }

    private void setProperty(String property, String value, String originalLine) {
        //
        if (invalid) {
            return;
        }

        property = property.trim().toLowerCase();
        value = value.trim().toLowerCase();

        if ( property.isEmpty() || value.isEmpty() ) {
            if ( property.isEmpty() ) {
                logError("Empty Property String", originalLine);
            }
            if ( value.isEmpty() ){
                logError("Empty Value String", originalLine);
            }
            return;
        }

        switch (property) {
            case "name":
                name = value;
                break;
            case "size":
                try {
                    size = Double.valueOf(value);
                    sizeStr = value;
                } catch (NumberFormatException e) {
                    logError("Value Is Not A Valid Number", originalLine);
                }
                break;
            case "price":
                try {
                    price = Double.valueOf(value);
                    priceStr = value;
                } catch (NumberFormatException e) {
                    logError("Value Is Not A Valid Number", originalLine);
                }
                break;
            case "warehouse":
                switch (value) {
                    case "east":
                        warehouse = Item.Location.East;
                        warehouseStr = value;
                        break;
                    case "west":
                        warehouse = Item.Location.West;
                        warehouseStr = value;
                        break;
                    default:
                        logError("Invalid Warehouse (east, west)", originalLine);
                }
                break;
            default:
                logError("Invalid Property Name (name, size, price, warehouse)", originalLine);
        }
    }

    private void logError(String error, String line) {
        // Append new error log to end of errors array
        errors += error + ":\n  for: \"" + line + "\"\n";
    }

    private void reportErrors() {
        // Show error dialog if errors is not empty
        if ( !errors.isEmpty() ) {

            // Code.makery.ch. (2014). JavaFX Dialogs (official) | code.makery.ch. [online]
            // Available at: https://code.makery.ch/blog/javafx-dialogs-official/ [Accessed 3 Apr. 2019]

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File Read Error");
            alert.setHeaderText("Error reading " + file.getName() );
            alert.setContentText("Filepath: " + file.getAbsolutePath() );

            Label label = new Label("Errors:");

            TextArea textArea = new TextArea(errors);
            textArea.setEditable(false);
            textArea.setWrapText(true);

            textArea.setMaxWidth(Double.MAX_VALUE);
            textArea.setMaxHeight(Double.MAX_VALUE);
            GridPane.setVgrow(textArea, Priority.ALWAYS);
            GridPane.setHgrow(textArea, Priority.ALWAYS);

            GridPane expContent = new GridPane();
            expContent.setMaxWidth(Double.MAX_VALUE);
            expContent.add(label, 0, 0);
            expContent.add(textArea, 0, 1);

            // Set expandable error list into the dialog pane.
            alert.getDialogPane().setExpandableContent(expContent);

            alert.showAndWait();
        }
    }
}
