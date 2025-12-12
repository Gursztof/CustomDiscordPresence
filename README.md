# 🎮 CustomDiscordRichPresence

CustomDiscordRichPresence is a small application that allows you to display a custom status on Discord while using your computer. 
It shows your activity or other relevant information directly on your Discord profile.

---

## ✨ Features

- 🖥️ Displays custom Discord Rich Presence status  
- 🌍 Cross-platform compatible (Java 21+)  
- ⚙️ Easy configuration via `config.properties`

---

## 🚀 How to Run

1. Create a folder for the program and copy the JAR file into it.  
2. Open a terminal or command prompt in that folder.  
3. Run the application with this command:

```bash
java --enable-native-access=ALL-UNNAMED -jar CustomDiscordRichPresence.jar
```
---

🛠️ Configuration

The first time you run the application, it will generate a config.properties file in the config folder (that will be also generated at first lunch).

Open config.properties in a text editor to customize your Discord Rich Presence settings, for example:
```bash
clientId=YOUR_DISCORD_APP_ID
state=Your custom state
details=Your custom details
startTimestamp=auto
```
Save the file and restart the application to apply changes.

---

✅ Requirements

- Java installed on your system

  If version v1.0.0 doesn’t work with your Java version, try v1.1.0

- Discord running on your computer

---

📝 Notes

Works on Linux, Windows, and other operating systems with Java 21+

Make sure the JAR file and config.properties are in the same folder for proper configuration


---

📄 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
