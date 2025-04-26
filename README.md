# ImageChannelEditor

ImageChannelEditor is a Java-based tool inspired by Stegsolve for analyzing and editing image channels (Red, Green, Blue, Alpha) and their bit planes. It supports loading images of any size, cycling through display modes, and saving modified images. The application can be launched with a file path for quick image loading.

---

## Features
- Load images in JPG, PNG, or BMP formats.
- Cycle through modes using arrow buttons:
  - Full channels: Red, Green, Blue, Alpha.
  - Bit planes (0–7) for each channel.
  - Alpha channels 1–6 (bits 0–5).
- Save images in PNG format.
- Open images via command-line arguments.
- User-friendly interface with menu and scrollable view.

## Requirements
- Java Development Kit (JDK) 8 or higher.
- Command-line tools or a Java-compatible IDE (e.g., IntelliJ IDEA).

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/Yadmankoh/ImageChannelEditor.git
   ```
2. Navigate to the project directory:
   ```bash
   cd ImageChannelEditor
   ```

## Usage
### Compile and Run
1. Compile the source code:
   ```bash
   javac src/ImageChannelEditor.java
   ```
2. Run the program:
   ```bash
   java -cp src ImageChannelEditor
   ```

### Build Executable JAR
1. Compile the code:
   ```bash
   javac src/ImageChannelEditor.java
   ```
2. Create `MANIFEST.MF` in the project root:
   ```
   Manifest-Version: 1.0
   Main-Class: ImageChannelEditor

   ```
3. Build the JAR:
   ```bash
   jar cfm ImageChannelEditor.jar MANIFEST.MF -C src .
   ```
4. Run the JAR:
   ```bash
   java -jar ImageChannelEditor.jar
   ```

### Open Image via Command Line
Launch with an image file:
```bash
java -jar ImageChannelEditor.jar path/to/image.png
```

### File Association (Windows)
To open `.png`, `.jpg`, or `.bmp` files by double-clicking:
1. Place `ImageChannelEditor.jar` and `run.bat` in a directory (e.g., `C:\Program Files\ImageChannelEditor`).
   - `run.bat` content:
     ```bat
     @echo off
     java -jar "C:\Program Files\ImageChannelEditor\ImageChannelEditor.jar" %1
     ```
2. Run `associate.reg` to associate file types:
   - `associate.reg` content:
     ```reg
     Windows Registry Editor Version 5.00

     [HKEY_CLASSES_ROOT\.png]
     @="ImageChannelEditor.png"

     [HKEY_CLASSES_ROOT\ImageChannelEditor.png]
     @="PNG Image"

     [HKEY_CLASSES_ROOT\ImageChannelEditor.png\shell\open\command]
     @="\"C:\\Program Files\\ImageChannelEditor\\run.bat\" \"%1\""

     [HKEY_CLASSES_ROOT\.jpg]
     @="ImageChannelEditor.jpg"

     [HKEY_CLASSES_ROOT\ImageChannelEditor.jpg]
     @="JPEG Image"

     [HKEY_CLASSES_ROOT\ImageChannelEditor.jpg\shell\open\command]
     @="\"C:\\Program Files\\ImageChannelEditor\\run.bat\" \"%1\""

     [HKEY_CLASSES_ROOT\.bmp]
     @="ImageChannelEditor.bmp"

     [HKEY_CLASSES_ROOT\ImageChannelEditor.bmp]
     @="BMP Image"

     [HKEY_CLASSES_ROOT\ImageChannelEditor.bmp\shell\open\command]
     @="\"C:\\Program Files\\ImageChannelEditor\\run.bat\" \"%1\""
     ```
3. Double-click `associate.reg` to apply.
4. Double-click an image to open it in ImageChannelEditor.

## Project Structure
```
ImageChannelEditor/
├── src/
│   └── ImageChannelEditor.java
├── .gitignore
├── MANIFEST.MF
├── README.md
├── run.bat
└── associate.reg
```

## License
MIT License. See [LICENSE](LICENSE) for details.

## Contributing
Submit issues or pull requests for improvements or bug fixes.

## Credits
Developed by YADMANKOH, 2025.

---

## Русский

### Описание
ImageChannelEditor — Java-приложение для анализа и редактирования каналов изображений (Red, Green, Blue, Alpha) и их битов, вдохновленное Stegsolve. Поддерживает загрузку изображений любого размера, переключение режимов отображения и запуск с файлом через командную строку.

### Использование
1. Клонируйте репозиторий:
   ```bash
   git clone https://github.com/Yadmankoh/ImageChannelEditor.git
   ```
2. Скомпилируйте и запустите:
   ```bash
   javac src/ImageChannelEditor.java
   java -cp src ImageChannelEditor
   ```
3. Создайте JAR:
   ```bash
   jar cfm ImageChannelEditor.jar MANIFEST.MF -C src .
   java -jar ImageChannelEditor.jar
   ```
4. Запустите с файлом:
   ```bash
   java -jar ImageChannelEditor.jar path/to/image.png
   ```

### Ассоциация файлов (Windows)
1. Поместите `ImageChannelEditor.jar` и `run.bat` в папку (например, `C:\Program Files\ImageChannelEditor`).
2. Запустите `associate.reg` для настройки `.png`, `.jpg`, `.bmp`.
3. Дважды щелкните на изображении для открытия.

---

## Українська

### Опис
ImageChannelEditor — Java-додаток для аналізу та редагування каналів зображень (Red, Green, Blue, Alpha) та їх бітів, натхненний Stegsolve. Підтримує завантаження зображень будь-якого розміру, перемикання режимів та запуск із файлом через командний рядок.

### Використання
1. Клонуйте репозиторій:
   ```bash
   git clone https://github.com/Yadmankoh/ImageChannelEditor.git
   ```
2. Скомпілюйте та запустіть:
   ```bash
   javac src/ImageChannelEditor.java
   java -cp src ImageChannelEditor
   ```
3. Створіть JAR:
   ```bash
   jar cfm ImageChannelEditor.jar MANIFEST.MF -C src .
   java -jar ImageChannelEditor.jar
   ```
4. Запустіть із файлом:
   ```bash
   java -jar ImageChannelEditor.jar path/to/image.png
   ```

### Асоціація файлів (Windows)
1. Помістіть `ImageChannelEditor.jar` та `run.bat` у папку (наприклад, `C:\Program Files\ImageChannelEditor`).
2. Запустіть `associate.reg` для налаштування `.png`, `.jpg`, `.bmp`.
3. Двічі клацніть на зображенні для відкриття.
