## Project KIV/FJP - Compiler for own programming language to PL/0 instruction set

#### Setting up project in IntelliJ
- Open project as usual: File - Open...
- Right click to Grammar file **Exp.g4** and select **Configure ANTLR...**
- Write to text field of **Output directory** and **Imported grammar**: 
>lib
- antlr_runtime library needed for parser and lexer
>src
- In language text field write: 
>Java
- Write to package name: 
>expSources

#### Generating ANTLR classes
Everytime the grammar changes, repeat these steps (atleast the second step)
- Make sure the folder **src/expSources/** is empty by deleting all included files
- Right click to Grammar file **Exp.g4** and select **Generate ANTLR Recogniser** or hit shortcut <kbd>Ctrl</kbd>+<kbd>Shift</kbd>+<kbd>G</kbd>

#### Testing 
- Use class **src/Example.java** as main class for testing
