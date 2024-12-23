# Project Reflection

- *How can I ensure that my code, program, or software is functional and
secure?*

To ensure that my code/program both works as intended and is secure, I used the
testing automation framework **JUnit** to create unit tests that test for
functionality and various edge cases. The tests I created were focused on
validating all the required functionalities such as adding, updating, and
deleting records. Exception handling and boundary testing were the main methods
used in discovering edge cases to ensure the system handles errors gracefully.

- *How do I interpret user needs and incorporate them into a program?*

Interpreting user needs and incorporating them into a program means analyzing
the requirements and translating them into features. For example, one of the
requirements was to include a constraint of a 10-character limit for both IDs
and phone numbers. This directly matches the user's expectations and improves
the simplicity and reliability of the system as a whole.

- *How do I approach designing software?*

Because of the relatively simple requirements of this project, I focused on
simplicity and maintainability. This approach also allowed for the program to be
easily testable and extendable. An example of this is the ContactService class,
which has very simple and clear responsibilities and methods to match.
