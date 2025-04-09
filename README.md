# SandFall Simulation

A Java implementation of a cellular automaton simulating sand avalanches.

## Overview

SandFall simulates the behavior of sand piles on a grid, where each cell can hold up to a maximum of 3 sand grains. When a cell exceeds its capacity, it "topples" and distributes its sand to neighboring cells, potentially causing a chain reaction.

## Getting Started

### Prerequisites

- Java 21+
- Maven

### Building the Project

```bash
mvn clean install
```

### Running the project

```bash
mvn exec:java
```

## Usage

Here's a simple example of how to use the SandFall class:

```java
// Create a simulation for a 5x5 grid
var simulation = new Simulation(new int[5][5]);

// Add 13 grains of sand to the center
var newGrid = simulation.addGrainsOfSand(13);

// Print the result
System.out.println(newGrid.toString());

// [0, 0, 1, 0, 0]
// [0, 2, 1, 2, 0]
// [1, 1, 0, 1, 1]
// [0, 2, 1, 2, 0]
// [0, 0, 1, 0, 0]
```

## Code Architecture

- **Main**: Main public class with an exemple
- **Direction**: Enum representing the four directions
- **Position**: Immutable class representing a position on the grid
- **Grid**: Encapsulates the state of the sand pile
- **SandSimulation**: Manages the simulation logic

## Algorithm

The sand distribution algorithm works as follows:

1. A grain of sand is added to the center of the grid
2. If a cell exceeds its capacity (3 grains):
   - The cell resets to 0
   - Each of its four neighbors receives one grain
3. This process continues until no cell exceeds its capacity

The implementation uses a queue-based iterative approach for performance and to avoid stack overflow issues with recursive solutions.
