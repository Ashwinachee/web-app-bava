# Implementation Plan - Fix Hardcoded Strings in DSAActivity

The user wants to correct the error in `DSAActivity.java`. The static analysis identified hardcoded strings in `setText` and `activity_dsa.xml` that should be moved to resources.

## Proposed Changes

### [Resources]

#### [MODIFY] [strings.xml](file:///C:/Users/M.ARCHANAA/AndroidStudioProjects/PlacementPreparationApp2/app/src/main/res/values/strings.xml)
- Add `dsa_progress_format` string resource: `"DSA Progress: %d%%"`.
- Add string resources for all DSA checkbox labels to resolve XML warnings.

#### [MODIFY] [activity_dsa.xml](file:///C:/Users/M.ARCHANAA/AndroidStudioProjects/PlacementPreparationApp2/app/src/main/res/layout/activity_dsa.xml)
- Update `dsaProgressText` to use `@string/dsa_progress_format` (with 0 as default if possible, or just leave it for code to set).
- Update all `CheckBox` components to use the new string resources.

### [Java Source Files]

#### [MODIFY] [DSAActivity.java](file:///C:/Users/M.ARCHANAA/AndroidStudioProjects/PlacementPreparationApp2/app/src/main/java/com/example/placementpreparationapp/DSAActivity.java)
- Update `updateProgress()` to use `getString(R.string.dsa_progress_format, progress)`.

## Verification Plan

### Automated Tests
- Run `./gradlew app:assembleDebug` to ensure no XML or compilation errors.

### Manual Verification
- Open the DSA Preparation screen.
- Verify that the progress text still displays correctly (e.g., "DSA Progress: 70%").
- Verify that checking/unchecking items still updates the progress correctly.
