package Model;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BackgroundMusicPlayer {
    private String backgroundMusicPath;
    private String currentMusicPath;
    private Player player;
    private boolean isPlaying = false;
    private boolean isMuted = false;

    public BackgroundMusicPlayer(String backgroundMusicPath) {
        this.backgroundMusicPath = backgroundMusicPath;
        this.currentMusicPath = backgroundMusicPath;
    }

    public void playBackgroundMusic() {
        if (!isPlaying && !isMuted) {
            playMusic(backgroundMusicPath);
        }
    }

    public void playOtherMusic(String musicPath) {
        currentMusicPath = musicPath;
        if (isPlaying) {
            player.close();
        }
        if (!isMuted) {
            playMusic(musicPath);
        }
    }

    public void mute() {
        if (isPlaying) {
            player.close();
            isPlaying = false;
            isMuted = true;
        }
    }

    public boolean isMuted() {
        return isMuted;
    }

    public void unmute() {
        if (isMuted) {
            isMuted = false;
            playMusic(currentMusicPath);
        }
    }

    private void playMusic(String musicPath) {
        try {
            FileInputStream fis = new FileInputStream(musicPath);
            player = new Player(fis);

            new Thread() {
                public void run() {
                    try {
                        isPlaying = true;
                        player.play();
                        if (!backgroundMusicPath.equals(currentMusicPath)) {
                            currentMusicPath = backgroundMusicPath;
                            playMusic(currentMusicPath);
                        }
                        isPlaying = false;
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }.start();

        } catch(FileNotFoundException | JavaLayerException e) {
            System.out.println(e);
        }
    }
}
