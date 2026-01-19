package com.askomdch.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.askomdch.steps", "com.askomdch.hooks"},
        monochrome = true,
        plugin = {
                "pretty",
                "json:target/cucumber-reports/cucumber.json"
        },
        dryRun= true,
        snippets=CAMELCASE

)
public class RunCucumberTests {
}