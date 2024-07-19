package com.espncricinfo;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources", // Location of feature files
    glue = "com.espncricinfo"    // Package where step definitions are located   
)
public class TestRunner {
   
}
