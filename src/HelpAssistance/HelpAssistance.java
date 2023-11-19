package HelpAssistance;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

public class HelpAssistance {
    // Method for output assistance message
    public static void printHelp(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("GameCLI", options);
    }
}
