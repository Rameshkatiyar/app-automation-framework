# app-automation-framework (Android + iOS)
## (Appium + TestNG + Java + SpringBoot + Maven)

## 0. Create Automation Project
- Open IDE - Intellij
- Create Java Maven Project
- Add TestNg, SpringBoot, selenium & appium dependencies
- Write app automation test cases.


## 1. Appium Server Setup
- Platform: Mac OS
### a) Install - Java
https://www.java.com/en/download/
### b) Install - NodeJs
https://nodejs.org/en/download/
### c) Install - Appium Server
`npm install -g appium`

Appium server is implemented in NodeJS. That's why we need to install NodeJs before appium server installation.
### d) Start appium
Run `appium` command

Logs:

[Appium] Welcome to Appium v1.16.0
[Appium] Appium REST http interface listener started on 0.0.0.0:4723

## 2. Android Platform Setup - For Local Test
### a) Set JAVA_HOME environment variables
Check after setup: `echo $JAVA_HOME`

### b) Download android sdk
`brew cask install android-sdk`

Reference: https://stackoverflow.com/questions/2677431/where-to-install-android-sdk-on-mac-os-x

### c) Install SDK Manager
`sdkmanager "platform-tools" "platforms;android-29"`

Reference: https://developer.android.com/studio/command-line/sdkmanager

### d) Set ANDROID_HOME environment variable
`export ANDROID_HOME =/usr/local/share/android-sdk/`

`echo $ANDROID_HOME`

### e) Add Platform tools in PATH environment variable
PATH="/usr/local/Caskroom/android-sdk/4333796/platform-tools : ${PATH}”

`export PATH="/usr/local/Caskroom/android-sdk/4333796/platform-tools:${PATH}"`

### f) Connect an android mobile device
- Connect mobile with USB cable.
- Enable developer mode
- Enable USB debugging

### g) Set device "_udid_" in Desired Capabilities of code
To get the udid run the command `adb devices`

### h) Run and execute test on Real device 

## 3. iOS Platform Setup - For Local Test
### a) Set JAVA_HOME environment variables
Check after setup: `echo $JAVA_HOME`

### b) Install XCode
https://apps.apple.com/us/app/xcode/id497799835?mt=12

or 

https://developer.apple.com/download/...

### c) Install External Dependencie
Reference: https://github.com/appium/appium-xcuitest-driver

- _carthage_
`brew install carthage`
 `npm i -g webpack`
 Reference: https://github.com/Carthage/Carthage#installing-carthage

 - _Authorize-ios_
`npm install -g authorize-ios`
We need this tool for running our tests on real devices.

-  _ideviceinstaller_
`sudo xcode-select -r`
We need this utility to run tests on real devices.

- _xcpretty_
`gem install xcpretty`

### d) Setup WebDriverAgent project
- mkdir -p Resources/WebDriverAgent.bundle 
- ./Scripts/bootstrap.sh -d
- Open WebDriverAgent.xcodeproj in Xcode 
- Select the device
- Build the project

### e) Set the iPA or APP location and platform info in Desired Capabilities
**Location Info:**

`capabilities.setCapability("app", “path location of .ipa or .app file“);`

Example: Location = /Users/ramesh/Library/Developer/Xcode/DerivedData/WebDriverAgent-abc/Build/Products/Debug-iphonesimulator/Calculator.app


**Platform Info:**

`cap.setCapability("platformName", "iOS");`
`cap.setCapability("platformVersion", "10");`
`cap.setCapability("deviceName", "iPhone 6")`

### f) Run and execute test on Simulator

## Theory to know

### Appium
- Automation open source tool for mobile automation.
- Can automate Native, Web and Hybrid mobile app.

### iPA: 
iOS APP Store Package

### APK: 
Android Application Package file

### Json Wire Protocol
It is a protocol or program which convert the client request (automation commands) to HTTP request which server can understand.

### Desired Capabilities
Client send the DC to the appium server. 
It contain mainly two types of information:

`DesiredCapability = AboutDevice + AboutApplication` 

About device:
- Device name
- UI ID
- Platform name
- Platform version

About App:
- App package
- App activity

### Device Automation Driver
Each mobile device have their native automation driver. Using this driver appium server interact with iOS or Android or Windows mobile devices.

Example:
- iOS: UIAutomation Driver
- Android: UIAutomator or Selendroid Driver
- Windows: WinApp Driver

### Android SDK:
- Android S/W development kit. Use to develop android applications.
- It is also provide the Emulator (Virtual Device Manager).

### SDK Manager:
- It is a command line tool that allow you to view, install, update packages of Android SDK.
- But if you already installed Android studio, then we don't need it (As it is already in Android studio and you can manage it from their.).

### XCode
- It is used to develop, debug and build the iOS application on Mac. 
- But we will use it here for create virtual devices (Simulator). 
- We need apple id to setup it.
- Download and install it. (It's mainly 5+ GB size.)
- In this we use Swift language to build iOS app.

### Carthage:
- Carthage is used to be provide the simplest way to add frameworks to your iOS application.
- Carthage builds your dependencies and provides you with binary frameworks.
- It's like a dependency manager tool. (like Maven)

### WebDriverAgent
- WebDriverAgent is a WebDriver server implementation for iOS that can be used to remote control iOS devices. 
- It allows you to launch & kill applications, tap & scroll views or confirm view presence on a screen. 
- This makes it a perfect tool for application end-to-end testing or general purpose device automation.

Reference: https://github.com/facebookarchive/WebDriverAgent

### XCUITest Driver for iOS:
Appium's primary support for automating iOS apps is via the XCUITest driver.
http://appium.io/docs/en/drivers/ios-xcuitest/