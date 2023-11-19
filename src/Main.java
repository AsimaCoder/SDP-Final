import Decorator.IceAttackDecorator;
import Decorator.SmokeAttackDecorator;
import Singleton.GameManager;
import org.apache.commons.cli.*;
import Decorator.FireAttackDecorator;
import Factory.Character;
import Strategy.AttackStrategy;
import Adapter.PowerAdapterFactory;
import Factory.CharacterFactory;
import Observer.ObserverPatternEnabler;
import Strategy.AttackStrategyFactory;
import Strategy.AttackStrategyUser;
import HelpAssistance.HelpAssistance;


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
                ObserverPatternEnabler.enableObserverPattern();
            }

            // Retrieve character and attack type
            String characterType1 = cmd.getOptionValue("character");
            String characterType2 = cmd.getOptionValue("power-adapter");
            String attackType = cmd.getOptionValue("attack");

            // Create the specified character using the factory pattern
            Character character1 = CharacterFactory.createCharacter(characterType1);
            System.out.print("( Partner to use their ability.) ");
            Character character2 = CharacterFactory.createCharacter(characterType2);

            // Create the specified attack strategy using the strategy pattern
            AttackStrategy attackStrategy = AttackStrategyFactory.createAttackStrategy(attackType);

            // Apply decorator if specified
            if (cmd.hasOption("decorator")) {
                switch (characterType1) {
                    case "scorpion":
                        attackStrategy = new SmokeAttackDecorator(attackStrategy);
                        break;
                    case "subzero":
                        attackStrategy = new FireAttackDecorator(attackStrategy);
                        break;
                    case "smoke":
                        attackStrategy = new IceAttackDecorator(attackStrategy);
                        break;
                }
            }

            // Use the specified attack strategy
            AttackStrategyUser.useAttackStrategy(character1, attackStrategy);

            // Use a power adapter if specified
            if (cmd.hasOption("power-adapter")) {
                PowerAdapterFactory.usePowerAdapter(character2);
            }

        } catch (ParseException e) {
            System.err.println("Error parsing command line: " + e.getMessage());
            HelpAssistance.printHelp(options);
        }
    }
}