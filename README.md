# 6502-minifrc-demo
Command-based demos for FRC 6502's 2021 mini FRC competition. Demos for both Java and Kotlin are provided, which should be functionally identical.

These demos are programmed to control a basic open-loop differential drivetrain with one Spark MAX on each side via the sticks on an Xbox One controller. **Please update the Constants file of your project to reflect motor controller CAN IDs before use.**
The control scheme is split-stick arcade, where left Y controls throttle and right X controls turning. The A button also fires off a basic `PrintCommand` to demonstrate tying commands to buttons.

**Do not open this repository itself as a project.**
Instead, open one of the enclosed folders depending on what language you want after copying it out of the root of this repository on your local machine. 
The official WPILib VSCode instance is preferred for Java (but you can use any editor that supports gradle), while IntelliJ is *strongly* recommended for Kotlin.

My personal language recommendation is Kotlin due to its conciseness and nice handling of singletons via `object` (which I use instead of Java's dependency injection paradigm.)
However, if you feel more comfortable with Java, it's still a viable (yet more verbose) option.

If you change the team number in `.wpilib/wpilib_preferences.json`, make sure you set that same number on the driver station and radio.

**As of right now, this code has not been tested on a real robot. If some behavior seems unexpected, please open an issue.**
