package main

import "C"

//export Multiply
func Multiply(x int64, y int64) int64 {
	return x * y
}

// required, but not used
func main() {}
