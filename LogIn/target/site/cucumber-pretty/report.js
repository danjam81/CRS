$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/acceptancetests/features/devfeatures.feature");
formatter.feature({
  "name": "lop list entries",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "add entries for CRS7.LogIn",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@web"
    }
  ]
});
formatter.step({
  "name": "I navigate to the WEB UI",
  "keyword": "Given "
});
formatter.step({
  "name": "I enter the value \"\u003cuser1\u003e\" into the \"username\" field",
  "keyword": "When "
});
formatter.step({
  "name": "I enter the value \"\u003cowner\u003e\" into the \"owner\" field",
  "keyword": "And "
});
formatter.step({
  "name": "I enter the value \"\u003cdate\u003e\" into the \"date\" field",
  "keyword": "And "
});
formatter.step({
  "name": "I enter the value \"\u003cstatus\u003e\" into the \"status\" field",
  "keyword": "And "
});
formatter.step({
  "name": "I enter the value \"\u003cnote\u003e\" into the \"note\" field",
  "keyword": "And "
});
formatter.step({
  "name": "I click on Add",
  "keyword": "And "
});
formatter.step({
  "name": "the subject \"\u003csubject\u003e\" exists on the overview page",
  "keyword": "Then "
});
formatter.step({
  "name": "the amount of total web entries was increased by 1",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "owner",
        "date",
        "status",
        "note"
      ]
    },
    {
      "cells": [
        "qxy1677",
        "Al",
        "03/01/2018",
        "ACTIVE",
        "aaaaaaaa"
      ]
    }
  ]
});
formatter.scenario({
  "name": "add entries for CRS7.LogIn",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@web"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to the WEB UI",
  "keyword": "Given "
});
formatter.match({
  "location": "WebSteps.java:107"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter the value \"\u003cuser1\u003e\" into the \"username\" field",
  "keyword": "When "
});
formatter.match({
  "location": "WebSteps.java:116"
});
formatter.result({
  "error_message": "java.lang.IllegalArgumentException: Invalid field!\r\n\tat acceptancetests.steps.WebSteps.lambda$1(WebSteps.java:135)\r\n\tat ✽.I enter the value \"\u003cuser1\u003e\" into the \"username\" field(src/test/java/acceptancetests/features/devfeatures.feature:41)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "I enter the value \"Al\" into the \"owner\" field",
  "keyword": "And "
});
formatter.match({
  "location": "WebSteps.java:116"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I enter the value \"03/01/2018\" into the \"date\" field",
  "keyword": "And "
});
formatter.match({
  "location": "WebSteps.java:116"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I enter the value \"ACTIVE\" into the \"status\" field",
  "keyword": "And "
});
formatter.match({
  "location": "WebSteps.java:116"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I enter the value \"aaaaaaaa\" into the \"note\" field",
  "keyword": "And "
});
formatter.match({
  "location": "WebSteps.java:116"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I click on Add",
  "keyword": "And "
});
formatter.match({
  "location": "WebSteps.java:139"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the subject \"\u003csubject\u003e\" exists on the overview page",
  "keyword": "Then "
});
formatter.match({
  "location": "WebSteps.java:194"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the amount of total web entries was increased by 1",
  "keyword": "And "
});
formatter.match({
  "location": "WebSteps.java:181"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded0.png");
formatter.write("Screenshot attached");
formatter.after({
  "status": "passed"
});
});