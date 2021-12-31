package com.qlo.runnerclass;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="FeatureFiles", 
				glue="com.qlo.stepdefinition",
				dryRun=false,
				plugin = {"html:target/cucumber-html-report","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/extendreport.html"})
public class TestRunner {

}
