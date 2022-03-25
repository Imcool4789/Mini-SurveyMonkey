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
- [x] Implement Tests for Answer creation within survey - John
- [x] Adding Question to Survey Tests - Kashish
- [x] Update Diagrams with progress (ORM ER Model - Kashish, UML Class Diagram - Vis)
- [x] Create remove question functionality - Kashish
- [x] Navigating through survey in user POV - John
- [x] Revise QuestionModel & AnswerModel interaction for proper inheritance - Everyone
- [x] Implement Answer Model tests (MCAnswer - John, NumberRangeAnswer - Vis, OpenAnswer - Kashish)
- [x] Ability to close survey and return results - Kashish
- [x] Update README - Anyone
- [x] Update Kanban board - Everyone
- [x] Create weekly issues for scrums - Everyone

## Milestone 3 - Apr 8, 2022
- [ ] Removing Questions from survey tests - Kashish
- [ ] Storing user and accessing user info via DB - Vis
- [ ] Storing questions and accessing via DB - Kashish
- [ ] Storing answers and accessing via DB - John
- [ ] Create DB tests - John
- [ ] Create Results page - Vis
- [ ] Creating multiple questions within same page - Vis

## Wiki
To see the milestone-by-milestone progress of the project, please take a look at the [Wiki](https://github.com/Imcool4789/Mini-SurveyMonkey/wiki)

## Diagrams

### DB Diagram
![image](https://github.com/Imcool4789/Mini-SurveyMonkey/blob/master/diagrams/Group5_DB_Diagram_John_Warde.png)

### UML Class Diagram
![image](https://github.com/Imcool4789/Mini-SurveyMonkey/blob/master/diagrams/Group5_Class_UML_Vis_Kirubakaran.png)


## Setup & Testing Instructions
1.  `git clone` this repository to your local machine
2.  Open IntelliJ, run the following lifecycles with Maven: `clean` followed by `package`
3.  To run the application, right click the `Mini-SurveyMonkey-0.0.1-SNAPSHOT.jar` which is located in `target/` and select `Run`
4.  To run all the tests, run the following lifecycle with Maven: `test`
