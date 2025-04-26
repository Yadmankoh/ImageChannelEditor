# ImageChannelEditor

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
│   ├── ImageChannelEditor.java
│   └── styles.css
├── .gitignore
├── MANIFEST.MF
├── README.md
├── run.bat
└── associate.reg
```

## Лицензия
MIT License. См. [LICENSE](LICENSE).

## Вклад
Присылайте issues или pull requests для улучшений или исправления ошибок.

## Авторы
Разработано при поддержке xAI Assistant, 2025.

---

## Русский

### Описание
ImageChannelEditor — Java-приложение для анализа и редактирования каналов изображений (Red, Green, Blue, Alpha) и их битов, вдохновленное Stegsolve. Поддерживает загрузку изображений любого размера, переключение режимов через выпадающее меню, зум, перетаскивание и извлечение данных.

### Использование
1. Клонируйте репозиторий:
   ```bash
   git clone https://github.com/Yadmankoh/ImageChannelEditor.git
   ```
2. Скомпилируйте и запустите:
   ```bash
   javac --module-path <путь_к_javafx>/lib --add-modules javafx.controls src/ImageChannelEditor.java
   java --module-path <путь_к_javafx>/lib --add-modules javafx.controls -cp src ImageChannelEditor
   ```
3. Создайте JAR:
   ```bash
   jar cfm ImageChannelEditor.jar MANIFEST.MF -C src .
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

---

## Українська

### Опис
ImageChannelEditor — Java-додаток для аналізу та редагування каналів зображень (Red, Green, Blue, Alpha) та їх бітів, натхненний Stegsolve. Підтримує завантаження зображень будь-якого розміру, перемикання режимів через меню, зум, перетягування та витягування даних.

### Використання
1. Клонуйте репозиторій:
   ```bash
   git clone https://github.com/Yadmankoh/ImageChannelEditor.git
   ```
2. Скомпілюйте та запустіть:
   ```bash
   javac --module-path <путь_к_javafx>/lib --add-modules javafx.controls src/ImageChannelEditor.java
   java --module-path <путь_к_javafx>/lib --add-modules javafx.controls -cp src ImageChannelEditor
   ```
3. Створіть JAR:
   ```bash
   jar cfm ImageChannelEditor.jar MANIFEST.MF -C src .
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