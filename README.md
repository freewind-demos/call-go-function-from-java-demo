Call Go Function from Java with JNA Demo
========================================

With the help of [JNA](https://github.com/java-native-access/jna), we can call functions defined by GO from Java.

```
cd go
go build -buildmode=c-shared -o math.so math.go
```

Then run `Hello.java` (from IDE)

Notice
-----
1. In go file, we must declared `import "C"`. Since IDEA will auto remove unused imported lib, we have to use `//// formatter: off/on` around it to keep it. Also note we have to use `////` instead of `//` to make `go build` work
2. In go file, we must use `// export MyFuncName` to export the functions we want to call from Java
3. In go file, the package must be `main`, and there is a function `main`
4. We can use `nm math.so | grep Multiply` to verify if the required function is exported
