import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class ImageChannelEditor extends Application {
    private BufferedImage originalImage;
    private BufferedImage modifiedImage;
    private ImageView imageView;
    private ComboBox<String> modeComboBox;
    private List<Mode> modes;
    private Label statusLabel;
    private DoubleProperty zoomLevel = new SimpleDoubleProperty(1.0);

    private static class Mode {
        String name;
        int channel; // 0: Red, 1: Green, 2: Blue, 3: Alpha
        int bit;     // -1: весь канал, 0-7: конкретный бит

        Mode(String name, int channel, int bit) {
            this.name = name;
            this.channel = channel;
            this.bit = bit;
        }
    }

    @Override
    public void start(Stage primaryStage) {
        // Инициализация режимов
        modes = new ArrayList<>();
        modes.add(new Mode("Red Channel", 0, -1));
        modes.add(new Mode("Green Channel", 1, -1));
        modes.add(new Mode("Blue Channel", 2, -1));
        modes.add(new Mode("Alpha Channel", 3, -1));
        for (int i = 0; i < 8; i++) {
            modes.add(new Mode("Red Bit " + i, 0, i));
            modes.add(new Mode("Green Bit " + i, 1, i));
            modes.add(new Mode("Blue Bit " + i, 2, i));
            modes.add(new Mode("Alpha Bit " + i, 3, i));
        }
        for (int i = 0; i < 6; i++) {
            modes.add(new Mode("Alpha Channel " + (i + 1), 3, i));
        }

        // Основной макет
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #2E2E2E;");

        // Меню
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem openItem = new MenuItem("Open Image");
        MenuItem saveItem = new MenuItem("Save Image");
        MenuItem extractItem = new MenuItem("Extract Data");
        Menu helpMenu = new Menu("Help");
        MenuItem aboutItem = new MenuItem("About");
        fileMenu.getItems().addAll(openItem, saveItem, extractItem);
        helpMenu.getItems().add(aboutItem);
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        // Панель управления
        HBox controlPanel = new HBox(10);
        controlPanel.setStyle("-fx-padding: 10; -fx-background-color: #3C3C3C;");
        modeComboBox = new ComboBox<>();
        modes.forEach(mode -> modeComboBox.getItems().add(mode.name));
        modeComboBox.setValue(modes.get(0).name);
        modeComboBox.setOnAction(e -> updateImage());
        Button zoomIn = new Button("Zoom In");
        Button zoomOut = new Button("Zoom Out");
        zoomIn.setOnAction(e -> zoomLevel.set(zoomLevel.get() * 1.2));
        zoomOut.setOnAction(e -> zoomLevel.set(zoomLevel.get() / 1.2));
        controlPanel.getChildren().addAll(new Label("Mode:"), modeComboBox, zoomIn, zoomOut);

        // Панель изображения
        imageView = new ImageView();
        imageView.scaleXProperty().bind(zoomLevel);
        imageView.scaleYProperty().bind(zoomLevel);
        ScrollPane scrollPane = new ScrollPane(imageView);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        scrollPane.setStyle("-fx-background-color: #2E2E2E;");

        // Статусная строка
        statusLabel = new Label("No image loaded");
        statusLabel.setStyle("-fx-text-fill: white; -fx-padding: 5;");

        // Макет
        root.setTop(menuBar);
        root.setCenter(scrollPane);
        root.setTop(controlPanel);
        root.setBottom(statusLabel);

        // Перетаскивание
        root.setOnDragOver(event -> {
            if (event.getGestureSource() != root && event.getDragboard().hasFiles()) {
                event.acceptTransferModes(TransferMode.COPY);
            }
            event.consume();
        });
        root.setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();
            if (db.hasFiles()) {
                loadImage(db.getFiles().get(0));
            }
            event.setDropCompleted(true);
            event.consume();
        });

        // Обработчики меню
        openItem.setOnAction(e -> openImage(primaryStage));
        saveItem.setOnAction(e -> saveImage(primaryStage));
        extractItem.setOnAction(e -> extractData());
        aboutItem.setOnAction(e -> showAboutDialog());

        // Запуск с аргументами
        String imagePath = getParameters().getUnnamed().isEmpty() ? null : getParameters().getUnnamed().get(0);
        if (imagePath != null) {
            loadImage(new File(imagePath));
        }

        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        primaryStage.setTitle("Image Channel Editor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openImage(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", "*.jpg", "*.png", "*.bmp"));
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            loadImage(file);
        }
    }

    private void loadImage(File file) {
        try {
            originalImage = ImageIO.read(file);
            modifiedImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
            updateImage();
            statusLabel.setText("Loaded: " + file.getName());
            imageView.setImage(bufferedImageToFXImage(modifiedImage));
        } catch (IOException ex) {
            statusLabel.setText("Error loading image: " + ex.getMessage());
        }
    }

    private void saveImage(Stage stage) {
        if (modifiedImage == null) return;
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG Images", "*.png"));
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            try {
                if (!file.getName().toLowerCase().endsWith(".png")) {
                    file = new File(file.getAbsolutePath() + ".png");
                }
                ImageIO.write(modifiedImage, "png", file);
                statusLabel.setText("Saved: " + file.getName());
            } catch (IOException ex) {
                statusLabel.setText("Error saving image: " + ex.getMessage());
            }
        }
    }

    private void updateImage() {
        if (originalImage == null) return;
        modifiedImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
        int modeIndex = modeComboBox.getSelectionModel().getSelectedIndex();
        Mode currentMode = modes.get(modeIndex);

        for (int y = 0; y < originalImage.getHeight(); y++) {
            for (int x = 0; x < originalImage.getWidth(); x++) {
                int rgb = originalImage.getRGB(x, y);
                int alpha = (rgb >> 24) & 0xff;
                int red = (rgb >> 16) & 0xff;
                int green = (rgb >> 8) & 0xff;
                int blue = rgb & 0xff;

                int newRed = 0, newGreen = 0, newBlue = 0, newAlpha = 255;
                int value = switch (currentMode.channel) {
                    case 0 -> red;
                    case 1 -> green;
                    case 2 -> blue;
                    case 3 -> alpha;
                    default -> 0;
                };

                if (currentMode.bit == -1) {
                    switch (currentMode.channel) {
                        case 0 -> newRed = value;
                        case 1 -> newGreen = value;
                        case 2 -> newBlue = value;
                        case 3 -> newAlpha = value;
                    }
                } else {
                    int bitValue = (value & (1 << currentMode.bit)) != 0 ? 255 : 0;
                    switch (currentMode.channel) {
                        case 0 -> newRed = bitValue;
                        case 1 -> newGreen = bitValue;
                        case 2 -> newBlue = bitValue;
                        case 3 -> newAlpha = bitValue;
                    }
                }

                int newRGB = (newAlpha << 24) | (newRed << 16) | (newGreen << 8) | newBlue;
                modifiedImage.setRGB(x, y, newRGB);
            }
        }
        imageView.setImage(bufferedImageToFXImage(modifiedImage));
    }

    private void extractData() {
        if (originalImage == null) {
            statusLabel.setText("No image loaded for data extraction");
            return;
        }
        int modeIndex = modeComboBox.getSelectionModel().getSelectedIndex();
        Mode currentMode = modes.get(modeIndex);
        StringBuilder data = new StringBuilder();
        for (int y = 0; y < originalImage.getHeight(); y++) {
            for (int x = 0; x < originalImage.getWidth(); x++) {
                int rgb = originalImage.getRGB(x, y);
                int value = switch (currentMode.channel) {
                    case 0 -> (rgb >> 16) & 0xff;
                    case 1 -> (rgb >> 8) & 0xff;
                    case 2 -> rgb & 0xff;
                    case 3 -> (rgb >> 24) & 0xff;
                    default -> 0;
                };
                if (currentMode.bit != -1) {
                    data.append((value & (1 << currentMode.bit)) != 0 ? "1" : "0");
                }
            }
        }
        String result = binaryToText(data.toString());
        TextArea textArea = new TextArea(result);
        textArea.setEditable(false);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Extracted Data");
        alert.setHeaderText("Data from " + currentMode.name);
        alert.getDialogPane().setContent(textArea);
        alert.showAndWait();
    }

    private String binaryToText(String binary) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < binary.length(); i += 8) {
            if (i + 8 <= binary.length()) {
                String byteStr = binary.substring(i, i + 8);
                int byteVal = Integer.parseInt(byteStr, 2);
                if (byteVal >= 32 && byteVal <= 126) {
                    text.append((char) byteVal);
                } else {
                    text.append('.');
                }
            }
        }
        return text.toString();
    }

    private void showAboutDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Image Channel Editor");
        alert.setContentText("Version 2.0\nStegsolve-inspired tool for image analysis.\nCreated with xAI Assistant, 2025.");
        alert.showAndWait();
    }

    private Image bufferedImageToFXImage(BufferedImage bufferedImage) {
        try {
            File tempFile = File.createTempFile("temp", ".png");
            ImageIO.write(bufferedImage, "png", tempFile);
            Image fxImage = new Image(tempFile.toURI().toString());
            tempFile.delete();
            return fxImage;
        } catch (IOException e) {
            statusLabel.setText("Error converting image: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}