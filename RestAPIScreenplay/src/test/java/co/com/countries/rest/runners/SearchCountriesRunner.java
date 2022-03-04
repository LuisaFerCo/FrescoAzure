package co.com.countries.rest.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/java/resources/features/search_countries.feature",
        glue = "co.com.countries.rest.stepsdefinitions",
        snippets = SnippetType.CAMELCASE)
public class SearchCountriesRunner {
}
