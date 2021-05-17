// This is my attempt to improve listing 2-2 while sticking
// to the OOP paradigm.

// not a huge fan of the name he provides but oh well
public class GuessStatisticsMessage {
	private String verb;
	private String pluralModifier;

	// candidate implies string, changed to letter
	public String makeGuess(char letter, int count) {
		setGrammar(count);
		return String.format(
			"There %s %s %s%s", verb, Integer.toString(count), letter, pluralModifier
		)
	}

	// setGrammar may be not good since we're declaring a "set" function that's not
	// public. But I despise calling functions that don't return anything, since
	// it's not clear at all what side effects it does without reading through
	// the code. I believe that this promotion of side effects in OOP programming
	// is responsible for a lot of spaghetti code where you can't change anything
	// without causing a ton of unintended side effects.

	// In the perfect world, there would be an indicator that would clearly show
	// what class variables 'setGrammar' modifies:
	// this.verb
	// this.pluralModifier
	private void setGrammar(int count) {
		if (count == 1) {
			this.verb = "is"
			this.pluralModifier = ""
		} else {
			this.verb = "are"
			this.pluralModifier = "s"
		}
	}
}

// My criticism of this paradigm overall:
// I feel like there are a lot of situations where I'm making a class that only has
// one public method.

// GuessStatisticsMessage messageMaker = GuessStatisticsMessage();
// messageMaker('a', 10);

// This construction of objects with nothing passed, just so we can call the
// method we're actually interested in feels REALLY stupid. IMO this should
// just be a function that we expose. If we want to contain the scope of various
// functions I feel like Go and Python both do a good job of this with their various
// ways of importing functions from other files (but I don't know a ton about Go tbh)
