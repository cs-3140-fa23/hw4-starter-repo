package sde.virginia.edu.hw4;

import java.util.Optional;

public class CatalogService {
    private Catalog catalog;

    public CatalogService(Catalog catalog) {
        this.catalog = catalog;
    }
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
         *  Section not added to catalog, as it already exists in the catalog. This course already has a section with an
         *  overlapping time slot. By rule, different sections of the same course cannot be taught at the same time.
         */
        FAILED_SCHEDULE_CONFLICT,
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

    public Optional<Section> getSectionFromCRN(int courseRegistrationNumber) {
        return Optional.empty();
        //TODO: implement and test
    }

    public AddSectionResult add(Section section) {
        return null;
        //TODO: implement and test
    }

    public void removeSection(Section section) {
        //TODO: implement and test
    }
}
