package data;

import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class PlaylistTest {
    PlayList p1, p2, p3;

    @After
    void initialize() {
        p1 = new PlayList("teste");
        p2 = new PlayList("testeadvance");
    }

    @Test
    void shouldInitializeCorrect() {
        assertEquals(p1.name, "teste");
        assertEquals(p1.currentMusicPosition, 0);
        assertEquals(p1.musics.size(), 0);
    }

    @Test
    void shouldAddAndRemoveMusic() {
        List<Music> expected = new ArrayList<>();
        expected.add(new Music("musica1"));
        expected.add(new Music("musica2"));
        expected.add(new Music("musica3"));

        p1.addMusic(expected.get(0));
        assertTrue(p1.musics.contains(expected.get(0)));
        p1.addMusic(expected.get(1));
        assertTrue(p1.musics.contains(expected.get(1)));
        p1.addMusic(expected.get(2));
        assertTrue(p1.musics.contains(expected.get(2)));
        assertTrue(p1.getMusics().equals(expected));

        p1.removeMusic(expected.get(0));
        p1.removeMusic(expected.get(1));
        assertFalse(p1.musics.contains(expected.get(0)));
        assertFalse(p1.musics.contains(expected.get(1)));
    }

    @Test
    void shouldAdvance() {
        p2.addMusic(new Music("music1"));
        p2.addMusic(new Music("music2"));
        p2.addMusic(new Music("music3"));
        assertTrue(p2.nextMusic().getName().equals("music1"));
        assertTrue(p2.nextMusic().getName().equals("music2"));
        assertTrue(p2.nextMusic().getName().equals("music3"));
        assertTrue(p2.nextMusic().getName().equals("music1"));
    }
}