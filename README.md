# Mini-Survey Monkey [Group 5] [![CircleCI](https://circleci.com/gh/Imcool4789/Mini-SurveyMonkey/tree/master.svg?style=svg)](https://circleci.com/gh/Imcool4789/Mini-SurveyMonkey/tree/master)

![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white)
![CircleCI](https://img.shields.io/badge/circle%20ci-%23161616.svg?style=for-the-badge&logo=circleci&logoColor=white)
![Heroku](https://img.shields.io/badge/heroku-%23430098.svg?style=for-the-badge&logo=heroku&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)

## Project Description

The Mini-SurveyMonkey Spring Boot application will allow a surveyor to create a survey with a list of questions that can be of varying types such as multiple choice, number range, and open ended. At any point in time, the surveyor will be able to close the survey and obtain the responses. The users will be able to view and fill out the survey created by the surveyor and allow their responses to be saved and upon successful submission, the survey will output the result of each question either as simple text, histogram, or pie chart depending on the type of question asked in the survey.

The repository is sorted into various packages such as `Login`, `Survey`, `Question`, `Answer` and these packages group together classes relevant to the specific package name. E.x. `Login` will contain model, repository and controller classes relevant to the act of logging into the app.

## Relevant Links

- [CircleCI](https://circleci.com/gh/Imcool4789/Mini-SurveyMonkey/tree/master)
- [Heroku App Link](https://minisurveymonkey.herokuapp.com/)
- [Kanban Project Board](https://github.com/Imcool4789/Mini-SurveyMonkey/projects/1)
- [Wiki](https://github.com/Imcool4789/Mini-SurveyMonkey/wiki)

## Authors

- John Warde
- Kashish Saxena
- Vis Kirubakaran

## Milestone 3 - Apr 8, 2022
- [x] [Working on Results Page](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/10)
- [x] [Result Page Templates of all types](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/45)
- [x] [Multiple Question Creation Same Page through Redirects](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/46)
- [x] [User POV](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/49)
- [x] [Close Survey Functionality](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/59)
- [x] [Integrating Database](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/67)
- [x] [Update Wiki for M3](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/74)
- [x] [Fix HTML Stylesheet Reference](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/76)
- [x] [Refactor Model Inheritance and Multiplicity](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/77)
- [x] [Update viewSurvey CSS](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/78)
- [x] [Progress Bar](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/80)
- [x] [Update README](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/81)
- [x] [Update Diagrams and add generated ER Diagram](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/82)
- [x] [Spring Security](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/84)
- [x] [Refactor Model Tests](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/87)
- [x] [Unit and Integration Testing](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/88)
- [x] [Weekly Scrum Apr 4th](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/90)
- [x] [Save Results page as pdf](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/92)
- [x] [Refactor View Mappings after Spring Security](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/94)
- [x] [Refactor repository interaction with models](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/93)
- [x] [Single Results Page & Multiple Results Page](https://github.com/Imcool4789/Mini-SurveyMonkey/issues/95)

## Wiki
To see the milestone-by-milestone progress of the project, please take a look at the [Wiki](https://github.com/Imcool4789/Mini-SurveyMonkey/wiki).

## Diagrams

### DB Diagram
![image](https://user-images.githubusercontent.com/56265739/162431989-f7d0e994-a048-4459-9915-1956ad734a3d.png)

### UML Class Diagram
![image](https://github.com/Imcool4789/Mini-SurveyMonkey/blob/master/diagrams/Group5_Class_UML_Vis_Kirubakaran.png)


## Setup & Testing Instructions
1.  `git clone` this repository to your local machine
2.  Open IntelliJ, run the following lifecycles with Maven: `clean` followed by `package`
3.  To run the application, right click the `Mini-SurveyMonkey-0.0.1-SNAPSHOT.jar` which is located in `target/` and select `Run`
4.  To run all the tests, run the following lifecycle with Maven: `test`
