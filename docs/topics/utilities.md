# Utility Classes

## Overview

**11 files** in `com/util/` providing helper utilities for arrays, printing, graph construction, file I/O, and benchmarking.

## Core Utilities

### ArrayUtil (`com/util/ArrayUtil.java`)
```java
// Core operations:
static void swap(int[] arr, int i, int j)
static int max(int[] arr)
static int min(int[] arr)
static int[] copy(int[] arr)
// Stack/List builders for test case creation
```

### PrintUtl (`com/util/PrintUtl.java`)
Extensive printing utilities for debugging:
```java
// Single arrays:
static void print(int[] arr)           // [1, 2, 3]
static void print(int[][] matrix)      // formatted 2D
// Linked Lists:
static void print(Node head)           // 1 → 2 → 3 → null
// Trees:
static void print(TNode root)          // level-order display
static void printGraphicalTree(TNode root)  // visual tree
static void printInOrder/preOrder/postOrder(TNode root)
```

### GraphUtil (`com/util/GraphUtil.java`)
Graph construction and conversion:
```java
// Convert between adjacency matrix ↔ adjacency list ↔ edge list
// Parse graph from input strings (competitive programming format)
// AdjacencyListBuilder: fluent API for building graphs
```

### FileUtil (`com/util/FileUtil.java`)
File-based I/O for competitive programming:
```java
// Redirect stdin/stdout to files
// Auto-detection of test files from class names
```

## Deprecated Utilities (`com/util/deprecated/`)

| Class | Purpose |
|-------|---------|
| `Logger.java` | Simple logging with levels |
| `OnlineJudge.java` | Annotation marker for judge problems |
| `OnlineJudgeInit.java` | Auto-detect test files from class name |
| `Pair.java` | Generic `Pair<T1, T2>` |
| `Triplet.java` | Generic `Triplet<T1, T2, T3>` |
| `SpaceUtil.java` | Tabular output formatting |
| `TimeCheck.java` | Execution time measurement |
