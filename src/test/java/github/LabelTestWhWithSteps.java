package github;

import org.junit.jupiter.api.Test;

public class LabelTestWhWithSteps {
    @Test
    public void labelAnnotationSteps () {
        WebStepsForLabel websteps = new WebStepsForLabel();
        websteps.openpage();
        websteps.searchSelenide();
        websteps.selenideRepo();
        websteps.openIssueTab();
        websteps.labelsAssert();
    }
}
