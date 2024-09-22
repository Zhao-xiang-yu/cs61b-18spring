import synthesizer.GuitarString;

public class GuitarHero {
    private static int KEYSNUM = 37;
    private GuitarString[] guitarStrings;
    private static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    public GuitarHero() {
        guitarStrings = new GuitarString[KEYSNUM];
        for (int i = 0; i < KEYSNUM; i += 1) {
            double frequency = 440 * Math.pow(2, (i - 24) / 12.0);
            guitarStrings[i] = new GuitarString(frequency);
        }
    }

    public void play() {
        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int keyDex = keyboard.indexOf(key);
                if (keyDex >= 0) {
                    guitarStrings[keyDex].pluck();
                }
            }

            double sample = 0.0;
            for (int i = 0; i < KEYSNUM; i += 1) {
                sample += guitarStrings[i].sample();
            }

            StdAudio.play(sample);

            for (int i = 0; i < KEYSNUM; i += 1) {
                guitarStrings[i].tic();
            }
        }
    }

    public static void main(String[] args) {
        GuitarHero guitarHero = new GuitarHero();
        guitarHero.play();
    }

}
