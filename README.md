Call Go Function from Java with JNA Demo
========================================

With the help of [JNA](https://github.com/java-native-access/jna), we can call functions defined by GO from Java.

```
cd go
go build -buildmode=c-shared -o awesome.so awesome.go
```

If succeed, you will see `awesome.h` and `awesome.so` generated, both of them are very important. `awesome.h` is used to read the definition of the generated functions and you can define the corresponding structure in Java code. `awesome.so` is used for calling.

If there is any message shown in the console, there probably be something wrong.

Then run `Hello.java` (from IDE)

Notice
-----
1. In go file, we must declared `import "C"`. Since IDEA will auto remove unused imported lib, we have to use `//// formatter: off/on` around it to keep it. Also note we have to use `////` instead of `//` to make `go build` work
2. In go file, we must use `//export MyFuncName` to export the functions we want to call from Java. Note it must be `//export`, there is no spaces between `//` and `export`.
3. In go file, the package must be `main`, and there is a function `main`
4. We can use `nm awesome.so | grep Multiply` to verify if the required function is exported
5. We can't return or pass `string` from Go code, instead, we should use `*C.char`
6. We can't return or pass `byte[]` from Go code, instead, we should use `unsafe.Pointer`

You must be very careful about the advices here.

Resources
---------
- <https://github.com/java-native-access/jna>
- <https://golang.org/cmd/cgo/>
- <https://github.com/vladimirvivien/go-cshared-examples>
