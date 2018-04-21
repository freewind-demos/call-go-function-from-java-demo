package main

// formatter: off
import "C"
// formatter: on

//export Multiply
func Multiply(x int64, y int64) int64 {
	return x * y
}

// required, but not used
func main() {}
