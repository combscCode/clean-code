// It's really not obvious to me that putting everything
// in a class makes this any easier to understand. Scope hasn't
// been limited at all, in fact I think having class variables
// makes this more confusing.

// If this was done outside of a class and avoided using global variables,
// we'd be forced to pass variables between functions which would significantly
// aid in the readability of the code. I feel that the return values and the params
// of a function help to explain what the function does. But when functions begin to
// modify class variables in order to do their job, their purpose can
// ONLY
// be understood by reading through the code (and usually, finding every context where
// those class variables are read or modified).

// IMO if we decide to use classes for the purpose of limiting scope, then wouldn't
// something like a namespace + exposing public functions in a file be more appropriate?
// IIRC golang provides this feature which I think is a lot more straightforward.

// Classes should be used to compartmentalize complexity, but when all of your
// methods *may* modify class variables, we're forcing the reader to read every
// class method to verify it doesn't do something funky to the class.
// This means that everytime a non-essential method is added to a class, we're
// actually *adding* to the overall complexity of the code, not reducing.
public class GuessStatisticsMessage {
	private String number;
	private String verb;
	private String pluralModifier;

	public String make(char candidate, int count) {
		createPluralDependentMessageParts(count);
		return String.format(
			"There %s %s %s%s",
			verb, number, candidate, pluralModifier
		);
	}

	// I don't see the value of turning these things into functions
	// "thereAreNoLetters" is clearly implied by count == 0
	private void createPluralDependentMessageParts(int count) { 
		if (count == 0) {
			thereAreNoLetters();
		} else if (count == 1) {
			thereIsOneLetter();
		} else {
			thereAreManyLetters(count);
		}
	}

	// The naming for the following 3 methods seems... horrible?
	// They aren't verbs, they don't imply action, they just
	// describe the state of the grammar.
	private void thereAreManyLetters(int count) {
		number = Integer.toString(count);
		verb = "are";
		pluralModifier = "s";
	}

	private void thereIsOneLetter() {
		number = "1";
		verb = "is";
		pluralModifier = "";
	}

	private void thereAreNoLetters() {
		number = "no";
		verb = "are";
		pluralModifier = "s";
	}
}
