# SE-2216 Game System Project ![Game Badge](https://img.shields.io/badge/Game-SE2216-blue.svg)

## Group: SE-2216 🌟

### Team Members
| Name             | Role        |
| ---------------- | ----------- |
| Myrzabai Asima   | Developer   |
| Rasul Aralbayev  | Developer   |
| Daulet Kuttybaev | Developer   |

## Project Overview 🎮
</br>
The Mortal Combat Game System is a Java-based project aimed at delivering an immersive gaming experience with a focus on the renowned Mortal Kombat theme. This initiative revolves around creating a dynamic gaming platform where users can select and control their chosen hero, each endowed with unique abilities, within a virtual combat environment. </br>
</br>
The core idea is to establish a robust gaming framework that enables users to engage in dynamic battles by choosing characters from the Mortal Kombat universe. This not only allows players to explore the distinctive abilities of each hero but also adds strategic depth and excitement to the overall gaming experience.</br>
</br>
The primary purpose of this project is to enhance the usability and clarity of the gaming system. By developing an intuitive interface and implementing efficient controls, the Mortal Combat Game System aims to streamline the user experience, making it accessible and enjoyable for both novice and experienced gamers.</br>
</br>
Key objectives include implementing a user-friendly interface for character selection and abilities, creating an interactive gaming environment with smooth and responsive controls, enhancing usability through simplified mechanics and tutorials, introducing elements for strategic depth in gameplay, and incorporating user feedback for continuous improvement.</br>

## Main Body

Adapter:

![Adapter](https://github.com/AsimaCoder/SDP-Final/assets/129418969/43c33ff4-52ab-4228-aab2-3a6e9e745b5d)

Adapter is a structural design pattern that allows objects with incompatible interfaces to collaborate.
 In our project it plays the role that connects two different characters and enables one character's abilities to another.
 
public class PowerAdapterImpl implements PowerAdapter {
    private final Character character;


    // Takes any character
    public PowerAdapterImpl(Character character) {
        this.character = character;
    }


    // Uses their power
    @Override
    public void usePower() {
        System.out.println("---------------------------------------------------------");
        character.performAttack();
    }
}

Decorator:
![Decorator](https://github.com/AsimaCoder/SDP-Final/assets/129418969/000ff32a-4361-45b7-8446-ce686a9f96e0)

Decorator is a structural design pattern that lets you attach new behaviors to objects by placing these objects inside special wrapper objects that contain the behaviors. In our project it provides additional ability to the character.

public class FireAttackDecorator implements AttackDecorator {
    private final AttackStrategy decoratedStrategy;

    public FireAttackDecorator(AttackStrategy decoratedStrategy) {
        this.decoratedStrategy = decoratedStrategy;
    }

    // Decorate any attack with fire ability
    @Override
    public void rangeOfAttack() {
        decoratedStrategy.rangeOfAttack();
        System.out.println("---------------------------------------------------------");
        System.out.println("Adds fire damage!");
    }
}

Factory:
![Factory](https://github.com/AsimaCoder/SDP-Final/assets/129418969/9e1d6308-b9b9-49a3-a869-1a430eb39dfc)

Factory Method is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created. In our project it allows user to choose the charater and enables them to create that character.

public class CharacterFactory {
    public static Character createCharacter(String characterType) {
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
}


Observer:
![Observer](https://github.com/AsimaCoder/SDP-Final/assets/129418969/41775af2-59da-49a5-96d5-813efcb4af08)

Observer is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing. In our code it allows the observes to be notified who entered the game and what is their name.

public class GameNotifier implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    // Add observer

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Remove observer

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Notify Observers

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}


Singleton:
![Singleton](https://github.com/AsimaCoder/SDP-Final/assets/129418969/3f968c8e-1a31-4f32-b3ba-a992979ba80f)

Singleton is a creational design pattern that lets you ensure that a class has only one instance, while providing a global access point to this instance. In our project ot ensures that there is only one game manager.

public class GameManager {
    private static GameManager instance;
    private String userName;

    private GameManager() {
        // Private constructor to prevent instantiation
    }

    // Single instance implementation
    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    // Get Username

    public String getUserName() {
        return userName;
    }

    // Set Username
    public void setUserName(String userName) {
        this.userName = userName;
    }

}

Strategy:
![Strategy](https://github.com/AsimaCoder/SDP-Final/assets/129418969/01eb8d95-b801-4dbb-9fc4-aa23c2785c4a)

Strategy is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable. in our project it allows user to change the abilities of the character.

public class AttackStrategyFactory {
    public static AttackStrategy createAttackStrategy(String attackType) {
        switch (attackType.toLowerCase()) {
            case "basic":
                return new BasicAttack();
            case "special":
                return new SpecialAttack();
            default:
                throw new IllegalArgumentException("Invalid attack type. Supported types: basic, special");
        }
    }
}


## Features 🚀

- **Character Selection**: Choose from a variety of characters, each with unique abilities. ![Character Badge](https://img.shields.io/badge/Characters-3-green.svg)
- **Dynamic Gameplay**: Real-time ability evolution and adaptive opponents.
- **Immersive Environments**: Battlefields that react and change dynamically.
- **Cross-Platform Play**: Play with friends, no matter their device.

<details>
<summary><strong>Purpose of the Project</strong></summary>
We aim to revolutionize the fighting game genre by blending advanced technology with innovative gameplay mechanics. Our mission is to create a game that's not only fun to play but also technically and visually impressive.
</details>

<details>
<summary><strong>Objectives</strong></summary>

- Develop a game with clear, manageable objectives and abilities.
- Implement cutting-edge technology for an enhanced gaming experience.
- Ensure a user-friendly interface for seamless gameplay interaction.
</details>

## How to Run 🖥️
**Required JDK**: JDK 21.0.1
Follow these steps to set up the project:

1. Open your terminal.
2. Clone the repository:
```bash
git clone https://github.com/AsimaCoder/SDP-Final.git
# Navigate to the project directory
cd SE-2216-Game-System
```
3. In IntelliJ IDEA, navigate to Main.java.
4. Run Main.java to start the game.
## UML Diagrams 📊

> UML Diagrams are provided to offer insights into the architectural design of the game. These diagrams are essential for understanding the interactions between different components of the system.

![UML Diagram](https://img.shields.io/badge/UML-Diagram-blueviolet.svg)
## Design Patterns Used 🛠️

- **Observer**: For real-time notifications and updates.
- **Decorator**: Enhancing character abilities dynamically.
- **Factory**: Efficient character creation and management.
- **Singleton**: Ensuring a single instance of a critical game component.
- **Strategy**: For flexible gameplay mechanics and character strategies.
- **Adapter**: Facilitating interaction between incompatible components of the game system.



---
## Conclusion 🏁

The Mortal Combat Game System has triumphantly achieved its key objectives, introducing a rich gaming experience that encompasses user creation, character customization, and development of unique abilities. This success is attributed to the innovative use of the Decorator and Adapter patterns.

### Key Points of the Project 🔑

- **User and Character Creation**: The project has successfully implemented a robust system for user and character creation, prioritizing customization. This feature empowers players to craft a gaming experience tailored to their preferences and playstyles.
- **Decorator Pattern for Abilities**: Leveraging the Decorator pattern, the project introduced a novel approach to constructing character abilities. This implementation ensures a dynamic and customizable array of skills, adding depth and personalization to the gaming experience.
- **Adapter Pattern for Combat Versatility**: The use of the Adapter pattern seamlessly integrates various abilities, providing players with a versatile toolkit for combat scenarios. This enhances strategic possibilities and diversifies gameplay.

### Challenges Faced 😓

- **Project Scale**: The development team successfully navigated challenges associated with the project's ambitious scale. Issues related to project complexity and the integration of a user-friendly command line interface were effectively addressed, resulting in a functional and engaging gaming system.
- **User-Friendly Command Line Interface**: Implementing an intuitive command line interface was challenging, especially with the integration of the Option object in the main class. These challenges were successfully navigated to ensure a seamless user experience.
- **Managing Complexity**: One of the significant challenges was managing the intricacies of a large-scale project. The successful resolution of this challenge reflects the team's adeptness in planning and execution
- **Integration of Option Object**; Addressing issues related to integrating the Option object in the main class required meticulous attention. The team's ability to navigate this challenge contributed to a smooth and cohesive user experience.

### Future Improvements 🌈

- **Character Expansion**: More characters with unique abilities.
- **Enhanced Multiplayer**: Global competitive modes.
- **GUI Enhancement**: Developing a user-friendly graphical interface for improved gameplay interaction.

---
## References

- [Adapter Pattern](https://refactoring.guru/design-patterns/adapter)
- [Decorator Pattern](https://refactoring.guru/design-patterns/decorator)
- [Factory Pattern](https://refactoring.guru/design-patterns/factory-method)
- [Observer Pattern](https://refactoring.guru/design-patterns/observer)
- [Singleton Pattern](https://refactoring.guru/design-patterns/singleton)
- [Strategy Pattern](https://refactoring.guru/design-patterns/strategy)


---

### Show your support

Give a ⭐️ if this project helped or inspired you!
