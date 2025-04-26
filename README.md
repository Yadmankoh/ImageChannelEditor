# ICE

A Java-based image analysis tool inspired by Stegsolve, designed for viewing and manipulating image channels (Red, Green, Blue, Alpha) and their bit planes. The program allows users to load images of any size, cycle through different display modes using arrow buttons, and save modified images.

## Features
- Load images in JPG, PNG, or BMP formats.
- Cycle through display modes using left (`←`) and right (`→`) arrow buttons:
  - Full channels: Red, Green, Blue, Alpha.
  - Bit planes (0–7) for each channel.
  - Alpha channels 1–6 (corresponding to Alpha bits 0–5).
- Save modified images in PNG format.
- Menu with "About" information.
- Supports images of any size with a scrollable view.

## Requirements
- Java Development Kit (JDK) 8 or higher.
- A Java-compatible IDE (e.g., IntelliJ IDEA) or command-line tools for compilation.

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/ImageChannelEditor.git
   ```
2. Navigate to the project directory:
   ```bash
   cd ImageChannelEditor
   ```

## Compilation and Running
1. Compile the Java source code:
   ```bash
   javac src/ImageChannelEditor.java
   ```
2. Run the program:
   ```bash
   java -cp src ImageChannelEditor
   ```
   Alternatively, if using an IDE:
   - Import the project into your IDE.
   - Set the JDK in the project settings.
   - Run the `ImageChannelEditor` class.

## Usage
1. Launch the program.
2. Use the menu `File -> Open Image` to load an image (JPG, PNG, or BMP).
3. Use the `←` and `→` buttons at the bottom to cycle through display modes (e.g., Red Channel, Alpha Bit 0, Alpha Channel 1).
4. The current mode is displayed between the buttons.
5. Save the modified image using `File -> Save Image` (saved as PNG).
6. View program information via `Help -> About`.

## Project Structure
```
ImageChannelEditor/
├── src/
│   └── ImageChannelEditor.java
├── README.md
└── .gitignore
```

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contributing
Feel free to open issues or submit pull requests for improvements or bug fixes.

## Credits
Developed by "_Dyamare", 2025.