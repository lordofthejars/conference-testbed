package org.conference.pageobjects;

import java.util.ArrayList;
import java.util.List;
import org.jboss.arquillian.graphene.findby.FindByJQuery;
import org.openqa.selenium.WebElement;

public class SpeakerTableFragment {

    @FindByJQuery("[id$='_itemFirstname']")
    private List<WebElement> firstNames;

    @FindByJQuery("[id$='_itemSurname']")
    private List<WebElement> surnames;

    public List<Speaker> getSpeakers() {
        final List<Speaker> speakers = new ArrayList<>();
        for (int i=0; i < firstNames.size(); i++) {
            speakers.add(new Speaker(
                firstNames.get(i).getText().trim(),
                surnames.get(i).getText().trim(),
                null));
        }

        return speakers;
    }

}
