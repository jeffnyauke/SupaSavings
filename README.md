# Supa Savings

Supa Savings is an Android application designed to help users systematically save money over a period of 52 weeks. By starting with a predefined minimum amount, the app helps users incrementally save more each week, ensuring a structured and easy-to-follow savings plan.

## Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Screenshots](#screenshots)
- [Architecture](#architecture)
- [Setup](#setup)
- [Usage](#usage)
- [Tests](#tests)
- [Contributing](#contributing)
- [License](#license)

## Project Overview

Supa Savings is built using modern Android development practices, including Jetpack Compose for the UI, ViewModel for handling UI-related logic, and kotlinx.datetime for date manipulation. The application calculates weekly savings based on a starting amount, increments the savings each week, and displays the total savings accumulated over the 52 weeks.

## Features

- User-defined starting savings amount.
- Automatic calculation of weekly and total savings.
- Easy-to-read, tabular display of savings with week numbers, dates, and amounts.
- TopAppBar with the title "Supa Savings".
- Ensures a minimum saving of 50 on week 1.
- Intuitive and user-friendly interface designed with Jetpack Compose.

## Screenshots

![App Icon](/screenshots/screenshot0.png?raw=true "App Icon")
![Loading](/screenshots/screenshot1.png?raw=true "Loading")
![Home Screen](/screenshots/screenshot2.png?raw=true "Home Screen")
![Home Screen - Changed Amount](/screenshots/screenshot3.png?raw=true "Home Screen - Changed Amount")

## Architecture

The project is organized into the following layers:

- **Domain**: Contains business logic and data manipulation classes.
- **Presentation**: Contains UI components built using Jetpack Compose, ViewModel for state management, and related UI logic.

## Setup

1. Clone the repository:

    ```sh
    git clone https://github.com/jeffnyauke/SupaSavings.git
    cd supa-savings
    ```

2. Open the project in Android Studio.

3. Build the project to ensure all dependencies are installed.

    ```sh
    ./gradlew build
    ```

4. Run the project on an emulator or physical device.

## Usage

1. Launch the Supa Savings app.
2. Enter your desired starting amount in the "Starting Amount" text field.
3. The list will automatically update, displaying weekly savings amounts, dates, and total savings accumulated.

## Tests

### Unit Tests

Unit tests are included for the business logic in the domain layer. To run the unit tests:

```sh
./gradlew test
```

### UI Tests

UI tests are written using the AndroidX Test library for Jetpack Compose. To run the UI tests:

```sh
./gradlew connectedAndroidTest
```

## Contributing

We welcome contributions from the community. To contribute:

1. Fork the repository.
2. Create your feature branch `(git checkout -b feature/MyFeature)`.
3. Commit your changes `(git commit -m 'Add some feature')`.
4. Push to the branch `(git push origin feature/MyFeature)`.
5. Create a new Pull Request.

## License

This project is licensed under the MIT License - see the [license](LICENSE) file for details.
