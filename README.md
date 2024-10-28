# Mini Text Editor

This project is a mini text editor built as part of the TP2 Object-Oriented Design course, focusing on basic text editing and command management functionalities in an object-oriented structure.

## Objectives

The main objectives of this project are:
- To present a simple approach to object-oriented design and programming.
- To demonstrate different means of object coordination.
- To build both static and dynamic UML diagrams in parallel.
- To implement design patterns effectively.
- To transition from design models to actual code.

## Tools Used

- **Modeling Tool**: DotUML
- **IDE**: VSCode

## Project Overview

The goal of the project is to build a mini text editor that includes the following concepts and functions:
- A text buffer as a workspace.
- Text selection, with commands to adjust the start and end positions of the selection.
- Copying the selection to the clipboard.
- Cutting the selection, copying it to the clipboard, and deleting it from the buffer.
- Replacing the selected text with the contents of the clipboard.

The user interface can be either text-based or graphical.

## Versions and Features

The project was developed in two incremental versions, as follows:

### Version 1: Basic Text Editing Functions

The first version focused on implementing fundamental editing functionalities:

- **Text Buffer**: A buffer that holds the current text, serving as the workspace.
- **Text Selection**: Commands to select a portion of text by setting start and end positions.
- **Copy and Cut Commands**: The user can copy or cut the selected text to the clipboard. Cutting also removes the selected text from the buffer.
- **Paste Command**: The content in the clipboard can be pasted into the buffer, replacing the current selection.

In this version, the **Command Pattern** was implemented to manage editing commands like copy, cut, paste, and add. Each command (e.g., `CopyCommand`, `CutCommand`, `PasteCommand`) extends the `Command` interface with `execute()` method, allowing seamless management of each action.

### Version 2: Recording, Replay, and Undo/Redo Functionality

The second version extended the editor with additional functionalities:

1. **Recording and Replay**: 
   - Implemented a `ReplayCommand` to record a series of commands executed by the user. 
   - The replay function replays all recorded commands, allowing a script-like automation.

2. **Undo and Redo with History**:
   - An **Undo/Redo** feature with a history buffer was added, enabling the user to undo any previous actions back to the initial state or redo them after undoing.
   - `CommandHistory` was introduced to manage this history and supports reversing or reapplying commands up to a defined capacity.

## Installation and Usage

1. **Clone** the repository from GitLab.
2. **Compile and Run** the project in your Java IDE (Eclipse, VSCode).
3. **Use the Console** to enter commands as prompted to edit the text buffer interactively.

## Submission Details

The project files (V1 and V2), UML diagrams, and a detailed developer's report with workspace descriptions for each iteration are available in the GitLab repository.
# td2-omd
Mini Text Editor in Java
