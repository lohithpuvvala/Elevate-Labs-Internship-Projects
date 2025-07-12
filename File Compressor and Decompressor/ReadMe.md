# 📦 File Compressor and Decompressor

## 🧾 Introduction
The **File Compressor and Decompressor** is a lightweight Java desktop application that allows users to **compress multiple files into a ZIP archive** and **extract files from ZIP archives** with a modern and intuitive Swing-based UI.

---

## 🧠 Abstract
Data compression is essential for efficient storage and transfer. This project showcases how to use Java’s built-in libraries (`java.util.zip`) to implement file compression and decompression. It supports multi-file compression, progress tracking, and clear UI updates based on user actions.

---

## 🛠 Tools Used
- **Java 17+ / OpenJDK 24**
- **Swing** (for GUI)
- **java.util.zip** (for compression & extraction)
- **FlatLaf 3.6** (for modern UI look and feel)

---

## 🚧 Steps Involved in Building the Project

### ✅ Core Functionalities
- Built separate UI flows for **compression** and **decompression**.
- Used `ZipOutputStream` for compressing multiple files.
- Used `ZipInputStream` for extracting ZIP contents.
- Incorporated exception handling for file errors and invalid inputs.

### ✅ User Interface (UI)
- Integrated **FlatLaf** for better visual appearance.
- Introduced a **toggle switch** to select between Compression and Decompression modes.
- Dynamically updated buttons and file views based on selected mode.
- Displayed selected files in a **table format** showing:
  - Serial Number (S.No)
  - File Name
  - File Path

### ✅ Progress and Feedback
- Added a **progress bar** for long operations.
- Provided user feedback through `JOptionPane` dialogs.
- Enabled **discard/reset** functionality to clear selected files.

---

## 🚀 Additional Features & Enhancements

| Feature | Description |
|--------|-------------|
| **FlatLaf Theme** | Modern, native-like UI styling. |
| **Toggle Switch** | Intuitive switch for switching between compression and decompression. |
| **Dynamic Buttons** | Buttons shown/hidden based on mode and file selection. |
| **Progress Bar** | Visual feedback during file operations. |
| **File Table View** | Display of selected files with index, name, and path. |
| **Discard Option** | Clear all selected files with a single click. |

---

## ⚠️ Native Access Warning (FlatLaf)

When running the application with **FlatLaf**, you might see the following warning:

```

WARNING: A restricted method in java.lang.System has been called
WARNING: java.lang.System::load has been called by com.formdev.flatlaf.util.NativeLibrary...
Use --enable-native-access=ALL-UNNAMED to avoid a warning...

```

To suppress this, launch the app using the JVM option below:

```

\--enable-native-access=ALL-UNNAMED

```

> 💡 Add this in your Run Configuration if you're using IntelliJ IDEA or similar IDEs.

---

## ✅ Conclusion
This Java-based File Compressor and Decompressor demonstrates how to build an efficient, user-friendly desktop tool using Swing. It not only performs reliable ZIP compression and extraction but also emphasizes user experience with a clean UI, progress indicators, and dynamic controls.

---

## 🎯 Deliverables
- ✅ **Executable JAR file**
- ✅ **Demo video**
- ✅ **Source code**
