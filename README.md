# Screen Recorder

### **Table of Contents**
1. [Introduction](#introduction)
2. [Features](#features)
3. [Installation](#installation)
4. [Usage](#usage)
5. [Permissions](#permissions)
6. [Architecture](#architecture)
7. [Contributing](#contributing)
8. [Special Thanks](#special-thanks)
9. [License](#license)

---

## **Introduction**

The Screen Recorder App is a fully offline, privacy-respecting Android application that allows users to record their device's screen with advanced features such as custom video settings, in-app editing, and more. This app is designed with user privacy in mind, meaning it does not require internet access or any privacy-invasive permissions.

## **Features**

- **Screen Recording**: Capture your device's screen in high quality.
- **Customizable Recording Settings**: Choose video resolution, bitrate, and frame rate.
- **In-App Video Editing**: Trim your recorded videos without leaving the app.
- **Floating Controls**: Start, pause, and stop recording with a floating widget.
- **No Internet Required**: Works entirely offline, ensuring your data stays private.
- **Dark Mode and Themes**: Customize the app appearance with various themes.

## **Installation**

To build and install this app locally, follow these steps:

### **Prerequisites**
- Android Studio (latest version recommended)
- Android SDK (API level 21 or higher)
- Git

### **Steps**
1. **Clone the repository:**
    ```bash
    git clone https://github.com/PaPaGuyCodes/ScreenRecorder.git
    cd ScreenRecorder
    ```
2. **Open the project in Android Studio:**
   - Launch Android Studio and select `Open an existing project`.
   - Navigate to the project directory and click `OK`.

3. **Sync Gradle Files:**
   - Gradle should automatically sync when the project is opened. If not, click `Sync Project with Gradle Files`.

4. **Build and Run the App:**
   - Connect your Android device or start an emulator.
   - Click `Run` (green play button) in Android Studio or press `Shift + F10`.

## **Usage**

### **Starting a Recording**
1. Open the app.
2. Customize your recording settings (resolution, bitrate, etc.) in the settings menu.
3. Press the **Record** button or use the floating widget to start recording.
4. A countdown will appear before the recording starts.
5. Use the floating widget to pause, resume, or stop the recording.

### **Editing a Video**
1. After recording, select the video from the list of recordings.
2. Use the in-app video editor to trim the video as needed.
3. Save the trimmed video directly to your device.

### **Customizing Themes**
1. Go to the settings menu.
2. Choose from different themes (Default, Dark, GitHub Dark).
3. The theme will be applied immediately after selection.

## **Permissions**

The app requires the following permissions to function correctly:

- `RECORD_AUDIO`: To capture audio during screen recording.
- `WRITE_EXTERNAL_STORAGE`: To save recorded videos to the device.
- `READ_EXTERNAL_STORAGE`: To access videos for editing.
- `FOREGROUND_SERVICE`: To run the recording service in the background.
- `SYSTEM_ALERT_WINDOW`: For the floating control widget.

*Note: The app does not require internet permissions or access to sensitive user data.*

## **Architecture**

### **Modules**
- **Main Module (`app`)**: Contains all the source code, resources, and configuration files for the application.

### **Key Components**
- **Activities**: Handle the UI for various features such as recording settings, video editing, etc.
  - `MainActivity.kt`: Main screen with options to start recording and access settings.
  - `VideoEditingActivity.kt`: Video editor interface.
  - `SettingsActivity.kt`: Handles app settings like themes and recording preferences.
  - `SplashActivity.kt`: Splash screen displayed on app launch.
  
- **Services**:
  - `ScreenRecordService.kt`: Manages screen recording in the background.

### **Libraries Used**
- **AndroidX**: Core libraries for backward compatibility and modern Android development.
- **Material Design Components**: For modern UI components and theming.
- **VideoTrimmer**: A library for trimming videos locally.

## **Special Thanks**

This project wouldn't have been possible without the following open-source libraries and tools:

- **[AndroidX](https://developer.android.com/jetpack/androidx)**: Provided essential libraries that are critical for modern Android development.
- **[Material Design Components](https://github.com/material-components/material-components-android)**: Enabled the creation of a modern and consistent UI.
- **[VideoTrimmer](https://github.com/a914-gowtham/android-video-trimmer)**: Offered robust video trimming functionality that was seamlessly integrated into the app.

A huge thank you to the developers and contributors of these projects for their efforts and dedication to open-source software!

## **License**

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
