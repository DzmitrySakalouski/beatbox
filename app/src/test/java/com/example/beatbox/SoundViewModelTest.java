package com.example.beatbox;

import org.hamcrest.core.Is;
import org.hamcrest.junit.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class SoundViewModelTest {
    private BeatBox mBeatBox;
    private Sound mSound;
    private SoundViewModel mSubject;

    @Before
    public void setUp() throws Exception {
        mBeatBox = Mockito.mock(BeatBox.class);
        mSound = new Sound("assetPath");
        mSubject = new SoundViewModel(mBeatBox);
        mSubject.setSound(mSound);
    }

    @Test
    public void exposesSoundNameAsTitle() {
        MatcherAssert.assertThat(mSubject.getTitle(), Is.is(mSound.getName()));
    }

    public void callsBeatBoxPlayButtonOnClick() {
        mSubject.onButtonClicked();
        Mockito.verify(mBeatBox).play(mSound);
    }
}