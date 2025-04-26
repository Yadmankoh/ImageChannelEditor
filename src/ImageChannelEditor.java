import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageChannelEditor extends JFrame {
    private BufferedImage originalImage;
    private BufferedImage modifiedImage;
    private JLabel imageLabel;
    private JLabel modeLabel;
    private int currentModeIndex = 0;
    private List<Mode> modes;

    // Класс для хранения режима отображения
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

    public ImageChannelEditor(String imagePath) {
        setTitle("ICE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

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
        // Добавление Alpha каналов 1–6 как биты 0–5
        for (int i = 0; i < 6; i++) {
            modes.add(new Mode("Alpha Channel " + (i + 1), 3, i));
        }

        // Создание меню
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open Image");
        JMenuItem saveItem = new JMenuItem("Save Image");
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        helpMenu.add(aboutItem);
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        // Панель для изображения
        imageLabel = new JLabel();
        JScrollPane scrollPane = new JScrollPane(imageLabel);
        scrollPane.setPreferredSize(new Dimension(800, 600));

        // Панель для кнопок и метки режима
        JPanel controlPanel = new JPanel(new FlowLayout());
        JButton prevButton = new JButton("←");
        JButton nextButton = new JButton("→");
        modeLabel = new JLabel("Mode: " + modes.get(currentModeIndex).name);

        prevButton.addActionListener(e -> {
            currentModeIndex = (currentModeIndex - 1 + modes.size()) % modes.size();
            updateImage();
        });
        nextButton.addActionListener(e -> {
            currentModeIndex = (currentModeIndex + 1) % modes.size();
            updateImage();
        });

        controlPanel.add(prevButton);
        controlPanel.add(modeLabel);
        controlPanel.add(nextButton);

        // Добавление компонентов
        add(scrollPane, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        // Обработчики событий меню
        openItem.addActionListener(e -> openImage());
        saveItem.addActionListener(e -> saveImage());
        aboutItem.addActionListener(e -> showAboutDialog());

        // Загрузка изображения, если передан путь
        if (imagePath != null) {
            loadImageFromPath(imagePath);
        }

        pack();
        setLocationRelativeTo(null);
    }

    private void openImage() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "png", "bmp");
        fileChooser.setFileFilter(filter);
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                originalImage = ImageIO.read(fileChooser.getSelectedFile());
                modifiedImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
                updateImage();
                imageLabel.setIcon(new ImageIcon(modifiedImage));
                pack();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error loading image: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void loadImageFromPath(String imagePath) {
        try {
            File imageFile = new File(imagePath);
            if (imageFile.exists() && imageFile.isFile()) {
                originalImage = ImageIO.read(imageFile);
                modifiedImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
                updateImage();
                imageLabel.setIcon(new ImageIcon(modifiedImage));
                pack();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid file: " + imagePath, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error loading image: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveImage() {
        if (modifiedImage == null) return;
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png");
        fileChooser.setFileFilter(filter);
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                File outputFile = fileChooser.getSelectedFile();
                if (!outputFile.getName().toLowerCase().endsWith(".png")) {
                    outputFile = new File(outputFile.getAbsolutePath() + ".png");
                }
                ImageIO.write(modifiedImage, "png", outputFile);
                JOptionPane.showMessageDialog(this, "Image saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving image: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updateImage() {
        if (originalImage == null) return;

        modifiedImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Mode currentMode = modes.get(currentModeIndex);

        for (int y = 0; y < originalImage.getHeight(); y++) {
            for (int x = 0; x < originalImage.getWidth(); x++) {
                int rgb = originalImage.getRGB(x, y);
                int alpha = (rgb >> 24) & 0xff;
                int red = (rgb >> 16) & 0xff;
                int green = (rgb >> 8) & 0xff;
                int blue = rgb & 0xff;

                int newRed = 0, newGreen = 0, newBlue = 0, newAlpha = 255;

                // Выбор значения в зависимости от режима
                int value = switch (currentMode.channel) {
                    case 0 -> red;
                    case 1 -> green;
                    case 2 -> blue;
                    case 3 -> alpha;
                    default -> 0;
                };

                if (currentMode.bit == -1) {
                    // Отображение всего канала
                    switch (currentMode.channel) {
                        case 0 -> newRed = value;
                        case 1 -> newGreen = value;
                        case 2 -> newBlue = value;
                        case 3 -> newAlpha = value;
                    }
                } else {
                    // Отображение конкретного бита
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
        modeLabel.setText("Mode: " + currentMode.name);
        imageLabel.setIcon(new ImageIcon(modifiedImage));
        imageLabel.repaint();
    }

    private void showAboutDialog() {
        JOptionPane.showMessageDialog(this,
                "Image Channel Editor\nVersion 1.0\nStegsolve-like channel and bit plane switcher\nCreated by _Dyamare\n2025",
                "About",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String imagePath = args.length > 0 ? args[0] : null;
            new ImageChannelEditor(imagePath).setVisible(true);
        });
    }
}