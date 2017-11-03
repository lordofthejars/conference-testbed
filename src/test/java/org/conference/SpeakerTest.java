package org.conference;

import org.conference.pageobjects.CreateSpeakerPage;
import org.conference.pageobjects.HomePage;
import org.conference.pageobjects.Speaker;
import org.conference.pageobjects.SpeakerPage;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.InitialPage;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Arquillian.class)
public class SpeakerTest {

    @Drone
    WebDriver webDriver;

    @Test
    public void should_create_a_new_speaker(@InitialPage HomePage homePage) {

        // given
        final Speaker speaker = new Speaker("Alex", "Soto", "@alexsotob");

        // when
        SpeakerPage speakerPage = homePage
            .navigateToSpeakerLink()
            .navigateToCreateNewSpeaker()
            .createSpeaker(speaker);

        // then
        speakerPage.assertThatSpeakerIsAdded(speaker);
    }

}
