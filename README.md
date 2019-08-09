# my-java-demos
This repository contains Java classes implementing some of the Java coding problems, data structures, recursion, search and sort algorithms etc.

# Table of Contents
## [Data Structures](./src/main/java/com/ppk/datastructures)
- [BinarySeachTree](./src/main/java/com/ppk/datastructures/BinarySeachTreeDemo.java)

## [Recursion Examples](./src/main/java/com/ppk/recursion)
- [Tower of Hanoi](./src/main/java/com/ppk/recursion/TowerOfHanoiDemo.java)
- [Word Break Problem](./src/main/java/com/ppk/recursion/WordBreakProblemDemo.java)

## [Sorting Algorithms](./src/main/java/com/ppk/sorting) 
- [Bubble Sort](./src/main/java/com/ppk/sorting/BubbleSortDemo.java)
- [Selection Sort](./src/main/java/com/ppk/sorting/SelectionSortDemo.java)
- [Insertion Sort](./src/main/java/com/ppk/sorting/InsertionSortDemo.java)
- [Merge Sort](./src/main/java/com/ppk/sorting/MergeSortDemo.java)
- [Quick Sort](./src/main/java/com/ppk/sorting/InsertionSortDemo.java)
- [Heap Sort](./src/main/java/com/ppk/sorting/HeapSortDemo.java)

## [Coding Problems](./src/main/java/com/ppk/problems)
### [Arrays](./src/main/java/com/ppk/problems/arrays)
- [Pair with minimum absolute difference from two arrays](./src/main/java/com/ppk/problems/arrays/PairWithMinDifference.java)

# Test Cases
The repository also contains JUnit test cases for some of the example above.

#### Parameterized Tests -
Especially note the [Parameterized](https://github.com/junit-team/junit4/wiki/Parameterized-tests) test examples [here](./src/test/java/com/ppk/problems/arrays/PairWithMinDifferenceParameterizedTests.java).

- Add the `@RunWith` annotation to use the `Parameterized.class`.
- Add a `public static` method which returns the parameters which will be injected using the parameterized constructor
- Add member variables to hold the parameters in the Test class and initialize them in the parameterized constructor

# Java Code Coverage
Code Coverage is a metric that measures what percentage of your code has been executed during unit and integration tests.
I have also added the [Java Code Coverage](https://www.eclemma.org/jacoco/trunk/doc/maven.html) Maven plugin to make sure we write test cases for a minimum of 80% coverage ratio. You can find JaCoCo report in the `target/site/jacoco` directory in your project.

We can remove the packages from the exclusion list as and when new test cases are added to cover all the examples.
