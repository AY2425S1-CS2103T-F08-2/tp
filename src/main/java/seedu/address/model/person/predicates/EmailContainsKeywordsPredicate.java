package seedu.address.model.person.predicates;

import java.util.Set;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.Person;

/**
 * Tests that a {@code Person}'s {@code Email} matches any of the keywords given.
 */
public class EmailContainsKeywordsPredicate implements Predicate<Person> {
    private final Set<String> keywords;

    public EmailContainsKeywordsPredicate(Set<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsSubstringIgnoreCase(person.getEmail().value, keyword));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EmailContainsKeywordsPredicate)) {
            return false;
        }

        EmailContainsKeywordsPredicate otherEmailContainsKeywordsPredicate = (EmailContainsKeywordsPredicate) other;
        return keywords.equals(otherEmailContainsKeywordsPredicate.keywords);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("keywords", keywords).toString();
    }
}
