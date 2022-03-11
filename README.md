# Mini-Survey Monkey [Group 5] [![CircleCI](https://circleci.com/gh/Imcool4789/Mini-SurveyMonkey/tree/master.svg?style=svg)](https://circleci.com/gh/Imcool4789/Mini-SurveyMonkey/tree/master)

[Heroku App Link](https://minisurveymonkey.herokuapp.com/)

This repository contains the initial Mini-SurveyMonkey Spring Boot application which will allow a surveyor to create a survey with a list of questions that can be of varying types (multiple choice, open ended, or numbers within a range) and at any point in time, the surveyor will be able to close the survey and obtain the responses. The users will be able to view and fill out the survey created by the surveyor and allow their responses to be saved and upon successful submission, the survey will output the result either as simple text, histogram, or pie chart depending on the type of question asked in the survey. 

## Authors

- John Warde 
- Kashish Saxena
- Vis Kirubakaran

## Milestone 1 - March 11, 2022
- [x] CircleCI and Heroku Integration
- [x] Database Integration (H2)
- [x] Kanban Board Setup with 'backlog', 'in progress', 'completed' columns
- [ ] GitHub Issues for Weekly Scrum
- [x] Code Reviews on pull requests to master prior to commit
- [x] Spring Boot Application code functional and deployable via jar on Heroku
- [x] Model Setup Done (Survey, Question, Answer, User)
- [x] Tests for Controllers, Application, Database and Models
- [x] Diagrams (UML Class, ER, Database)
- [x] Ability to login as either surveyor or user 
- [x] Ability to navigate through app with respective permissions. User can only view survey, Surveyor can view and create survey
- [x] Ability to create survey
- [x] Ability to add questions to a survey

## Diagrams

### DB Diagram
![image](https://user-images.githubusercontent.com/56265739/157777809-2f77ed04-221b-48e3-a4ec-d28e71e12a33.png)

### UML Class Diagram
![image](https://user-images.githubusercontent.com/72267229/157780209-833dd889-e52d-4f30-b922-8709994ea3da.png)

## Plans for Next Milestone
Milestone 2 - March 25, 2022
- [ ] Refactor Answer Model into different types (MCAnswer - John, NumberRangeAnswer - Vis, OpenAnswer - Kashish)
- [ ] Implement capability to add answers into survey questions - John
- [ ] Intgerate MongoDB - John
- [ ] Create DB tests - John
- [ ] Create Results page - Vis
- [ ] Creating multiple questions within same page 
- [ ] Update Diagrams with progress 
- [ ] Create remove question functionality - Kashish
- [ ] Navigating through survey in user POV - John
- [ ] Implement Tests for Answer creation within survey
- [ ] Adding and Removing Questions from survey tests
- [ ] Implement Answer Model tests (MCAnswer - John, NumberRangeAnswer - Vis, OpenAnswer - Kashish)
- [ ] Ability to close survey and return results - Kashish
- [ ] Update Kanban board
- [ ] Create weekly issues

## Setup & Testing Instructions
1.  `git clone` this repository to your local machine
2.  Open IntelliJ, run the following lifecycles with Maven: `clean` followed by `package`
3.  To run the application, right click the `Mini-SurveyMonkey-0.0.1-SNAPSHOT.jar` which is located in `target/` and select `Run`
4.  To run all the tests, run the following lifecycle with Maven: `test`
