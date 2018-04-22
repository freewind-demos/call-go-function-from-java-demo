package main

//// formatter: off
import "C"
import (
	"fmt"
	"sync"
	"unsafe"
)

var mtx sync.Mutex

//// formatter: on

//export Multiply
func Multiply(x int64, y int64) int64 {
	return x * y
}

//export ReturnString
func ReturnString(s *C.char) *C.char {
	mtx.Lock()
	defer mtx.Unlock()
	goS := C.GoString(s)
	fmt.Println("Hello, " + goS)
	return C.CString("Returned " + goS)
}

//export TwoStrings
func TwoStrings() (first, second *C.char) {
	return C.CString("aa"), C.CString("bb")
}

//export ReturnByteArray
func ReturnByteArray() unsafe.Pointer {
	return C.CBytes([]byte{1, 2, 3})
}

//export GenKeys
func GenKeys() (publicKey, privateKey unsafe.Pointer, err *C.char) {
	publicKey = C.CBytes([]byte{1, 2, 3})
	privateKey = C.CBytes([]byte{4, 5, 6})
	err = C.CString("this is my error")
	return
}

//export SumOf
func SumOf(input unsafe.Pointer) (sum int) {
	var data []byte
	data = C.GoBytes(input, 3)
	sum = 0
	for _, item := range data {
		fmt.Println(item)
		sum += int(item)
	}
	return
}

// required, but not used
func main() {}
