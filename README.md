Image Channel Editor
A Java-based image analysis tool inspired by Stegsolve, designed for viewing and manipulating image channels (Red, Green, Blue, Alpha) and their bit planes. The program allows users to load images of any size, cycle through display modes (channels and bit planes) using arrow buttons, and save modified images. It supports opening images via command-line arguments, making it suitable as a standalone application.

Table of Contents

Features
Requirements
Installation
Compilation and Running
Building the JAR
Running with a File
File Association (Windows)
Project Structure
License
Contributing
Credits
Русский
Українська


Features

Load images in JPG, PNG, or BMP formats.
Cycle through display modes using ← and → buttons:
Full channels: Red, Green, Blue, Alpha.
Bit planes (0–7) for each channel.
Alpha channels 1–6 (corresponding to Alpha bits 0–5).


Save modified images in PNG format.
Open images via command-line arguments (e.g., java -jar ImageChannelEditor.jar image.png).
Menu with "Open Image", "Save Image", and "About" options.
Supports images of any size with a scrollable view.

Requirements

Java Development Kit (JDK) 8 or higher.
A Java-compatible IDE (e.g., IntelliJ IDEA) or command-line tools for compilation.

Installation

Clone the repository:git clone https://github.com/Yadmankoh/ImageChannelEditor.git


Navigate to the project directory:cd ImageChannelEditor



Compilation and Running

Compile the Java source code:javac src/ImageChannelEditor.java


Run the program:java -cp src ImageChannelEditor

Alternatively, if using an IDE:
Import the project into your IDE.
Set the JDK in the project settings.
Run the ImageChannelEditor class.



Building the JAR
To create an executable JAR file:

Compile the code:javac src/ImageChannelEditor.java


Create a MANIFEST.MF file in the project root with the following content:Manifest-Version: 1.0
Main-Class: ImageChannelEditor


Build the JAR:jar cfm ImageChannelEditor.jar MANIFEST.MF -C src .


Run the JAR:java -jar ImageChannelEditor.jar



Running with a File
To open an image directly, pass its path as a command-line argument:
java -jar ImageChannelEditor.jar path/to/image.png

File Association (Windows)
To open .png, .jpg, and .bmp files by double-clicking:

Place ImageChannelEditor.jar and run.bat in a directory (e.g., C:\Users\Nightmare\ImageChannelEditor).
Content of run.bat:@echo off
java -jar "C:\Users\Nightmare\ImageChannelEditor\ImageChannelEditor.jar" %1




Run associate.reg to associate file types with the program:
Content of associate.reg:Windows Registry Editor Version 5.00

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




Double-click associate.reg to apply the settings.
Double-click an image file to open it in ImageChannelEditor.

Project Structure
ImageChannelEditor/
├── src/
│   └── ImageChannelEditor.java
├── README.md
├── .gitignore
├── MANIFEST.MF
├── run.bat
└── associate.reg

License
This project is licensed under the MIT License. See the LICENSE file for details.
Contributing
Feel free to open issues or submit pull requests for improvements or bug fixes.
Credits
Developed by _Dyamare, 2025.

Русский
Описание
Image Channel Editor — это Java-приложение, вдохновленное Stegsolve, для анализа и редактирования каналов изображений (Red, Green, Blue, Alpha) и их битов. Программа позволяет загружать изображения любого размера, переключать режимы отображения с помощью стрелок (← и →) и сохранять измененные изображения. Поддерживается открытие изображений через аргументы командной строки.
Возможности

Загрузка изображений в форматах JPG, PNG, BMP.
Переключение режимов отображения:
Полные каналы: Red, Green, Blue, Alpha.
Битовые плоскости (0–7) для каждого канала.
Альфа-каналы 1–6 (биты 0–5 альфа-канала).


Сохранение изображений в формате PNG.
Открытие изображений через командную строку (например, java -jar ImageChannelEditor.jar image.png).
Меню с опциями "Открыть", "Сохранить" и "О программе".
Поддержка изображений любого размера с прокруткой.

Требования

Java Development Kit (JDK) 8 или выше.
IDE, совместимая с Java (например, IntelliJ IDEA), или инструменты командной строки.

Установка

Клонируйте репозиторий:git clone https://github.com/Yadmankoh/ImageChannelEditor.git


Перейдите в папку проекта:cd ImageChannelEditor



Компиляция и запуск

Скомпилируйте код:javac src/ImageChannelEditor.java


Запустите программу:java -cp src ImageChannelEditor



Создание JAR

Скомпилируйте код:javac src/ImageChannelEditor.java


Создайте файл MANIFEST.MF:Manifest-Version: 1.0
Main-Class: ImageChannelEditor


Соберите JAR:jar cfm ImageChannelEditor.jar MANIFEST.MF -C src .


Запустите JAR:java -jar ImageChannelEditor.jar



Запуск с файлом
Для открытия изображения укажите его путь:
java -jar ImageChannelEditor.jar path/to/image.png

Ассоциация файлов (Windows)
Чтобы открывать .png, .jpg, .bmp двойным кликом:

Поместите ImageChannelEditor.jar и run.bat в папку (например, C:\Users\Nightmare\ImageChannelEditor).
Содержимое run.bat:@echo off
java -jar "C:\Users\Nightmare\ImageChannelEditor\ImageChannelEditor.jar" %1




Запустите associate.reg для настройки ассоциации (см. английскую версию выше).
Дважды щелкните на изображении для открытия в программе.


Українська
Опис
Image Channel Editor — це Java-додаток, натхненний Stegsolve, для аналізу та редагування каналів зображень (Red, Green, Blue, Alpha) та їх бітових площин. Програма дозволяє завантажувати зображення будь-якого розміру, перемикати режими відображення за допомогою стрілок (← та →) та зберігати змінені зображення. Підтримується відкриття зображень через аргументи командного рядка.
Можливості

Завантаження зображень у форматах JPG, PNG, BMP.
Перемикання режимів відображення:
Повні канали: Red, Green, Blue, Alpha.
Бітові площини (0–7) для кожного каналу.
Альфа-канали 1–6 (біти 0–5 альфа-каналу).


Збереження зображень у форматі PNG.
Відкриття зображень через командний рядок (наприклад, java -jar ImageChannelEditor.jar image.png).
Меню з опціями "Відкрити", "Зберегти" та "Про програму".
Підтримка зображень будь-якого розміру з прокруткою.

Вимоги

Java Development Kit (JDK) 8 або вище.
IDE, сумісна з Java (наприклад, IntelliJ IDEA), або інструменти командного рядка.

Встановлення

Клонуйте репозиторій:git clone https://github.com/Yadmankoh/ImageChannelEditor.git


Перейдіть до папки проєкту:cd ImageChannelEditor



Компіляція та запуск

Скомпілюйте код:javac src/ImageChannelEditor.java


Запустіть програму:java -cp src ImageChannelEditor



Створення JAR

Скомпілюйте код:javac src/ImageChannelEditor.java


Створіть файл MANIFEST.MF:Manifest-Version: 1.0
Main-Class: ImageChannelEditor


Зберіть JAR:jar cfm ImageChannelEditor.jar MANIFEST.MF -C src .


Запустіть JAR:java -jar ImageChannelEditor.jar



Запуск із файлом
Для відкриття зображення вкажіть його шлях:
java -jar ImageChannelEditor.jar path/to/image.png

Асоціація файлів (Windows)
Щоб відкривати .png, .jpg, .bmp подвійним клацанням:

Помістіть ImageChannelEditor.jar та run.bat у папку (наприклад, C:\Users\Nightmare\ImageChannelEditor).
Вміст run.bat:@echo off
java -jar "C:\Users\Nightmare\ImageChannelEditor\ImageChannelEditor.jar" %1




Запустіть associate.reg для налаштування асоціації (див. англійську версію вище).
Двічі клацніть на зображенні для відкриття в програмі.

