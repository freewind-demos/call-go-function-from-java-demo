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
1. In go file, we must use `// export MyFuncName` to export the functions we want to call from Java
2. In go file, the package must be `main`, and there is a function `main`
3. We can use `nm xxx.so` and `grep` to verify if the required function is exported
