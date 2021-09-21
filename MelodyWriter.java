import java.util.Scanner;

public class MelodyWriter
{
	public static void main(String[] args)
	{
		String out = "";
		double tempo = 0;
		double beatDuration = 0; // in seconds
		Scanner gg = new Scanner(System.in);
		String[] in = new String[0];

		System.out.print("Pleas enter the tempo for the song: ");
		tempo = gg.nextDouble();
		gg.nextLine(); //dummy read
		beatDuration = 60 / tempo;

		System.out.println(
				"Please enter the notes for the song in this format and type \"exit\" when done: ab5 16  (results in A flat 5 as a sixteenth note, triplets must be in divisions of 12)");

		// ab5 16 formatting
		try {
		while (true)
		{
			in = gg.nextLine().split(" ");

			if (in[0].equals("exit"))
				break;

			out += "" + (beatDuration * (4 / Double.parseDouble(in[1]))) + " "; // duration

			if (in[0].equals("r")) // rest
			{
				out += "R false\n";
				continue;
			}

			switch (in[0].charAt(0)) // letter
			{
			case 'a':
				out += "A ";
				break;
			case 'b':
				out += "B ";
				break;
			case 'c':
				out += "C ";
				break;
			case 'd':
				out += "D ";
				break;
			case 'e':
				out += "E ";
				break;
			case 'f':
				out += "F ";
				break;
			case 'g':
				out += "G ";
				break;
			default:
				out += "";

			}

			out += (in[0].charAt(in[0].length() - 1)) + " "; // octave

			if (in[0].length() == 3) // sharp/flat
			{
				if (in[0].charAt(1) == 'b')
					out += "FLAT ";
				else
					out += "SHARP ";
			} else
				out += "NATURAL ";

			out += "false\n"; // final false
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}

		System.out.print("\n\n" + out.substring(0, out.length() - 1));
	}
}