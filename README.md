<!-- PROJECT SHIELDS -->
<!--
*** Using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
-->
[![Contributors][contributors-shield]][contributors-url]
[![Watchers][watchers-shield]][watchers-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
![README Checker](https://github.com/jasont2022/evil-hangman/workflows/README%20URL%20Checker/badge.svg)
[![Apache License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/jasont2022/evil-hangman">
    <img src="files/troll2.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">Evil-Hangman</h3>

  <p align="center">
    A Hangman game with an evil AI, implemented in the Java programming language
    <br />
    <a href="https://github.com/jasont2022/evil-hangman"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/jasont2022/evil-hangman/issues">Report Bug</a>
    ·
    <a href="https://github.com/jasont2022/evil-hangman/issues">Request Feature</a>
  </p>
</p>

## Table of Contents
* [About](#about)
* [Technologies](#technologies)
* [Features](#features)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
  * [Game Instructions](#game-instructions)
* [Links](#links)
* [Credits](#credits)
* [License](#license)

## About
Instead of a traditional single-player Hangman game, this game involves an evil AI that will "cheat" and make it extremely difficult for the player to win. The AI will cheat during the game by commiting to a set of words instead of a single word. Thus, the AI will gather information based on the character input and calculates steps ahead to beat its opponent, pretty clever and evil. This coding project is an implementation of the Evil Hangman assignment with additional Java Swing GUI. Below has the following technologies and features listed. More details about the Evil Hangman AI can be found by [clicking here](http://nifty.stanford.edu/2011/schwarz-evil-hangman/).

## Technologies
This project is created with the following:

* Java
* Java Swing
* Java I/O
* Java Collections Library
* JUnit 4 \(for testing\)
* Image & Audio files \(linked in [Credits](#credits) section\)

## Features
This project has the following features:

* Save, Load, Reset, and Exit game progress
* Multiple menus such as Main, Help, and Game 
* Play audio and music
* Evilhangman AI
* Custom UI using Java Swing

## Getting Started
Here are the following steps below to get started with the game:

### Prerequisites
Have Java and a Java IDE installed in your computer

### Installation
1. Clone the repo

```bash
$ git clone https://github.com/jasont2022/evil-hangman
$ cd evil-hangman
```
### Game Instructions
To play the game follow the steps below:
1. Run `Game.java` on a Java IDE or on the command line:

   ```bash
   $ javac Game.java
   $ java Game
   ```

2. You should see the following menu once the game is booted:
3. Once the game is loaded please press the "Help" button to read the instructions or read the instructions itself in the `HelpMenu.java` 
4. During the game, there will be audio sounds that are played, which are memes! Yes, there will be memes played during the game. If you don't want to hear the memes, please turn off your volume or comment the code section off in the paintComponent function of the "GameCourt.java" class. More information to play the game can be found in the "HelpMenu.java" class.

## Links
Here is a list of useful links related to the project:

* Repository: http://github.com/jasont2022/evil-hangmanIssue
* Issue tracker: http://github.com/jasont2022/evil-hangman/issues
* Source files: http://github.com/jasont2022/evil-hangman/tree/master/src
* Test files: http://github.com/jasont2022/evil-hangman/tree/master/test

## Credits
This section is to give attribution and many thanks to the following resources listed below:

* Evil Hangman AI Assigment Website: http://nifty.stanford.edu/2011/schwarz-evil-hangman/
  * this website was holds the origin assignment of Evil Hangman made by Keith Schwarz
* Audio samples and music were found in these youtube videos and converted into a wav file format. The original videos containing these memes can be found below: 
  * Meme Sound Effects 1: https://www.youtube.com/watch?v=-1E10Tbsw68
  * Meme Sound Effects 2: https://www.youtube.com/watch?v=wEbSoki-4XA

## License
This repository is released under the [Apache 2.0 License][license-url]. 

```license
Copyright 2020 Jason Tran

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

See `LICENSE.md` or the [Apache website](http://www.apache.org/licenses/LICENSE-2.0) for more information.

<!-- Links -->
[contributors-shield]: https://img.shields.io/github/contributors/jasont2022/evil-hangman.svg?color=brightgreen&style=flat-square
[contributors-url]: https://github.com/jasont2022/evil-hangman/graphs/contributors
[watchers-shield]: https://img.shields.io/github/watchers/jasont2022/evil-hangman?style=flat-square
[watchers-url]: https://github.com/jasont2022/evil-hangman/watchers
[forks-shield]: https://img.shields.io/github/forks/jasont2022/evil-hangman.svg?style=flat-square
[forks-url]: https://github.com/jasont2022/evil-hangman/network/members
[stars-shield]: https://img.shields.io/github/stars/jasont2022/evil-hangman.svg?style=flat-square
[stars-url]: https://github.com/jasont2022/evil-hangman/stargazers
[issues-shield]: https://img.shields.io/github/issues/jasont2022/evil-hangman?color=success&style=flat-square
[issues-url]: https://github.com/jasont2022/evil-hangman/issues
[license-shield]: https://img.shields.io/github/license/jasont2022/evil-hangman?style=flat-square
[license-url]: https://github.com/jasont2022/evil-hangman/blob/master/LICENSE.md
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=flat-square&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/jasontran2022
