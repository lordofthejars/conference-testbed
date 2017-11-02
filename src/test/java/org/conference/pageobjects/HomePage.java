package org.conference.pageobjects;

import org.jboss.arquillian.graphene.page.Location;
import org.jboss.arquillian.graphene.page.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;

@Location("conference/index.xhtml")
public class HomePage {

    @Page
    private SpeakerPage speakerPage;

    @FindBy(id = "speaker_link")
    private WebElement speakerLink;

    public SpeakerPage navigateToSpeakerLink() {
        guardHttp(speakerLink).click();
        return speakerPage;
    }

}
