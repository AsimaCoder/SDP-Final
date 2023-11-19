import Decorator.IceAttackDecorator;
import Decorator.SmokeAttackDecorator;
import Singleton.GameManager;
import org.apache.commons.cli.*;
import Adapter.PowerAdapter;
import Adapter.PowerAdapterImpl;
import Decorator.FireAttackDecorator;
import Factory.Character;
import Factory.Scorpion;
import Factory.Smoke;
import Factory.SubZero;
import Observer.ConsoleObserver;
import Observer.GameNotifier;
import Strategy.AttackStrategy;
import Strategy.BasicAttack;
import Strategy.SpecialAttack;

import java.util.Objects;


public class Main {
    public static void main(String[] args) {

        // Create Options object to be able to work with CLI
        Options options = new Options();

        // Name of the Username
        Option nameOption = Option.builder("n")
                .longOpt("name")
                .desc("Specify the name of the user")
                .hasArg()
                .argName("name")
                .required()
                .build();

        // Choose the character
        Option characterOption = Option.builder("c")
                .longOpt("character")
                .desc("Specify the character (Scorpion, SubZero, Smoke)")
                .hasArg()
                .argName("character")
                .required()
                .build();

        // Choose type of attack
        Option attackOption = Option.builder("a")
                .longOpt("attack")
                .desc("Specify the attack type (basic, special)")
                .hasArg()
                .argName("attack")
                .required()
                .build();

        // Decorate the attack
        Option decoratorOption = Option.builder("d")
                .longOpt("decorator")
                .desc("Apply a decorator to the attack")
                .build();

        // Use additional power of other character
        Option powerAdapterOption = Option.builder("p")
                .longOpt("power-adapter")
                .desc("Use a power adapter to enable another character's power")
                .hasArg()
                .argName("character")
                .required()
                .build();

        // To enable notification for observers
        Option observerOption = Option.builder("o")
                .longOpt("observer")
                .desc("Enable observer pattern")
                .build();

        // Implementation

        options.addOption(nameOption);
        options.addOption(characterOption);
        options.addOption(attackOption);
        options.addOption(decoratorOption);
        options.addOption(powerAdapterOption);
        options.addOption(observerOption);

        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine cmd = parser.parse(options, args);

            // Retrieve user name
            String userName = cmd.getOptionValue("name");
            GameManager.getInstance().setUserName(userName);

            // Print the username
            System.out.println("---------------------------------------------------------");
            System.out.println("User Name: " + userName);
            System.out.println("---------------------------------------------------------");

            // Enable observer pattern if specified
            if (cmd.hasOption("observer")) {
                enableObserverPattern();
                System.out.println("---------------------------------------------------------");
            }

            // Retrieve character and attack type
            String characterType1 = cmd.getOptionValue("character");
            String characterType2 = cmd.getOptionValue("power-adapter");
            String attackType = cmd.getOptionValue("attack");

            // Create the specified character using the factory pattern
            Character character1 = createCharacter(characterType1);
            System.out.print("( Partner to use their ability.) ");
            Character character2 = createCharacter(characterType2);

            // Create the specified attack strategy using the strategy pattern
            AttackStrategy attackStrategy = createAttackStrategy(attackType);

            // Apply decorator if specified
            if (cmd.hasOption("decorator")) {
                if(Objects.equals(characterType1, "scorpion")){
                    attackStrategy = new SmokeAttackDecorator(attackStrategy);
                } else if (Objects.equals(characterType1, "subzero")) {
                    attackStrategy = new FireAttackDecorator(attackStrategy);
                } else if (Objects.equals(characterType1, "smoke")){
                    attackStrategy = new IceAttackDecorator(attackStrategy);
                }

            }



            // Use the specified attack strategy
            useAttackStrategy(character1, attackStrategy);

            // Use a power adapter if specified
            if (cmd.hasOption("power-adapter")) {
                usePowerAdapter(character2);
            }

        } catch (ParseException e) {
            System.err.println("Error parsing command line: " + e.getMessage());
            printHelp(options);
        }
    }


    // Method for creating characters
    private static Character createCharacter(String characterType) {
        switch (characterType.toLowerCase()) {
            case "scorpion":
                System.out.println("Created character: Scorpion.");
                System.out.println("---------------------------------------------------------");
                return new Scorpion();
            case "subzero":
                System.out.println("Created character: SubZero.");
                System.out.println("---------------------------------------------------------");
                return new SubZero();
            case "smoke":
                System.out.println("Created character: Smoke.");
                System.out.println("---------------------------------------------------------");
                return new Smoke();
            default:
                throw new IllegalArgumentException("Invalid character type. Supported types: scorpion, subzero, smoke");
        }
    }

    // Method for creating type of attack
    private static AttackStrategy createAttackStrategy(String attackType) {
        switch (attackType.toLowerCase()) {
            case "basic":
                return new BasicAttack();
            case "special":
                return new SpecialAttack();
            default:
                throw new IllegalArgumentException("Invalid attack type. Supported types: basic, special");
        }
    }

    // Method for using other character's attack
    private static void usePowerAdapter(Character character) {
        PowerAdapter powerAdapter = new PowerAdapterImpl(character);
        powerAdapter.usePower();
    }


    // Method for enabling notification
    private static void enableObserverPattern() {
        // Create a GameNotifier and add an observer
        GameNotifier gameNotifier = new GameNotifier();
        gameNotifier.addObserver(new ConsoleObserver());
        gameNotifier.notifyObservers(GameManager.getInstance().getUserName());
    }

    // Method for output of character and their attack
    private static void useAttackStrategy(Character character, AttackStrategy attackStrategy) {
        // Set the attack strategy for the character
        // For simplicity, just print the character's attack
        System.out.println("Performance: ");
        character.performAttack();
        System.out.print("Range: ");
        attackStrategy.rangeOfAttack();
    }

    // Method for output assistance message
    private static void printHelp(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("GameCLI", options);
    }
}