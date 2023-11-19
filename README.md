# SE-2216 Game System Project

## Group: SE-2216

### Team Members:
- Myrzabai Asima
- Rasul Aralbayev
- Daulet Kuttybaev

## Project Overview
This project is a game system analogous to Mortal Kombat. Players can choose from characters such as Scorpion, Sub-Zero, and Smoke, and utilize their unique abilities. The game allows for the combination of these abilities, offering a dynamic and engaging experience.

## Purpose of the Project
The primary purpose is to create a versatile and interactive game system that allows players to control and manage various character abilities, similar to other fighting games, but with unique features and gameplay.

## Objectives
- To develop a game with clear and manageable abilities and objectives.
- Implement design patterns effectively to enhance the gaming experience.
- Provide a user-friendly command-line interface for gameplay.

## Features
- Character selection: Scorpion, Sub-Zero, and Smoke.
- Unique abilities for each character with the option to combine them.
- Implementation of design patterns such as Observer, Decorator, Factory, Singleton, and Strategy.

## Project Structure
The project is structured with a main class for initializing the game and separate classes for each character and their abilities. 

## How to Run
Instructions on running the game will be provided, ensuring easy access for users.

## UML Diagrams
UML Diagrams illustrating the project structure and design patterns are included.

## Conclusion
The project successfully creates a dynamic game system, incorporating various design patterns for a structured and engaging gameplay experience.

## Future Improvements
- Expanding the character roster and interaction capabilities.
- Integrating a database for personalized experiences and detailed character attributes.
- Enhancing game features for a more immersive and extensive experience.

## Design Patterns Used
- Observer: For notifying changes in game state.
- Decorator: For combining character abilities.
- Factory: For creating character instances.
- Singleton: Ensuring a single instance of a critical game component.
- Strategy: For varying the algorithm of character abilities.

# SDP-Final
# Game System

![RPG Logo](link_to_logo.png)

## Group: SE-2216

### Team Members:
- Myrzabai Asima 
- Rasul Aralbayev
- Daulet Kuttybaev

## Project Overview

Welcome to our RPG Game System, an immersive console-based adventure where heroes battle fierce enemies using a combination of unique abilities, intense weapons, and strategic maneuvers. This project is a showcase of design patterns, including Factory, Singleton, Decorator, Strategy, Observer, and Command, demonstrating their application in a real-world game scenario.

## Purpose of the Project

The RPG Game System aims to provide an engaging and extensible framework for building role-playing games. Through the implementation of various design patterns, we offer a flexible and scalable architecture that allows for easy integration of new features, heroes, and game mechanics.

## Objectives

1. Implement a variety of heroes with distinct attributes and abilities using the Factory pattern.
2. Manage intensity levels globally with the Singleton pattern for a consistent gaming experience.
3. Enhance hero capabilities dynamically by decorating them with different weapons using the Decorator pattern.
4. Define diverse attack strategies for heroes using the Strategy pattern for strategic gameplay.
5. Notify and react to in-game events with the Observer pattern for a dynamic and responsive gaming environment.
6. Encapsulate and execute user actions through the Command pattern for an interactive gaming experience.

## Features

- Hero Selection: Choose from a diverse cast of heroes, each with its own set of unique abilities and strengths.

- Intensity Levels: Experience varying levels of intensity throughout the game, affecting the overall challenge.

- Weapon Enhancements: Equip heroes with different weapons, each providing distinct advantages in combat.

- Attack Strategies: Strategically plan your attacks by choosing from a variety of attack strategies.

- Observer Events: Stay informed about in-game events that impact your hero's journey through the Observer pattern.

- Command Execution: Take control of your hero by executing commands that influence the outcome of battles.

## Project Structure

The project is organized into modular components, following SOLID principles for clean, maintainable code. Below are the key components:

- HeroFactory: Creates different types of heroes.
- IntensityManager: Manages global intensity levels.
- WeaponDecorator: Enhances hero attacks with different weapons.
- AttackStrategy: Defines various attack strategies.
- Observer: Handles game event notifications.
- Command: Encapsulates user actions.

## How to Run

1. Clone the repository to your local machine.
2. Open the project in your preferred Java IDE.
3. Run the Game class to start the RPG adventure.

## UML Diagrams

![UML Diagram](link_to_uml_diagram.png)

For a detailed view of the project's structure and relationships between classes, refer to the UML diagrams provided in the repository.

## Conclusion

In conclusion, the RPG Game System successfully integrates multiple design patterns, offering a rich and dynamic gaming experience. We've faced challenges, learned valuable lessons, and are excited about the potential for future improvements.

## Future Improvements

- Expand the roster of heroes with new classes and abilities.
- Introduce more diverse weapons and their effects on gameplay.
- Enhance the battle system with additional features, such as special attacks and defenses.

Thank you for exploring our RPG Game System! We hope you enjoy the adventure as much as we enjoyed creating it.
