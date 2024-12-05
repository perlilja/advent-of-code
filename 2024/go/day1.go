package main

import (
  "bufio"
  "fmt"
  "os"
  "sort"
	"strconv"
  "strings"
)

func main() {
  file, err := os.Open("day1_1.input")
  
  if err != nil {
    fmt.Println("Error opening file: ", err)
    return
  }

  defer file.Close()
  
  var leftColumn, rightColumn []int

  scanner := bufio.NewScanner(file)
  for scanner.Scan() {
    line := scanner.Text()
    
    parts := strings.Fields(line)

    if len(parts) != 2 {
      fmt.Println("Invalid line formats:", line)
      continue
    }

    leftVal, err1 := strconv.Atoi(parts[0])
    rightVal, err2 := strconv.Atoi(parts[1])

    if err1 != nil || err2 != nil {
      fmt.Println("Error parsing line: ", line)
    }

    leftColumn = append(leftColumn, leftVal)
    rightColumn = append(rightColumn, rightVal)
  }

  // Check for scanner errors
	if err := scanner.Err(); err != nil {
		fmt.Println("Error reading file:", err)
		return
	}

	// Sort the columns
	sort.Ints(leftColumn)
	sort.Ints(rightColumn)

  // Part one

  sumDiff := 0
  occurances := make(map[int]int)
  for i := 0; i < len(leftColumn) && i < len(rightColumn); i++ {
    diff := leftColumn[i] - rightColumn[i]

    if diff < 0 {
      diff = -1*diff
    }

    sumDiff += diff
  }

  fmt.Println("Sum of differences:", sumDiff)

  for _, lnum := range leftColumn {
    for _, rnum := range rightColumn {
      if lnum == rnum {
        occurances[lnum]++
      }
    }
  }

  similaryScore := 0
  for key, value := range occurances {
    similaryScore += key*value
    fmt.Println(strconv.Itoa(key) + " " + strconv.Itoa(value))
  }

  fmt.Println("Similarity score:", similaryScore)

}  
