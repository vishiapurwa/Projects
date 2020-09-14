package com.project.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources/Features/ConferenceRegistration.feature","src/test/resources/Features/Payment.feature"},glue="com.project.stepDefinitions",dryRun=false)
public class TestRunner {

}
