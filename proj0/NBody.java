public class NBody {
    private static String background_filename = "images/starfield.jpg";
    public static double readRadius(String file_path){
        In in = new In(file_path);
        int num = in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String file_path){
        In in = new In(file_path);
        int num = in.readInt();
        //System.out.println("Number of planets: " + num);
        double radius = in.readDouble();
        //System.out.println("Universe radius: " + radius);
        Planet[] planets = new Planet[num];
        for(int i = 0; i < num; i++){
            planets[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(),
                    in.readDouble(), in.readDouble(), in.readString());
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.enableDoubleBuffering();

        StdDraw.setScale(-radius, radius);

        double time = 0.0;
        while(time < T){
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for(int i = 0; i < planets.length; i++){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for(int i = 0; i < planets.length; i++){
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.clear();
            //drawing the background
            StdDraw.picture(0, 0, background_filename, 2 * radius, 2 * radius);

            //drawing all of the planets
            for(int i = 0; i < planets.length; i++){
                planets[i].draw();
            }

            StdDraw.show();
            StdDraw.pause(10);

            time += dt;
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for(int i = 0; i < planets.length; i++){
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}
