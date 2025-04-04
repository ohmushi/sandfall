package cat.ohmushi;

public class Main {

    public static void main(String[] args) {
        // Create a simulation for a 5x5 grid
        var simulation = new Simulation(new int[5][5]);

        // Add 10 grains of sand to the center
        var newGrid = simulation.addGrainsOfSand(13);

        // Print the result
        System.out.println(newGrid.toString());

        System.out.println(simulation.addGrainsOfSand(3).toString());
    }
}
