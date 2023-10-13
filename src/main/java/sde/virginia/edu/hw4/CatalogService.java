package sde.virginia.edu.hw4;

import java.util.List;
import java.util.Optional;

public class CatalogService {
    private Catalog catalog;

    /**
     * Constructor
     * @param catalog
     */
    public CatalogService(Catalog catalog) {
        this.catalog = catalog;
    }

    /**
     * Describes the result of {@link Catalog#add(Section)}
     */
    public enum AddSectionResult {
        /**
         * The section was successfully added to the Catalog
         */
        SUCCESSFUL,
        /**
         * Section not added to catalog, as it already exists in the catalog.
         */
        FAILED_SECTION_ALREADY_EXISTS,
        /**
         * Section not added because the CRN is already in-use by another course.
         */
        FAILED_CRN_CONFLICT,
        /**
         * Section not added to catalog, as the TimeSlot of this section conflicts with the time slot of another
         * section in the same location.
         */
        FAILED_LOCATION_CONFLICT,
        /**
         * Section not added to catalog, the lecturer is already teaching another class that conflicts with this
         * section's timeslot.
         */
        FAILED_LECTURER_CONFLICT
    }

    /**
     * Attempts to add a section to the course catalog, ensuring the section doesn't break any rules.
     * The rules are:<br>
     * <ol>
     *     <li>A section can only be added to the catalog once. No duplicate sections. If the section is already
     *     present, then return {@link AddSectionResult#FAILED_SECTION_ALREADY_EXISTS}</li>
     *     <li>CRNs in a given catalog must be unique. If the CRN is not unique, this returns
     *     {@link AddSectionResult#FAILED_CRN_CONFLICT}</li>
     *     <li>No two sections can use the same {@link Location} in overlapping {@link TimeSlot}s. If this rule would
     *     be violated, return {@link AddSectionResult#FAILED_LOCATION_CONFLICT}</li>
     *     <li>No lecturer can teach two sections with overlapping {@link TimeSlot}s. If this rule would be
     *     violated, return {@link AddSectionResult#FAILED_LECTURER_CONFLICT}</li>
     * </ol>
     * If any of the above rules are violated, the section <b>should not</b> be added to the catalog. However, if none
     * of the rules are violated, the section <b>should</b> be added to the catalog, and {@link AddSectionResult#SUCCESSFUL}
     * should be returned.
     * @param section the section to attempt to add to catalog
     * @return a {@link AddSectionResult} enum indicating success or the reason for failure
     * @see CatalogService#getSectionFromCRN(int)
     * @see Location
     * @see TimeSlot#overlapsWith(TimeSlot)
     * @see Lecturer
     */
    public AddSectionResult add(Section section) {
        return null;
        //TODO: implement and test
    }

    /**
     * Remove a section from the course catalog.
     * @param section the section to be removed
     * @throws IllegalArgumentException if the section is not present in the catalog
     */
    public void removeSection(Section section) {
        //TODO: implement and test
    }

    /**
     * Gets the section from a given courseRegistrationNumber (CRN)
     * @param courseRegistrationNumber a typically 5-digit number unique to a course in a given semester
     * @return An {@link Optional}
     */
    public Optional<Section> getSectionFromCRN(int courseRegistrationNumber) {
        return Optional.empty();
        //TODO: implement and test
    }

    /**
     * Get all sections where the course matches the mnemonic and courseNumber sorted by section number
     * in ascending order.
     *
     * @param mnemonic the course's mnemonic (i.e., "CS", "APMA") as a {@link String}
     * @param courseNumber the course's number as a {@String}. (i.e., "3140", "1110")
     * @return a {@link List} of sections that match the course mnemonic and number.
     */
    public List<Section> getSectionsByCourseInfo(String mnemonic, String courseNumber) {
        return null;
        //TODO: return a set of all sections in a given location
        //must be implemented using streams!
    }

    /**
     * Get all sections for a given mnemonic that are open to enrollment *and* where the enrollment
     * is not full. The list should be sorted in ascending order by course number (i.e., "1110", "2100", "3140")
     * and then by section number if the course number matches (i.e., Section 1 before Section 2)
     * @param mnemonic the course's mnemonic (i.e., "CS", "APMA") as a {@link String}
     * @return a sorted {@link List} of sections that have available seats and match the course mnemonic
     */
    public List<Section> getAvailableSectionsByMnemonic(String mnemonic) {
        return null;
        //TODO: return a set of all sections in a given location
        //must be implemented using streams!
    }
}
