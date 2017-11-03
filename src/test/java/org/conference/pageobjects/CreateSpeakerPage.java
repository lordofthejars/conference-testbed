package org.conference.pageobjects;

import org.jboss.arquillian.graphene.GrapheneRuntime;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;

@Location("conference/speaker/create.xhtml")
public class CreateSpeakerPage {

    @FindBy(id = "create:speakerBeanSpeakerFirstname")
    private WebElement firstname;

    @FindBy(id = "create:speakerBeanSpeakerSurname")
    private WebElement surname;

    @FindBy(id = "create:speakerBeanSpeakerTwitter")
    private WebElement twitter;

    @FindBy(id = "create:save_button")
    private WebElement save;

    public SpeakerPage createSpeaker(Speaker speaker) {
        firstname.sendKeys(speaker.getFirstname());
        surname.sendKeys(speaker.getSurname());
        twitter.sendKeys(speaker.getTwitter());

        guardHttp(save).click();

        return GrapheneRuntime.getInstance().goTo(SpeakerPage.class);

    }

}
