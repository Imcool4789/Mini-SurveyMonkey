# Mini-Survey Monkey [Group 5] [![CircleCI](https://circleci.com/gh/Imcool4789/Mini-SurveyMonkey/tree/master.svg?style=svg)](https://circleci.com/gh/Imcool4789/Mini-SurveyMonkey/tree/master)

## Project Description

The Mini-SurveyMonkey Spring Boot application will allow a surveyor to create a survey with a list of questions that can be of varying types such as multiple choice, number range, and open ended. At any point in time, the surveyor will be able to close the survey and obtain the responses. The users will be able to view and fill out the survey created by the surveyor and allow their responses to be saved and upon successful submission, the survey will output the result of each question either as simple text, histogram, or pie chart depending on the type of question asked in the survey. 

The repository is sorted into various packages such as `Login`, `Survey`, `Question`, `Answer` and these packages group together classes relevant to the specific package name. E.x. `Login` will contain model, repository and controller classes relevant to the act of logging into the app.

## Relevant Links
- [CircleCI](https://circleci.com/gh/Imcool4789/Mini-SurveyMonkey/tree/master) 
- [Heroku App Link](https://minisurveymonkey.herokuapp.com/)
- [Kanban Project Board](https://github.com/Imcool4789/Mini-SurveyMonkey/projects/1)

## Authors

- John Warde 
- Kashish Saxena
- Vis Kirubakaran

## Milestone 3 - Apr 8, 2022
- [ ] [Working on Results Page](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/10)
- [ ] [User POV](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/49)
- [ ] [Close Survey Functionality](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/59)
- [ ] [Delete Question Functionality](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/60)
- [ ] [Integrating MongoDB](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/67)
- [ ] [Update Wiki for M3](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/74)
- [ ] [Progress Bar](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/80)
- [ ] [Update README](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/81)
- [ ] [Update Diagrams and add generated ER Diagram](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/82)
- [ ] [Reset Survey Functionality](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/83)
- [ ] [Spring Security](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/84)
- [ ] [Unique Response Count](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/85)
- [ ] [Refactor Model Tests](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/87)
- [ ] [Unit and Integration Testing](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/88)
- [ ] [Survey Templates](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/89)
- [ ] [Weekly Scrum Apr 4th](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/90)
- [ ] [Multiple survey support](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/91)
- [ ] [Save Results page as pdf](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/92)
- [ ] [Refactor repository interaction with models](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/93)

## Wiki
To see the milestone-by-milestone progress of the project, please take a look at the [Wiki](https://github.com/Imcool4789/Mini-SurveyMonkey/wiki).

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
