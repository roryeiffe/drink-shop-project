# HELP! The developers forgot to document and test this application!
Please make sure to read through the following instructions thoroughly. **NOTE** One of them is to replace the documentation of this `README.md` file. 

## Instructions

1. Install the plugins for your IDE for the specified Gen AI tooling technology
2. Clone necessary repo from [Files](#files)

    ```bash
        # Clone remote repo
        git clone https://github.com/roryeiffe/drink-shop-project.git

        # Change directories into remote repo
        cd drink-shop-project/
    ```

3. Create a new branch of your own to work on the system
    ```bash
        # Create a new branch to work off of
        # git checkout -b <firstname-lastname> # Generalized Command
        git checkout -b charles-jester # Example Command
    ```
4. Next you'll be following the below guidelines to complete all `TODO` comments within the application code base. We will also be overwriting the `README.md` file to adhere to the app instead of these instructions.
    1. Details for what you need to completed two sections for [Documentation](#documentation-1) & [Testing](#testing-1)

### Documentation

1. **_For JavaDocs_**, begin to write the comments above the implemented methods and class defintions for any class with `TODO` comments.
    1. Make sure as the code is generated we make sure to include detailed descriptions, params, returns, throws, and more where necessary.
    2. As we write these, the Generative AI will perform better with each subsequent method. Helping our productivity.
    3. **VALIDATE** generated output prior to moving on.
2. **_For README.md_**, please overwrite the contents of the README.md.
    1. Your application to include the following sections:
        1. Description
        2. Technologies
        3. Endpoints
        4. Future Implementations
        5. Credits
    2. **VALIDATE** generated output prior to moving on.
3. **Ask yourself:**
    1. Do the JavaDocs and README accurately describe what this application is trying to accomplish?
    2. If a new developer on the team were to be given the documentation generated and edited by you, is there any additional comments you could add to improve the documentation?
    3. Is there any additional documentation you could add to help future development?

### Testing

1. Generate unit tests with your GenAI tool for any `TODO` comment outlining the requirement to build tests.
    1. **VALIDATE** Utilize your IDE's intellisense to detect any immediate problems with the generated code.
    2. **VALIDATE** Inspect the generated unit tests manually or, if the tool offers an "explanation" feature, feel free to use this in order to gain a better understanding of the generated code.
    3. Ask yourself:
        1. Do the unit tests properly test whether the code is correct?
        2. Are there any missing corner/edge cases?
2. After evaluating the quality of the generated tests, make any necessary fixes and run the tests.
3. If the tests do not pass, re-evaluate and repeat until the tests do pass and you are satisfied with their correctness.

### Wrap-Up

1. Once completed, if you have time feel free to take on any of the additional challenges (optional):
    1. Compare the `ai-gen` branch with `main` and note any differences between the logic written here and what's presented in the `main` branch. See branch outline in [Files](#files)
    2. Compare the solution branch `documentation-and-testing` to see how closely or how far your output is from that shown here.
    3. Check the application for any security concerns or potential room for improvements.
2. Otherwise, proceed with pushing your branch up to the repository for a code review. Feel free to make a pull request to `main` on GitHub.

    ```bash
         # Push the code to remote repository for evaluation
         git add .
         # git commit -m "submittal of genAI generated code validated by <firstname-lastname>" # Generalized Command
         git commit -m "submittal of genAI generated code validated by charles-jester" # Example Command

         # git push -u origin <firstname-lastname> # Generalized Command
         git push -u origin charles-jester # Example Command
    ```
