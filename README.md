# Mini-Survey Monkey [Group 5] [![CircleCI](https://circleci.com/gh/Imcool4789/Mini-SurveyMonkey/tree/master.svg?style=svg)](https://circleci.com/gh/Imcool4789/Mini-SurveyMonkey/tree/master)

[Heroku App Link](https://minisurveymonkey.herokuapp.com/)

This repository contains the initial Mini-SurveyMonkey Spring Boot application which will allow a surveyor to create a survey with a list of questions that can be of varying types (multiple choice, open ended, or numbers within a range) and at any point in time, the surveyor will be able to close the survey and obtain the responses. The users will be able to view and fill out the survey created by the surveyor and allow their responses to be saved and upon successful submission, the survey will output the result either as simple text, histogram, or pie chart depending on the type of question asked in the survey. 

The repository is sorted into various packages such as `Login`, `Survey`, `Question`, `Answer` and these packages group together classes relevant to the specific package name. E.x. `Login` will contain model, repository and controller classes relevant to the act of logging into the app.

## Authors

- John Warde 
- Kashish Saxena
- Vis Kirubakaran

## Milestone 2 - March 25, 2022
- [x] Refactor Answer Model into different types (MCAnswer - John, NumberRangeAnswer - Vis, OpenAnswer - Kashish)
- [x] Implement capability to add answers into survey questions - John
- [x] Integrate MongoDB - John
- [ ] Storing user and accessing user info via DB - Vis
- [ ] Storing questions and accessing via DB - Kashish
- [ ] Storing answers and accessing via DB - John
- [ ] Create DB tests - John
- [ ] Create Results page - Vis
- [ ] Creating multiple questions within same page - Vis
- [x] Update Diagrams with progress (ORM ER Model - Kashish, UML Class Diagram - Vis)
- [x] Create remove question functionality - Kashish
- [x] Navigating through survey in user POV - John
- [ ] Implement Tests for Answer creation within survey - John
- [ ] Adding and Removing Questions from survey tests - Kashish
- [x] Revise QuestionModel & AnswerModel interaction for proper inheritance - Everyone
- [x] Implement Answer Model tests (MCAnswer - John, NumberRangeAnswer - Vis, OpenAnswer - Kashish)
- [x] Ability to close survey and return results - Kashish
- [x] Update README - Anyone
- [x] Update Kanban board - Everyone
- [x] Create weekly issues for scrums - Everyone

## Plans for Milestone 3 - Apr 8, 2022
- [x] CircleCI and Heroku Integration
- [x] Database Integration (H2)
- [x] Kanban Board Setup with 'backlog', 'in progress', 'completed' columns
- [x] GitHub Issues for Weekly Scrum
- [x] Code Reviews on pull requests to master prior to commit
- [x] Spring Boot Application code functional and deployable via jar on Heroku
- [x] Model Setup Done (Survey, Question, Answer, User)
- [x] Tests for Controllers, Application, Database and Models
- [x] Diagrams (UML Class and ER)
- [x] Handles 2 form submissions (logging in and survey question creation) with valid mappings and views as outputs 
- [x] Ability to login as either surveyor or user  
- [x] Ability to logout when logged in as either surveyor or user
- [x] Ability to navigate through app with respective permissions. User can only view survey, Surveyor can view and create survey questions
- [x] Ability to add all 3 types of questions to a survey with a name 
- [x] Ability to add questions to a survey and view the updated list of questions in the survey
- [x] Ability to view most relevant redirects as viewable html pages with data presented visually instead of passing around JSON and display JSON objects  

## Diagrams

### DB Diagram
![image](https://github.com/Imcool4789/Mini-SurveyMonkey/blob/master/diagrams/Group5_DB_Diagram_John_Warde.png)

### UML Class Diagram
![image](https://user-images.githubusercontent.com/72267229/160118708-a4e2f8c4-0671-4576-acb2-8bba005ad8d2.png)


## Setup & Testing Instructions
1.  `git clone` this repository to your local machine
2.  Open IntelliJ, run the following lifecycles with Maven: `clean` followed by `package`
3.  To run the application, right click the `Mini-SurveyMonkey-0.0.1-SNAPSHOT.jar` which is located in `target/` and select `Run`
4.  To run all the tests, run the following lifecycle with Maven: `test`
