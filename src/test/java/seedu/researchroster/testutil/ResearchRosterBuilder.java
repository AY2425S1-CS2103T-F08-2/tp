package seedu.researchroster.testutil;

import seedu.researchroster.model.ResearchRoster;
import seedu.researchroster.model.person.Person;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code ResearchRoster ab = new ResearchRosterBuilder().withPerson("John", "Doe").build();}
 */
public class ResearchRosterBuilder {

    private ResearchRoster researchRoster;

    public ResearchRosterBuilder() {
        researchRoster = new ResearchRoster();
    }

    public ResearchRosterBuilder(ResearchRoster researchRoster) {
        this.researchRoster = researchRoster;
    }

    /**
     * Adds a new {@code Person} to the {@code ResearchRoster} that we are building.
     */
    public ResearchRosterBuilder withPerson(Person person) {
        researchRoster.addPerson(person);
        return this;
    }

    public ResearchRoster build() {
        return researchRoster;
    }
}
