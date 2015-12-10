import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Music {
	public static void musicApplause() throws IOException
	{
		String wav_file = "src/Sound/applause.wav";
		InputStream in = new FileInputStream(wav_file);
		AudioStream audio = new AudioStream(in);
		AudioPlayer.player.start(audio);
	}
	public static void musicBoo() throws IOException
	{		
		String wav_file2 = "src/Sound/boo.wav";
		InputStream in2 = new FileInputStream(wav_file2);
		AudioStream audio2 = new AudioStream(in2);
		AudioPlayer.player.start(audio2);
	}
}
