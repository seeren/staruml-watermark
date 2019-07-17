# StarUML Watermarker

Remove StarUML "UNREGISTERED" watermark from `svg` exported files

## 📦 Installation

Clone this repository
```bash
git clone https://github.com/seeren/staruml-watermark.git
```

## 🚿  Usage

Execute package for help
```bash
java -jar target/staruml-watermark.jar
```

Remove watermarks for a directory
```bash
java -jar target/staruml-watermark.jar -d C:/path/to/project
```

Remove watermarks for a directory recursively
```bash
java -jar target/staruml-watermark.jar -r -d C:/path/to/project
```
## 👨‍💻 Developpment

Compile
```bash
mvn compile exec:java -Dexec.args="-r -d C:/path/to/project" -q
```

Package
```bash
mvn package
```



## 🎓 License
This project is licensed under the [MIT](LICENSE) License.