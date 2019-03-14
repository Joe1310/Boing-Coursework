
/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author you
 *
 */

import javafx.scene.paint.Color;
import java.io.*;
import java.util.Scanner;

public class ReadShapeFile {

	// TODO: You will likely need to write four methods here. One method to
	// construct each shape
	// given the Scanner passed as a parameter. I would suggest static
	// methods in this case.

	/**
	 * Reads the data file used by the program and returns the constructed queue
	 * 
	 * @param in
	 *            the scanner of the file
	 * @return the queue represented by the data file
	 */
	private static Queue<ClosedShape> readDataFile(Scanner in) {
        Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();

        while (in.hasNextLine()) {
            String row = in.nextLine();
            Scanner shapeScan = new Scanner(row);

            String type = shapeScan.next();
            int px = Integer.parseInt(shapeScan.next());
            int py = Integer.parseInt(shapeScan.next());

            int vx = Integer.parseInt(shapeScan.next());
            int vy = Integer.parseInt(shapeScan.next());

            boolean filled = Boolean.parseBoolean(shapeScan.next());
            Color rgb = Color.rgb(Integer.parseInt(shapeScan.next()),
                    Integer.parseInt(shapeScan.next()),
                    Integer.parseInt(shapeScan.next()));

            int time = Integer.parseInt(shapeScan.next());

            switch (type){

                case("circle"):
                    int diameter = Integer.parseInt(shapeScan.next());
                    Circle circle = new Circle(time, px, py, vx, vy, diameter, rgb, filled);
                    shapeQueue.enqueue(circle);
                    System.out.println(circle.toString());
                    break;

                case("oval"):
                    int width = Integer.parseInt(shapeScan.next());
                    int height = Integer.parseInt(shapeScan.next());
                    Oval oval = new Oval(time, px, py, vx, vy, width, height, rgb, filled);
                    shapeQueue.enqueue(oval);
                    System.out.println(oval.toString());
                    break;

                default:
                    System.out.println("An error has occurred");
                    System.exit(0);
                    return null;

            }
            //read in the shape files and place them on the Queue

            //Right now, returning an empty Queue.  You need to change this.

        }
        return shapeQueue;
    }





	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 * 
	 * @param filename
	 *            the name of the file
	 * @return the queue of shapes from the file
	 */
	public static Queue<ClosedShape> readDataFile(String filename) {
	    // HINT: You might want to open a file here.
        File f = new File(filename);
        try {
            Scanner fileScan = new Scanner(f);
            return ReadShapeFile.readDataFile(fileScan);
        }catch(Exception e){
                System.out.println("Error reading file.");
                System.exit(0);
                return null;
            }

	}

}
