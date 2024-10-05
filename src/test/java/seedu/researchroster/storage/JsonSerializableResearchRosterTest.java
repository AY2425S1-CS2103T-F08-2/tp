package seedu.researchroster.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.researchroster.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import seedu.researchroster.commons.exceptions.IllegalValueException;
import seedu.researchroster.commons.util.JsonUtil;
import seedu.researchroster.model.ResearchRoster;
import seedu.researchroster.testutil.TypicalPersons;

public class JsonSerializableResearchRosterTest {

    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonSerializableResearchRosterTest");
    private static final Path TYPICAL_PERSONS_FILE = TEST_DATA_FOLDER.resolve("typicalPersonsResearchRoster.json");
    private static final Path INVALID_PERSON_FILE = TEST_DATA_FOLDER.resolve("invalidPersonResearchRoster.json");
    private static final Path DUPLICATE_PERSON_FILE = TEST_DATA_FOLDER.resolve("duplicatePersonResearchRoster.json");

    @Test
    public void toModelType_typicalPersonsFile_success() throws Exception {
        JsonSerializableResearchRoster dataFromFile = JsonUtil.readJsonFile(TYPICAL_PERSONS_FILE,
                JsonSerializableResearchRoster.class).get();
        ResearchRoster researchRosterFromFile = dataFromFile.toModelType();
        ResearchRoster typicalPersonsResearchRoster = TypicalPersons.getTypicalAddressBook();
        assertEquals(researchRosterFromFile, typicalPersonsResearchRoster);
    }

    @Test
    public void toModelType_invalidPersonFile_throwsIllegalValueException() throws Exception {
        JsonSerializableResearchRoster dataFromFile = JsonUtil.readJsonFile(INVALID_PERSON_FILE,
                JsonSerializableResearchRoster.class).get();
        assertThrows(IllegalValueException.class, dataFromFile::toModelType);
    }

    @Test
    public void toModelType_duplicatePersons_throwsIllegalValueException() throws Exception {
        JsonSerializableResearchRoster dataFromFile = JsonUtil.readJsonFile(DUPLICATE_PERSON_FILE,
                JsonSerializableResearchRoster.class).get();
        assertThrows(IllegalValueException.class, JsonSerializableResearchRoster.MESSAGE_DUPLICATE_PERSON,
                dataFromFile::toModelType);
    }

}
