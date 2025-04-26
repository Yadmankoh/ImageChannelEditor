# ImageChannelEditor

<<<<<<< HEAD
ImageChannelEditor — это мощный инструмент на Java, вдохновленный Stegsolve, для анализа и редактирования каналов изображений (Red, Green, Blue, Alpha) и их битов. Программа поддерживает загрузку изображений любого размера, переключение режимов отображения через современный интерфейс на JavaFX, а также функции перетаскивания, зума и извлечения данных. Она может запускаться с файлом через командную строку, что делает ее удобным приложением.

---

## Возможности
- Загрузка изображений в форматах JPG, PNG, BMP.
- Переключение режимов через выпадающее меню:
  - Полные каналы: Red, Green, Blue, Alpha.
  - Битовые плоскости (0–7) для каждого канала.
  - Альфа-каналы 1–6 (биты 0–5).
- Сохранение изображений в формате PNG.
- Открытие изображений через командную строку или перетаскивание.
- Зум для детального анализа.
- Извлечение данных из битовых планов для стеганографии.
- Современный интерфейс с темной темой.
=======
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
>>>>>>> 78c4ff6bc6f720ab551ce832fc8f9d7c914a5b15

## Требования
- Java Development Kit (JDK) 8 или выше.
- JavaFX SDK (для JDK 11+).
- Инструменты командной строки или IDE (например, IntelliJ IDEA).

## Установка
1. Клонируйте репозиторий:
   ```bash
   git clone https://github.com/Yadmankoh/ImageChannelEditor.git
   ```
2. Перейдите в директорию проекта:
   ```bash
   cd ImageChannelEditor
   ```

<<<<<<< HEAD
## Использование
### Компиляция и запуск
1. Скомпилируйте код:
   ```bash
   javac --module-path <путь_к_javafx>/lib --add-modules javafx.controls src/ImageChannelEditor.java
   ```
2. Запустите программу:
   ```bash
   java --module-path <путь_к_javafx>/lib --add-modules javafx.controls -cp src ImageChannelEditor
   ```

### Создание JAR
1. Скомпилируйте код:
   ```bash
   javac --module-path <путь_к_javafx>/lib --add-modules javafx.controls src/ImageChannelEditor.java
   ```
2. Создайте `MANIFEST.MF`:
   ```
   Manifest-Version: 1.0
   Main-Class: ImageChannelEditor
=======
## Usage
### Open .jar file
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
>>>>>>> 78c4ff6bc6f720ab551ce832fc8f9d7c914a5b15

   ```
3. Соберите JAR:
   ```bash
   jar cfm ImageChannelEditor.jar MANIFEST.MF -C src .
   ```
4. Запустите JAR:
   ```bash
   java --module-path <путь_к_javafx>/lib --add-modules javafx.controls -jar ImageChannelEditor.jar
   ```

### Открытие изображения через командную строку
Запустите с файлом:
```bash
java --module-path <путь_к_javafx>/lib --add-modules javafx.controls -jar ImageChannelEditor.jar path/to/image.png
```

### Ассоциация файлов (Windows)
Чтобы открывать `.png`, `.jpg`, `.bmp` двойным кликом:
1. Поместите `ImageChannelEditor.jar` и `run.bat` в папку (например, `C:\Users\Nightmare\ImageChannelEditor`).
   - Содержимое `run.bat`:
     ```bat
     @echo off
     java -jar "C:\Users\Nightmare\ImageChannelEditor\ImageChannelEditor.jar" %1
     ```
2. Запустите `associate.reg`:
   - Содержимое `associate.reg`:
     ```reg
     Windows Registry Editor Version 5.00

     [HKEY_CLASSES_ROOT\.png]
     @="ImageChannelEditor.png"

     [HKEY_CLASSES_ROOT\ImageChannelEditor.png]
     @="PNG Image"

     [HKEY_CLASSES_ROOT\ImageChannelEditor.png\shell\open\command]
     @="\"C:\\Users\\Nightmare\\ImageChannelEditor\\run.bat\" \"%1\""

     [HKEY_CLASSES_ROOT\.jpg]
     @="ImageChannelEditor.jpg"

     [HKEY_CLASSES_ROOT\ImageChannelEditor.jpg]
     @="JPEG Image"

     [HKEY_CLASSES_ROOT\ImageChannelEditor.jpg\shell\open\command]
     @="\"C:\\Users\\Nightmare\\ImageChannelEditor\\run.bat\" \"%1\""

     [HKEY_CLASSES_ROOT\.bmp]
     @="ImageChannelEditor.bmp"

     [HKEY_CLASSES_ROOT\ImageChannelEditor.bmp]
     @="BMP Image"

     [HKEY_CLASSES_ROOT\ImageChannelEditor.bmp\shell\open\command]
     @="\"C:\\Users\\Nightmare\\ImageChannelEditor\\run.bat\" \"%1\""
     ```
3. Дважды щелкните `associate.reg`.
4. Дважды щелкните на изображении для открытия.

## Структура проекта
```
ImageChannelEditor/
├── src/
<<<<<<< HEAD
│   ├── ImageChannelEditor.java
│   └── styles.css
=======
│   └── ImageChannelEditor.java
>>>>>>> 78c4ff6bc6f720ab551ce832fc8f9d7c914a5b15
├── .gitignore
├── MANIFEST.MF
├── README.md
├── run.bat
└── associate.reg
```

<<<<<<< HEAD
## Лицензия
MIT License. См. [LICENSE](LICENSE).

## Вклад
Присылайте issues или pull requests для улучшений или исправления ошибок.

## Авторы
Разработано при поддержке xAI Assistant, 2025.
=======
## License
MIT License. See [LICENSE](LICENSE) for details.

## Contributing
Submit issues or pull requests for improvements or bug fixes.

## Credits
Developed by YADMANKOH, 2025.
>>>>>>> 78c4ff6bc6f720ab551ce832fc8f9d7c914a5b15

---

## Русский

### Описание
<<<<<<< HEAD
ImageChannelEditor — Java-приложение для анализа и редактирования каналов изображений (Red, Green, Blue, Alpha) и их битов, вдохновленное Stegsolve. Поддерживает загрузку изображений любого размера, переключение режимов через выпадающее меню, зум, перетаскивание и извлечение данных.
=======
ImageChannelEditor — Java-приложение для анализа и редактирования каналов изображений (Red, Green, Blue, Alpha) и их битов, вдохновленное Stegsolve. Поддерживает загрузку изображений любого размера, переключение режимов отображения и запуск с файлом через командную строку.
>>>>>>> 78c4ff6bc6f720ab551ce832fc8f9d7c914a5b15

### Использование
1. Клонируйте репозиторий:
   ```bash
   git clone https://github.com/Yadmankoh/ImageChannelEditor.git
   ```
2. Скомпилируйте и запустите:
   ```bash
<<<<<<< HEAD
   javac --module-path <путь_к_javafx>/lib --add-modules javafx.controls src/ImageChannelEditor.java
   java --module-path <путь_к_javafx>/lib --add-modules javafx.controls -cp src ImageChannelEditor
=======
   javac src/ImageChannelEditor.java
   java -cp src ImageChannelEditor
>>>>>>> 78c4ff6bc6f720ab551ce832fc8f9d7c914a5b15
   ```
3. Создайте JAR:
   ```bash
   jar cfm ImageChannelEditor.jar MANIFEST.MF -C src .
<<<<<<< HEAD
   java --module-path <путь_к_javafx>/lib --add-modules javafx.controls -jar ImageChannelEditor.jar
   ```
4. Запустите с файлом:
   ```bash
   java --module-path <путь_к_javafx>/lib --add-modules javafx.controls -jar ImageChannelEditor.jar path/to/image.png
   ```

### Ассоциация файлов (Windows)
1. Поместите `ImageChannelEditor.jar` и `run.bat` в папку.
2. Запустите `associate.reg` для настройки `.png`, `.jpg`, `.bmp`.
3. Дважды щелкните на изображении.
=======
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
>>>>>>> 78c4ff6bc6f720ab551ce832fc8f9d7c914a5b15

---

## Українська

### Опис
<<<<<<< HEAD
ImageChannelEditor — Java-додаток для аналізу та редагування каналів зображень (Red, Green, Blue, Alpha) та їх бітів, натхненний Stegsolve. Підтримує завантаження зображень будь-якого розміру, перемикання режимів через меню, зум, перетягування та витягування даних.
=======
ImageChannelEditor — Java-додаток для аналізу та редагування каналів зображень (Red, Green, Blue, Alpha) та їх бітів, натхненний Stegsolve. Підтримує завантаження зображень будь-якого розміру, перемикання режимів та запуск із файлом через командний рядок.
>>>>>>> 78c4ff6bc6f720ab551ce832fc8f9d7c914a5b15

### Використання
1. Клонуйте репозиторій:
   ```bash
   git clone https://github.com/Yadmankoh/ImageChannelEditor.git
   ```
2. Скомпілюйте та запустіть:
   ```bash
<<<<<<< HEAD
   javac --module-path <путь_к_javafx>/lib --add-modules javafx.controls src/ImageChannelEditor.java
   java --module-path <путь_к_javafx>/lib --add-modules javafx.controls -cp src ImageChannelEditor
=======
   javac src/ImageChannelEditor.java
   java -cp src ImageChannelEditor
>>>>>>> 78c4ff6bc6f720ab551ce832fc8f9d7c914a5b15
   ```
3. Створіть JAR:
   ```bash
   jar cfm ImageChannelEditor.jar MANIFEST.MF -C src .
<<<<<<< HEAD
   java --module-path <путь_к_javafx>/lib --add-modules javafx.controls -jar ImageChannelEditor.jar
   ```
4. Запустіть із файлом:
   ```bash
   java --module-path <путь_к_javafx>/lib --add-modules javafx.controls -jar ImageChannelEditor.jar path/to/image.png
   ```

### Асоціація файлів (Windows)
1. Помістіть `ImageChannelEditor.jar` та `run.bat` у папку.
2. Запустіть `associate.reg` для налаштування `.png`, `.jpg`, `.bmp`.
3. Двічі клацніть на зображенні.
=======
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
>>>>>>> 78c4ff6bc6f720ab551ce832fc8f9d7c914a5b15
