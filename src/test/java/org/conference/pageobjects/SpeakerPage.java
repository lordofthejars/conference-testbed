package org.conference.pageobjects;

import org.jboss.arquillian.graphene.page.Location;
import org.jboss.arquillian.graphene.page.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;
import static org.jboss.arquillian.graphene.Graphene.guardHttp;

@Location("conference/speaker/search.xhtml")
public class SpeakerPage {

    @Page
    private CreateSpeakerPage createSpeakerPage;

    @FindBy(id = "search:create_new_button")
    private WebElement createNewSpeaker;

    @FindBy(id = "search:speakerBeanPageItems")
    private SpeakerTableFragment speakerTableFragment;

    public CreateSpeakerPage navigateToCreateNewSpeaker() {
        guardHttp(createNewSpeaker).click();
        return createSpeakerPage;
    }

    public void assertThatSpeakerIsAdded(Speaker speaker) {
        assertThat(speakerTableFragment.getSpeakers())
            .extracting("firstname", "surname")
            .contains(tuple(speaker.getFirstname(), speaker.getSurname()));
    }

}
